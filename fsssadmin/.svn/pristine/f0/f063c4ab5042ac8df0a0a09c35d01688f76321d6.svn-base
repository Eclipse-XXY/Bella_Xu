package com.ctdcn.fsss.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

public class HttpClientUtil {
	private static Logger log = Logger.getLogger(HttpClientUtil.class);

	public static String readForStrem(HttpServletRequest request)
			throws IOException {
		StringBuffer buffer = new StringBuffer(1500);
		InputStream input = null;
		BufferedReader in = null;
		String line = null;
		try {
			input = request.getInputStream();
			in = new BufferedReader(new InputStreamReader(input, "utf-8"));
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					throw e;
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					throw e;
				}
			}
		}

		return buffer.toString();
	}
	/***
	 * 以POST方式提交http请求
	 * 
	 * @param postUrl
	 *            请求链接
	 * @param params
	 *            http头信息
	 * @param postStr
	 *            请求内容
	 * @return 响应内容
	 * @throws Exception
	 */
	public static String doHttpResult(String postUrl,
			Map<String, String> params, String postStr) throws Exception {
		log.info("向" + postUrl + "发送的内容=" + postStr);
		Reader reader = doHttpPost(postUrl, params, postStr);
		char[] cbuf = new char[1024];
		StringBuffer sb = new StringBuffer(50 * 1024);

		int length = 0;
		// 将字符读入数组。读取的字符数，如果已到达流的末尾，则返回 -1
		try {
			while ((length = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, length);
			}
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			throw e;
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
			}
		}
		log.info(postUrl + "返回结果= " + sb);
		return sb.toString();
	}

	private static Reader doHttpPost(String postUrl,
			Map<String, String> headerParams, String postXml) throws Exception {
		PostMethod post = new PostMethod(postUrl);
		if (postXml != null) {
			StringRequestEntity entity = new StringRequestEntity(postXml,
					"text/xml; charset=utf-8", "utf-8");
			post.setRequestEntity(entity);
		}
		post.setRequestHeader("Content-type", "text/xml; charset=utf-8");
		post.addRequestHeader("Connection", "close");

		if (headerParams != null) {
			for (Iterator<String> it = headerParams.keySet().iterator(); it
					.hasNext();) {
				String key = it.next();
				post.addRequestHeader(key, headerParams.get(key));
			}
		}
		HttpClient httpclient = new HttpClient();

		// 1.Sets the timeout in milliseconds used when retrieving an
		// HttpConnection from the HttpConnectionManager
		httpclient.getParams().setLongParameter(
				HttpClientParams.CONNECTION_MANAGER_TIMEOUT, 10 * 1000);
		// 2.Sets period of time in milliseconds to wait for a content body sent
		// in response to
		httpclient.getParams().setLongParameter(
				HttpClientParams.HEAD_BODY_CHECK_TIMEOUT, 3 * 1000);
		// 3.Determines the timeout until a connection is etablished
		httpclient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(3 * 1000);

		// 4.Sets the socket timeout in milliseconds to be used when executing
		// the method.
		post.getParams().setSoTimeout(5 * 1000);
		// 指定重试次数，以及是否需要试重，连接超时[3]发生时不重试
		DefaultHttpMethodRetryHandler dhr = new DefaultHttpMethodRetryHandler(
				2, true);
		post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, dhr);

		try {

			int result = httpclient.executeMethod(post);
			log.info(postUrl + " 返回http状态码=" + result);
			if (result == HttpStatus.SC_OK) {
				InputStream is = new ByteArrayInputStream(
						post.getResponseBody());
				return new InputStreamReader(is, "UTF-8");
			} else {
				throw new Exception(postUrl + "||返回http错误码=" + result);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			post.releaseConnection();
		}
	}
}