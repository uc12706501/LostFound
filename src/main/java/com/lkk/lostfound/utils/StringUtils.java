package com.lkk.lostfound.utils;

public class StringUtils {
	public static boolean isNullOrEmpty(String aString) {
		if (aString == null || aString.isEmpty())
			return true;
		return false;
	}
}
