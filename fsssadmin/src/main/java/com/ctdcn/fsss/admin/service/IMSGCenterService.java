package com.ctdcn.fsss.admin.service;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.entity.FsssMsgCenter;
/**
 * 消息中心接口
 * 
 * @author hwkj_fan
 * 
 */
public interface IMSGCenterService {
	/**
	 * 查询所有消息
	 * @param pageNo 页码
	 * @param pageSize 每页信息条数
	 * @return
	 */
	public Pages getInfo(int pageNo, int pageSize);
	/**
	 * 按照日期查询消息
	 * @param pageNo 页码
	 * @param pageSize 每页信息条数
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return
	 */
	public Pages getInfo2(int pageNo, int pageSize,Date start,Date end);
	/**
	 * 删除消息
	 * @param msgid消息id
	 * @return
	 */
	public int delInfo(String msgid);
	/**
	 * 保存消息并推送
	 * @param list 
	 * @param 消息对象
	 * @return
	 */
	public int setInfo_and_jpush(FsssMsgCenter fsssMsgCenter, List<String> list);
	

}
