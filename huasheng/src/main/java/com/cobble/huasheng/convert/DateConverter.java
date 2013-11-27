package com.cobble.huasheng.convert;

import org.apache.commons.beanutils.Converter;

public class DateConverter implements Converter {

	public Object convert(Class type, Object value) {
		if (null == value) {
			return null;
		}
		return value;
	}

}
