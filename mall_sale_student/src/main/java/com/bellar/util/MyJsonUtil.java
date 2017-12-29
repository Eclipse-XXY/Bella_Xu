package com.bellar.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.bellar.bean.T_MALL_SHOPPINGCAR;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import net.sf.json.JSONArray;

public class MyJsonUtil {
public static void main(String[] args) throws UnsupportedEncodingException {
	List<T_MALL_SHOPPINGCAR> list_car=new ArrayList<>();
	for (int i = 0; i < 3; i++) {
		T_MALL_SHOPPINGCAR t_MALL_SHOPPINGCAR=new T_MALL_SHOPPINGCAR();
		t_MALL_SHOPPINGCAR.setSku_mch("商品" + i	);
		t_MALL_SHOPPINGCAR.setSku_jg(i * 1000);
		list_car.add(t_MALL_SHOPPINGCAR);
	}
	//方法一对于goole提供的额JSON的工具gson的使用  但是需要使用typeToken进行JSON到集合的解析
	//typeToken是受保护的类所以使用匿名内部内的方式进行使用
	Gson gson = new Gson();
	String json = gson.toJson(list_car);
	//注意enc的参数表示的是字符的编码
	String encode = URLEncoder.encode(json,"utf-8");
	String decode = URLDecoder.decode(encode, "utf-8");
	TypeToken<List<T_MALL_SHOPPINGCAR>> typeToken = new TypeToken<List<T_MALL_SHOPPINGCAR>>() {};
	List<T_MALL_SHOPPINGCAR> list = (List<T_MALL_SHOPPINGCAR>)gson.fromJson(decode, typeToken.getType());
	System.out.println(list.toString());
	
	//方法二对于传统提供的JSONlib的使用
	JSONArray fromObject = JSONArray.fromObject(list_car);
	String string = fromObject.toString();
	System.err.println(string);
	JSONArray fromObject2 = JSONArray.fromObject(string);
	List<T_MALL_SHOPPINGCAR> list_array = (List<T_MALL_SHOPPINGCAR> ) JSONArray.toCollection(fromObject2,T_MALL_SHOPPINGCAR.class);
	System.out.println(list_array);
	
	//方法三对于阿里提供的jaskjson
	String jsonString = JSON.toJSONString(list_car);
	List<T_MALL_SHOPPINGCAR> parseArray = JSON.parseArray(jsonString, T_MALL_SHOPPINGCAR.class);
	System.out.println(parseArray.size());
}
//工具类的封装
	public static <T> String list_to_json(List<T> list){

		Gson gson = new Gson();
		String json = gson.toJson(list);

		try {
			json = URLEncoder.encode(json, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;

	}
  public static <T> List<T> json_to_list(String json,Class<T> t){
	  String decode="";
	  try {
		  decode=URLDecoder.decode(json,"utf-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	  JSONArray fromObject = JSONArray.fromObject(decode);
		List<T> list_array = (List<T>)JSONArray.toCollection(fromObject,t);
	  return list_array;
	  
  }
}