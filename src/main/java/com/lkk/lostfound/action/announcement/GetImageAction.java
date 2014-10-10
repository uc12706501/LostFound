package com.lkk.lostfound.action.announcement;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.lkk.lostfound.utils.FileUtils;
import com.lkk.lostfound.utils.ImageUtils;

public class GetImageAction extends SingleAnnouncementActionBase {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int maxHeight;

	public InputStream getInputStream() throws IOException {
		if (model != null && model.getImage() != null) {
			byte[] image = model.getImage();
			if (maxHeight != 0)
				image = ImageUtils.compress(image, maxHeight, 0);
			return new ByteArrayInputStream(image);
		}
		return FileUtils.getNoImageInputStream("No Image");
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
}
