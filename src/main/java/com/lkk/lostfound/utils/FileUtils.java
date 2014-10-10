package com.lkk.lostfound.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

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

	public static InputStream getNoImageInputStream(String text) {
		try {
			BufferedImage bi = new BufferedImage(120, 40,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = bi.getGraphics();

			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 120, 40);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Serif", Font.BOLD, 22));
			g.drawString(text, 5, 35);

			File tempImg = File.createTempFile("tempImg", "jpg");
			tempImg.deleteOnExit();
			ImageIO.write(bi, "jpeg", tempImg);

			return new FileInputStream(tempImg);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
