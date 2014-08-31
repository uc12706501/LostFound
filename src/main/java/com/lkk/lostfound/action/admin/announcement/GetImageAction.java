package com.lkk.lostfound.action.admin.announcement;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import com.lkk.lostfound.model.User;

public class GetImageAction extends SingleAnnouncementActionBase {
	public InputStream getInputStream() {
		if (model != null && model.getImage() != null)
			return new ByteArrayInputStream(model.getImage());
		// TODO: 添加默认图片的返回
		return null;
	}
}
