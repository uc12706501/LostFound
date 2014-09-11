package com.lkk.lostfound.utils;

public class StringUtils {
	public static boolean isNullOrEmpty(String aString) {
		if (aString == null || aString == "")
			return true;
		return false;
	}

	public static boolean containsNullOrEmpty(String... strings) {
		for (String s : strings)
			if (isNullOrEmpty(s))
				return true;
		return false;
	}
}
