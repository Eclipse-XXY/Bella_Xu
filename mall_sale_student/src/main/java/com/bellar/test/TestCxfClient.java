package com.bellar.test;


import com.bellar.bean.T_MALL_USER_ACCOUNT;
import com.bellar.service.UserServiceInf;
import com.bellar.util.MyWsFactory;

public class TestCxfClient {
//客户端使用工具类调用cxf  
	//UserServiceInf这个接口是调用别人的webservice的到的接口拿过来直接使用
	public static void main(String[] args) {
	String url="http://localhost/mall_user_service_student/user?wsdl";
		UserServiceInf myWsInf = MyWsFactory.getMyWsInf(url, UserServiceInf.class);
		T_MALL_USER_ACCOUNT user=new T_MALL_USER_ACCOUNT();
		user.setYh_mch("lilei");
		user.setYh_mm("123");
		T_MALL_USER_ACCOUNT login = myWsInf.login(user);
System.out.println(login);
	}

}
