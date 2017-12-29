package com.ctdcn.fsss.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {


	public static String readForStrem(HttpServletRequest request) throws IOException {
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
}
