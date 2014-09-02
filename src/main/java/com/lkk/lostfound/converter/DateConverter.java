package com.lkk.lostfound.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

@SuppressWarnings("rawtypes")
public class DateConverter extends StrutsTypeConverter {

	private static final String FORMAT = "yyyy/MM/dd";

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values != null && values.length > 0 && values[0] != null
				&& values[0].length() > 0) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
			try {
				return dateFormat.parse(values[0]);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new TypeConversionException();
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map context, Object value) {

		if (value instanceof Date) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
			return dateFormat.format((Date) value);
		}
		return "";
	}
}
