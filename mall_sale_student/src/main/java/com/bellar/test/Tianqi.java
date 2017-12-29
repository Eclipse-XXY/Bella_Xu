package com.bellar.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
public class Tianqi {
//	/**
//	 * 网络访问工具类
//	 * @author silk
//	 *
//	 */
//	    /**
//	     * get方法直接调用post方法
//	     * @param url 网络地址
//	     * @return 返回网络数据
//	     */
//	    public static String get(String url){
//	        return post(url,null);
//	    }
//	    /**
//	     * 设定post方法获取网络资源,如果参数为null,实际上设定为get方法
//	     * @param url 网络地址
//	     * @param param 请求参数键值对
//	     * @return 返回读取数据
//	     */
//	   public static  String post(String  url,Map map){
//	        HttpURLConnection conn=null;
//	        try {
//	            URL u=new URL(url);
//	            conn=(HttpURLConnection) u.openConnection();
//	            StringBuffer sb=null;
//	            if(map!=null){//如果请求参数不为空
//	                sb=new StringBuffer();
//	                /*A URL connection can be used for input and/or output.  Set the DoOutput
//	                 * flag to true if you intend to use the URL connection for output,
//	                 * false if not.  The default is false.*/
//	                //默认为false,post方法需要写入参数,设定true
//	                conn.setDoOutput(true);
//	                //设定post方法,默认get
//	                conn.setRequestMethod("POST");
//	                //获得输出流
//	                OutputStream out=conn.getOutputStream();
//	                //对输出流封装成高级输出流
//	                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out));
//	                //将参数封装成键值对的形式
//	                for(Map.Entry s:map.entrySet()){
//	                    sb.append(s.getKey()).append("=").append(s.getValue()).append("&");
//	                }
//	                //将参数通过输出流写入
//	                writer.write(sb.deleteCharAt(sb.toString().length()-1).toString());
//	                writer.close();//一定要关闭,不然可能出现参数不全的错误
//	                sb=null;
//	            }
//	            conn.connect();//建立连接
//	            sb=new StringBuffer();
//	            //获取连接状态码
//	            int recode=conn.getResponseCode();
//	            BufferedReader reader=null;
//	            if(recode==200){
//	                //Returns an input stream that reads from this open connection
//	                //从连接中获取输入流
//	                InputStream in=conn.getInputStream();
//	                //对输入流进行封装
//	                reader=new BufferedReader(new InputStreamReader(in));
//	                String str=null;
//	                sb=new StringBuffer();
//	                //从输入流中读取数据
//	                while((str=reader.readLine())!=null){
//	                    sb.append(str).append(System.getProperty("line.separator"));
//	                }
//	                //关闭输入流
//	                reader.close();
//	                if (sb.toString().length() == 0) {
//	                    return null;
//	                }
//	                return sb.toString().substring(0,
//	                        sb.toString().length() - System.getProperty("line.separator").length());
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return null;
//	        }finally{
//	            if(conn!=null)//关闭连接
//	                conn.disconnect();
//	        }
//	        return null;
//	    }
//	  
//	}

//	Demo2:调用获取城市列表接口示例
//
//		
//	package juheAPI;
//	 
//	import net.sf.json.JSONArray;
//	import net.sf.json.JSONObject;
//	 
//	 
//	/**
//	 * 获取城市列表
//	 * 全国天气预报接口调用JAVA示例
//	 *     dtype     string    N    返回数据格式：json或xml,默认json    
//	 *     key        string     Y    你申请的key    
//	 * @author silk
//	 *
//	 */
//	public class GetCityList {
//	    /**
//	     * 调用获取城市列表接口,返回所有数据
//	     * @return 返回接口数据
//	     */
//	    public static String excute(){
//	        String url="http://v.juhe.cn/weather/citys?key=***a7558b2e0bedaa19673f74a6809ce";//接口URL
//	        //PureNetUtil是一个封装了get和post方法获取网络请求数据的工具类
//	        return PureNetUtil.get(url);//使用get方法
//	    }
//	    /**
//	     * 调用接口返回数据后,解析数据,根据输入城市名得到对应ID
//	     * @param cityName 城市名称
//	     * @return 返回对应ID
//	     */
//	    public static String getIDBycityName(String cityName) {
//	        String result=excute();//返回接口结果,得到json格式数据
//	        if(result!=null){
//	            JSONObject obj=JSONObject.fromObject(result);
//	            result=obj.getString("resultcode");//得到返回状态码
//	            if(result!=null&&result.equals("200")){//200表示成功返回数据
//	                result=obj.getString("result");//得到城市列表的json格式字符串数组
//	                JSONArray arr=JSONArray.fromObject(result);
//	                for(Object o:arr){//对arr进行遍历
//	                    //将数组中的一个json个数字符串进行解析
//	                    obj=JSONObject.fromObject(o.toString());
//	                    /*此时obj如 {"id":"2","province":"北京","city":"北京","district":"海淀"}*/
//	                    //以city这个key为线索判断所需要寻找的这条记录
//	                    result=obj.getString("district");
//	                    //防止输入城市名不全,如苏州市输入为苏州,类似与模糊查询
//	                    if(result.equals(cityName)||result.contains(cityName)){
//	                        result=obj.getString("id");//得到ID
//	                        return result;
//	                    }
//	                }
//	            }
//	        }
//	        return result;
//	    }
//	    public static void main(String[] args) {
//	        System.out.println(getIDBycityName("香港"));
//	    }
//	}

//	Demo3:调用根据城市名/id查询天气
//	
//	package juheAPI;
//	 
//	import net.sf.json.JSONObject;
//	 
//	 
//	/**
//	 * 根据城市名/id查询天气
//	 * @author silk
//	 *
//	 */
//	public class WeatherReportByCity {
//	    /**
//	     * 根据城市名获取
//	     * @param cityName
//	     * @return
//	     */
//	    public static String excute(String cityName){
//	        String url=//此处以返回json格式数据示例,所以format=2,以根据城市名称为例,cityName传入中文
//	                "http://v.juhe.cn/weather/index?cityname="+cityName+"&key=***a7558b2e0bedaa19673f74a6809ce";
//	        return PureNetUtil.get(url);//通过工具类获取返回数据
//	    }
//	    /**
//	     * 获取返回数据中的一个属性示例,此处以获取今日温度为例
//	     * "temperature": "8℃~20℃"     今日温度
//	     * @param args
//	     * @return 
//	     */
//	    public static String GetTodayTemperatureByCity(String city) {
//	        String result=excute(city);
//	        if(result!=null){
//	            JSONObject obj=JSONObject.fromObject(result);
//	            /*获取返回状态码*/
//	            result=obj.getString("resultcode");
//	            /*如果状态码是200说明返回数据成功*/
//	            if(result!=null&&result.equals("200")){
//	                result=obj.getString("result");
//	                //此时result中数据有多个key,可以对其key进行遍历,得到对个属性
//	                obj=JSONObject.fromObject(result);
//	                //今日温度对应的key是today
//	                result=obj.getString("today");
//	                obj=JSONObject.fromObject(result);
//	                //今日温度对应当key是temperature
//	                result=obj.getString("temperature");
//	                return result;
//	            }
//	        }
//	        return result;
//	    }
//	    public static void main(String[] args) {
//	        System.out.println(GetTodayTemperatureByCity("苏州"));
//	    }
//	}

//	Demo4:调用天气种类及表示列表接口示例
//		
//	package juheAPI;
//	 
//	import net.sf.json.JSONArray;
//	import net.sf.json.JSONObject;
//	 
//	 
//	/**
//	 * 天气种类及标识列表接口调用JAVA示例
//	 * @author silk
//	 */
//	public class GetWeatherSignAndTypeList {
//	    //接口地址,因为只需要传入一个固定的key为参数,所以设为常量
//	    private static final String URL= "http://v.juhe.cn/weather/uni?key=***a7558b2e0bedaa19673f74a6809ce";
//	    /**
//	     * 通过工具类获取数据
//	     * @return
//	     */
//	    public static String excute(){
//	        return PureNetUtil.get(URL);//调用工具类获取接口数据
//	    }
//	    /**
//	     * 利用遍历数组的方式获取
//	     * @param wid天气对应id
//	     * @return 天气名称
//	     */
//	    public static String getWeatherByWid(String wid) {
//	        String result=excute();//获取接口数据
//	        if(result!=null){
//	            JSONObject obj=JSONObject.fromObject(result);
//	            result=obj.getString("resultcode");
//	            /*获取返回状态码*/
//	            if(result!=null&&result.equals("200")){
//	                /*获取数组数据*/
//	                result=obj.getString("result");
//	                JSONArray arr=JSONArray.fromObject(result);
//	                for(Object o:arr){//遍历数组
//	                    obj=JSONObject.fromObject(o.toString());
//	                    //如果遍历到需要的数据后直接返回结果,根据key(wid)得到value判断是否等于传入参数
//	                    if(obj.getString("wid").equals(wid)){
//	                        result=obj.getString("weather");
//	                        return result;
//	                    }
//	                }
//	            }
//	        }
//	        return result;
//	    }
//	    public static void main(String[] args) {
//	        System.out.println(getWeatherByWid("10"));
//	    }
//	}
//}
}
