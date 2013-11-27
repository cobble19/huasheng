package com.cobble.huasheng.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;

import com.cobble.huasheng.convert.DateConverter;


public class BeanUtil extends BeanUtils {
	/*static {
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);  
        ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);  
        ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
	}*/
	static {
        ConvertUtils.register(new DateConverter(), java.util.Date.class);
        ConvertUtils.register(new DateConverter(), java.sql.Date.class);
        ConvertUtils.register(new DateConverter(), java.sql.Timestamp.class);
        ConvertUtils.register(new IntegerConverter(null), java.lang.Integer.class);
        ConvertUtils.register(new LongConverter(null), java.lang.Long.class);
    }
	public static void copyProperties(Object dest, Object orig) {
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
