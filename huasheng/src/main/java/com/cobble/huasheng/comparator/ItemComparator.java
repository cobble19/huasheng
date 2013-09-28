package com.cobble.huasheng.comparator;

import java.util.Comparator;

import com.cobble.huasheng.entity.ItemEntity;

public class ItemComparator implements Comparator<ItemEntity> {

	public ItemComparator() {
	}

	public int compare(ItemEntity o1, ItemEntity o2) {
		if(o1 == null || o2 == null) {
			return -1;
		}
		return (int) (o1.getHits() - o2.getHits());
	}

}
