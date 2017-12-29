package com.ctdcn.fsss.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctdcn.fsss.admin.common.Configuration;
import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.dao.FsssMsgCenterMapper;
import com.ctdcn.fsss.admin.entity.FsssMsgCenter;
import com.ctdcn.fsss.admin.entity.FsssMsgCenterExample;
import com.ctdcn.fsss.admin.service.IMSGCenterService;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

@Service
public class MSGCenterService implements IMSGCenterService {
	@Autowired
	FsssMsgCenterMapper fsssMsgCenterMapper;
	protected static final Logger LOG = LoggerFactory.getLogger(MSGCenterService.class);
	private String apiKey = "";
	private String secretKey = "";
	
	@Override
	public int setInfo_and_jpush(FsssMsgCenter fsssMsgCenter,List<String> list) {
		addM(fsssMsgCenter);//添加字段
		int insert = 0;
		String aliases = fsssMsgCenter.getUserid();
		int sendtarget =fsssMsgCenter.getSendtarget();
		LOG.info("Got result ================================== "+aliases+" "+sendtarget+"=====");
		if((aliases == null || "".equals(aliases)) && sendtarget == 1){
			for (String l : list) {
				String msgid = createMsgid();
				fsssMsgCenter.setMsgid(msgid);
				aliases = l;
				fsssMsgCenter.setUserid(aliases);
				if(fsssMsgCenter.getJpush() == 0){
					jpush(fsssMsgCenter,sendtarget,msgid,aliases);
				}
				insert = fsssMsgCenterMapper.insert(fsssMsgCenter);
			}
		}else{
			String msgid = createMsgid();
			fsssMsgCenter.setMsgid(msgid);
			if(fsssMsgCenter.getJpush() == 0){
				jpush(fsssMsgCenter,sendtarget,msgid,aliases);
			}
			insert = fsssMsgCenterMapper.insert(fsssMsgCenter);
		}
		return insert;
	}
	private void jpush(FsssMsgCenter fsssMsgCenter,int sendtarget,String msgid,String aliases){
		//推送
		initKey();//获取api和secretKey
		JPushClient client = new JPushClient(secretKey, apiKey);
		Long timetolive = Long.valueOf(0); timetolive =fsssMsgCenter.getRetentiontime();//消息保留时间
		int platform = fsssMsgCenter.getPlatform();//平台
		String message = fsssMsgCenter.getDescr();//消息内容
		String title = fsssMsgCenter.getTitle();
		int sound = 0;sound = fsssMsgCenter.getSound();
		int type = 0;
		PushPayload payload = buildPushObject_android_and_ios(sendtarget,type,sound, msgid,platform,message,title,timetolive, aliases);
		// isdev 为1表示开发模式，0表示生产模式
		if ("0".equals(Configuration.getInstance().getConfiguration("isdev"))) {
			// 这个是在生产环境中用的
			payload.resetOptionsApnsProduction(true);
		}
		try {
			PushResult result = client.sendPush(payload);
			LOG.info("Got result ================================== " + result);
			client.close();
		} catch (APIConnectionException | APIRequestException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 添加部分表格中没有的数据  
	 * 1.消息创建时间createtime  2.消息类型 msgstyle 
	 * 3.是否已推送 msgstate 4.推送时间（表格中有进一步处理）
	 * 5.大标题bigtitle
	 * @param fsssMsgCenter
	 * @return
	 */
	private static FsssMsgCenter addM(FsssMsgCenter fsssMsgCenter){
		Date createtime = new Date();//创建时间
		
		fsssMsgCenter.setMsgstyle(0);// 0：i社保消息
		fsssMsgCenter.setBigtitle("i社保通知");
		Date sendtime = fsssMsgCenter.getSendtime();
		if(sendtime == null || "".equals(sendtime)){
			fsssMsgCenter.setSendtime(createtime);
		}else{
			fsssMsgCenter.setSendtime(sendtime);
		}
		if(sendtime == null || "".equals(sendtime) ){
			sendtime = new Date();
		}
		fsssMsgCenter.setCreatetime(createtime);//消息创建时间
		if(createtime.getTime()<sendtime.getTime()){
			fsssMsgCenter.setMsgstate(0);//消息推送状态  0 未推送 1 已推送
		}else{
			fsssMsgCenter.setMsgstate(1);
		}
		return fsssMsgCenter;
	}
	/**
	 * 创建msgid 10+当前时间+3位随机数（100-999）
	 * @return msgid
	 */
	private static String createMsgid() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
		int random = (int)(Math.random()*900+100);
		String msgid = "10"+sdf.format(new Date())+random;
		return msgid;
	}
	/**		设置PushPayload	 别名实例990101199209253220
	 * @param sound 
	 * @param sound2 
	 * @param msgid 
	 * @param timetolive 消息存活时间
	 * @param title 标题 
	 * @param message 消息内容
	 * @param platform 平台
	 * @param aliases 别名 （身份证号）990101199209253220
	 */														  
	private static PushPayload buildPushObject_android_and_ios( int sendtarget,int type,int sound, String msgid, int platform, String message, String title, Long timetolive, String aliases) {
		PushPayload.Builder builder = PushPayload.newBuilder()
				.setPlatform(Platform.android_ios())
				.setOptions(Options.newBuilder().setTimeToLive(timetolive).build());
		if(sendtarget == 0){			
			return builder.setAudience(Audience.all())
					.setNotification(Notification.newBuilder().setAlert(title).build())
					.build();
//			return null;//测试环境不要推送全部用户，使用这个
		}else{
			if(platform == 0){
				return  builder.setAudience(Audience.alias(aliases))
						.setNotification(Notification.newBuilder().setAlert(message)
								.addPlatformNotification(AndroidNotification.newBuilder().addExtra("sound", sound).addExtra("msgid", msgid).addExtra("type", type).setTitle(title).build())
								.addPlatformNotification(IosNotification.newBuilder().addExtra("sound", sound).addExtra("msgid", msgid).addExtra("type", type).incrBadge(1).build())
								.build())
						.build();
			}else if(platform == 1){
				return  builder.setAudience(Audience.alias(aliases))
						.setNotification(Notification.newBuilder().setAlert(message)
								.addPlatformNotification(AndroidNotification.newBuilder().addExtra("sound", sound).addExtra("msgid", msgid).addExtra("type", type).setTitle(title).build())
								.build())
						.build();
			}else{
				return  builder.setAudience(Audience.alias(aliases))
						.setNotification(Notification.newBuilder().setAlert(message)
								.addPlatformNotification(IosNotification.newBuilder().addExtra("sound", sound).addExtra("msgid", msgid).addExtra("type", type).incrBadge(1).build())
								.build())
						.build();
			}
			
		}
	}
	private void initKey() {
		// 判断发送目标是用户端 
		apiKey = Configuration.getInstance().getConfiguration("apiKey");
		secretKey = Configuration.getInstance().getConfiguration("secretKey");
//		registrationId = Configuration.getInstance().getConfiguration("registration_id");
	}
	
	//查询
	@Override
	public Pages getInfo(int pageNo, int pageSize) {
		Pages pages = new Pages();
		List list =new  ArrayList();
		
		FsssMsgCenterExample example =new FsssMsgCenterExample();
		example.setStart((pageNo - 1) * pageSize);
		example.setLimit(pageSize);
		
		list = fsssMsgCenterMapper.selectByExampleWithBLOBs(example);
		pages.setRows(list);
		
		return pages;
	}
	@Override
	public Pages getInfo2(int pageNo, int pageSize,Date date1, Date date2) {
		Pages pages = new Pages();
		List list =new  ArrayList();
		
		FsssMsgCenterExample example =new FsssMsgCenterExample();
		example.setStart((pageNo - 1) * pageSize);
		example.setLimit(pageSize);
		
		example.createCriteria().andSendtimeBetween(date1, date2);
		int count = (int) fsssMsgCenterMapper.countByExample(example);
		pages.setTotal(count);
		
		list = fsssMsgCenterMapper.selectByExample(example);
		pages.setRows(list);
		return pages;
	}
	@Override
	public int delInfo(String msgid) {
		FsssMsgCenterExample example =new FsssMsgCenterExample();
		example.createCriteria().andMsgidEqualTo(msgid);
		int deleteByPrimaryKey = fsssMsgCenterMapper.deleteByExample(example);
		return deleteByPrimaryKey;
	}
	
}
