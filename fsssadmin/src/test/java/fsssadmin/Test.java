package fsssadmin;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ctdcn.fsss.admin.common.Configuration;

public class Test {
	public static void main(String[] args) {
		date();
		testConfig();
	}
	private static void date(){
		Date now =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
		int random = (int)(Math.random()*90+10);
		String msgid = "010"+sdf.format(now)+random;
		System.out.println(System.currentTimeMillis());
		System.out.println(msgid+"=======");
	}
	private static void testConfig(){
		String apiKey = Configuration.getInstance().getConfiguration("apiKey");
		String secretKey = Configuration.getInstance().getConfiguration("secretKey");
		String registration_id = Configuration.getInstance().getConfiguration("registration_id");
		System.out.println(apiKey);
		System.out.println(secretKey);
		System.out.println(registration_id);
	}
}
