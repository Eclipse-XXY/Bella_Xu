package fsssadmin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctdcn.fsss.admin.common.Configuration;
import com.ctdcn.fsss.admin.service.impl.MSGCenterService;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class TestJpush {
	private static String apiKey = "";
	private static String secretKey = "";
	protected static final Logger LOG = LoggerFactory.getLogger(MSGCenterService.class);

	public static void main(String[] args) {
		test();
	}

	public static int test() {
		int platform = 0;// 平台
		String message = "1234测试";// 消息内容
		String title = "测试内容";// 消息标题 大标题+空格+小标题
		long timetolive = 60;// 消息保留时间
		int sendtarget = 1;
		String msgid = "11111222223333344444";
		String aliases = "990101199209253220";//990101198608234524  990101199209253220
		String clientType = "0";
		initKey();
		JPushClient client = new JPushClient(secretKey, apiKey);
		PushPayload payload = buildPushObject_android_and_ios(msgid,platform, message, title, timetolive, sendtarget,
				aliases);
		payload.resetOptionsApnsProduction(false);
		// isdev 为1表示开发模式，0表示生产模式
//		if ("0".equals(Configuration.getInstance().getConfiguration("isdev"))) {
//			// 这个是在生产环境中用的
//			payload.resetOptionsApnsProduction(true);
//		}
		try {
			System.out.println("==================================" + payload.toString());
			PushResult result = client.sendPush(payload);
			System.out.println("Got result ================================== " + result);
			client.close();
		} catch (APIConnectionException | APIRequestException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @param msgid 
	 * @param user_id2
	 *            未使用
	 * @param platform
	 * @param message
	 * @param title
	 * @param timetolive
	 * @param sendtarget
	 * @param aliases
	 * @return
	 */
	public static PushPayload buildPushObject_android_and_ios(String msgid, int platform, String message, String title,
			Long timetolive, int sendtarget, String aliases) {
		PushPayload.Builder builder = PushPayload.newBuilder()
				.setPlatform(Platform.android_ios())
//				.setMessage(Message.newBuilder().setMsgContent(message).build())
				.setOptions(Options.newBuilder().setTimeToLive(timetolive).build());
		return  builder.setAudience(Audience.alias(aliases))
				.setNotification(Notification.newBuilder().setAlert(message)
						.addPlatformNotification(AndroidNotification.newBuilder().addExtra("msgid", msgid).addExtra("", msgid).setTitle(title).build())
						.addPlatformNotification(IosNotification.newBuilder().addExtra("msgid", msgid).incrBadge(1).build())
						.build())
				.build();
	}

	private static void initKey() {
		// 判断发送目标是用户端
		apiKey = Configuration.getInstance().getConfiguration("apiKey");
		secretKey = Configuration.getInstance().getConfiguration("secretKey");
		// registrationId =
		// Configuration.getInstance().getConfiguration("registration_id");
	}
}
