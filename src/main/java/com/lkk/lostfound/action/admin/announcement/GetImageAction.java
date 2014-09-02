package com.lkk.lostfound.action.admin.announcement;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GetImageAction extends SingleAnnouncementActionBase {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public InputStream getInputStream() {
		if (model != null && model.getImage() != null)
			return new ByteArrayInputStream(model.getImage());
		// TODO 添加默认图片的返回
		return null;
	}
}
