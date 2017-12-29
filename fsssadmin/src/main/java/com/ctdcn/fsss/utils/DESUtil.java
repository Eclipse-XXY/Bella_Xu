package com.ctdcn.fsss.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DESUtil {
	private static String DESKey = "ihw20140101";

	public DESUtil(String key) {
		setDESKey(key);
	}

	private static byte[] iv1 = { (byte) 0x12, (byte) 0x34, (byte) 0x56,
			(byte) 0x78, (byte) 0x90, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF };

	public byte[] desEncrypt(byte[] plainText) throws Exception {
		IvParameterSpec iv = new IvParameterSpec(iv1);

		DESKeySpec dks = new DESKeySpec(DESKey.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		byte data[] = plainText;
		byte encryptedData[] = cipher.doFinal(data);
		return encryptedData;
	}

	public byte[] desDecrypt(byte[] plainText) throws Exception {
		IvParameterSpec iv = new IvParameterSpec(iv1);

		DESKeySpec dks = new DESKeySpec(DESKey.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		byte data[] = plainText;
		byte encryptedData[] = cipher.doFinal(data);
		return encryptedData;
	}

	public String encrypt(String input) {
		String result = "input";
		try {
			result = Base64Util.encodeToString(desEncrypt(input.getBytes()),
					Base64Util.DEFAULT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String d = result.substring(result.length() - 1);
		if (d.equals("\n")) {
			result = result.substring(0, result.length() - 1);
		}

		return result;
	}

	public String decrypt(String output) {
		String result = "output";
		try {
			result = new String(desDecrypt(Base64Util.decode(output,
					Base64Util.DEFAULT)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static String getDESKey() {
		return DESKey;
	}

	public static void setDESKey(String dESKey) {
		DESKey = dESKey;
	}

	public static void main(String[] args) {

		String aaa = DESUtil.imageNameTo("20140731174211_966");
		String bbbb = DESUtil.imageNameBack(aaa);

		System.out.println("aaa===" + aaa + "==bbbb===" + bbbb);
	}

	static String[] key = { "Q", "a", "Z", "w", "S", "x", "E", "d", "C", "r" };
	static String keystr = "QaZwSxEdCr";

	// 图片名称加密
	public static String imageNameTo(String str) {
		char[] bm = str.toCharArray();
		String aa = "";
		for (int i = 0; i < bm.length; i++) {
			if ("_".equals(String.valueOf(bm[i]))) {
				aa += "_";
			} else {
				aa += key[Integer.parseInt(String.valueOf(bm[i]))];
			}
		}
		return aa;
	}

	// 图片名称解密
	public static String imageNameBack(String str) {
		char[] bm = str.toCharArray();
		String aa = "";
		for (int i = 0; i < bm.length; i++) {
			if ("_".equals(String.valueOf(bm[i]))) {
				aa += "_";
			} else {
				aa += keystr.indexOf(String.valueOf(bm[i]));
			}
		}
		return aa;
	}
	// public static String to(String str) {
	// int to = -3;
	// char[] bm = str.toCharArray();
	// char[] bm1 = new char[bm.length];
	// for (int i = 0; i < bm.length; i++) {
	// int j = bm[i];
	// char ee = (char) (j + to);
	// bm1[i] = ee;
	// }
	// String str1 = String.valueOf(bm1);
	// return str1;
	// }
	//
	// public static String back(String str) {
	// int to = +3;
	// char[] bm = str.toCharArray();
	// char[] bm1 = new char[bm.length];
	// for (int i = 0; i < bm.length; i++) {
	// int j = bm[i];
	// char ee = (char) (j + to);
	// bm1[i] = ee;
	// }
	// String str1 = String.valueOf(bm1);
	// return str1;
	// }
}
