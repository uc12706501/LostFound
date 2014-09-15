package com.lkk.lostfound.action.announcement;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.lkk.lostfound.utils.FileUtils;

public class GetImageAction extends SingleAnnouncementActionBase {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// todo 限制图片的大小、格式
	public InputStream getInputStream() {
		if (model != null && model.getImage() != null)
			return new ByteArrayInputStream(model.getImage());
		return FileUtils.getNoImageInputStream("No Image");
	}
}
