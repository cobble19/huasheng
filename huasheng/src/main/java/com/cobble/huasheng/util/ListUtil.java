package com.cobble.huasheng.util;

import java.util.Collection;

import org.apache.commons.collections.ListUtils;

public class ListUtil extends ListUtils {
	public static boolean isEmpty(Collection collection) {
		boolean ret = true;
		if (collection != null && collection.size() > 0) {
			ret = false;
		}
		return ret;
	}
	public static boolean isNotEmpty(Collection collection) {
		return !isEmpty(collection);
	}
}
