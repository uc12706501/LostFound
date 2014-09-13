package com.lkk.lostfound.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public static List<String> split(String toSplit, String regex) {
		return new ArrayList<String>(Arrays.asList(toSplit.split(regex)));
	}
}
