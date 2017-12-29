package com.ctdcn.fsss.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomUtils {
	// ----追加0----start----
	public static String padZero(String target, int maxLength) {
		// 如果目标对象为空或者 最大的长度小于当前目标对象的长度，是错误的
		if (RandomUtils.isEmpty(target) || maxLength < target.length()) {
			return null;
		}

		StringBuffer where = new StringBuffer();

		int wLength = target.length();
		where.append(target);
		addZero(where, maxLength - wLength);

		return where.toString();
	}

	/** 追加零 */
	protected static void addZero(StringBuffer to, int howMany) {
		for (int i = 0; i < howMany; i++)
			to.append("0");
	}

	/**
	 * 判断一个字符串是否是null或者空格或者空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str != null && str.trim().length() > 0) {
			return false;
		}
		return true;
	}

	// ----追加0----end----

	// ----生成随机数----start----
	/**
	 * 从1~9取一个随机数
	 * 
	 * @return
	 */
	public static int getUnitRandom() {
		int random = new Random().nextInt(9);
		return random == 0 ? getUnitRandom() : random;
	}

	/**
	 * 取一个指定长度的随机数
	 * 
	 * @param length
	 * @return
	 */
	public static int getRandomNum(int length) {
		int num = getUnitRandom();
		for (int i = 2; i <= length; i++) {
			num = num + (int) Math.pow(10, i - 1) * getUnitRandom();
		}

		return num;
	}

	/**
	 * 取一个指定长度的随机数组
	 * 
	 * @param length
	 *            长度
	 * @param count
	 *            随机数个数
	 * @return
	 */
	public static List<Integer> getRandomArray(int length, int count) {
		List<Integer> randomArray = new ArrayList<Integer>(count);

		int countLength = String.valueOf(count).length();

		// 当随机数长度小于数组长度相等时，不符合逻辑
		if (length < countLength) {
			throw new NullPointerException();
		}

		// 当随机数长度与数组长度相等时，
		if (length == countLength) {

			// 当随机数长度与数组长度相差小于10，不符合逻辑
			if (length != 1 && (int) Math.pow(10, length) - count < 10) {
				throw new NullPointerException();
			}

			// 生成有序数组
			for (int i = 0; i < count; i++) {
				randomArray.add(i + (int) Math.pow(10, length - 1));
			}
		} else {
			for (int i = 1; i <= count; i++) {
				// 补差位
				int diffUnitNum = getRandomNum(length - countLength) * (int) Math.pow(10, countLength);
				// i，尾数
				randomArray.add(i + diffUnitNum);
			}
		}

		Collections.shuffle(randomArray);
		return randomArray;
	}

	// ----生成随机数----end----

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 追加0测试
		// String ss = padZero("9", 6);
		// System.out.println(ss);
		// 生成随机数测试
		// System.out.println(getRandomNum(2));
		List<Integer> list = getRandomArray(6, 5);
		System.out.println(list);
		System.out.println(new HashSet<Integer>(list).size());
		// System.out.println(new LinkedList<Integer>(list).pop());

		LinkedList<Integer> list1 = new LinkedList<Integer>(list);
		int qm = 0;
		for (int i = 0; i < 5; i++) {
			qm = list1.pop();
			System.out.println(qm);
			System.out.println("*****" + list1);
		}
		// LinkedList list1 = new LinkedList(list);
		// System.out.println("LinkedList:" + list1);
		// System.out.println("Pop element in the list:" + list1.pop());
		// System.out.println("LinkedList:" + list1);
		// System.out.println("Pop element in the list2:" + list1.pop());
		// System.out.println("LinkedList:" + list1);
	}
}
