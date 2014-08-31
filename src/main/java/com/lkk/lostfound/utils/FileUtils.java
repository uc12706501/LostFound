package com.lkk.lostfound.utils;

import java.io.*;

public class FileUtils {
	public static byte[] getBytesFromFile(File file) throws IOException {
		byte[] bytes = null;
		InputStream inputStream = null;
		ByteArrayOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(file);
			outputStream = new ByteArrayOutputStream();

			byte[] buffer = new byte[256];
			int len = 0;
			while ((len = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, len);
			}
			bytes = outputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (inputStream != null)
				inputStream.close();
			if (outputStream != null)
				outputStream.close();
		}
		return bytes;
	}
}
