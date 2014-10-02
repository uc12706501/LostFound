package com.lkk.lostfound.utils;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class ImageUtils {

	public static byte[] compress(byte[] source, int width, int height)
			throws IOException {
		if (width == 0 && height == 0)
			return source;
		ByteArrayInputStream in = new ByteArrayInputStream(source);
		try {
			BufferedImage img = ImageIO.read(in);
			if (height == 0) {
				height = (width * img.getHeight()) / img.getWidth();
			}
			if (width == 0) {
				width = (height * img.getWidth()) / img.getHeight();
			}
			Image scaledImage = img.getScaledInstance(width, height,
					Image.SCALE_SMOOTH);
			BufferedImage imageBuff = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			imageBuff.getGraphics().drawImage(scaledImage, 0, 0,
					new Color(0, 0, 0), null);

			ByteArrayOutputStream buffer = new ByteArrayOutputStream();

			ImageIO.write(imageBuff, "jpg", buffer);

			return buffer.toByteArray();
		} catch (IOException e) {
			throw e;
		}
	}

	public static byte[] compress(byte[] source) throws IOException {
		return ImageUtils.compress(source, 0, 500);
	}

	public static byte[] getCompressedImage(File file, int w, int h)
			throws IOException {
		byte[] fileByteArray = FileUtils.getBytesFromFile(file);
		return compress(fileByteArray, w, h);
	}
}
