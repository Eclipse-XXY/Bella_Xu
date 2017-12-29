package com.bellar.bean;
//因为T_MALL_SKU_ATTR_VALUE表结构没有自动的get和set 的封装的方法所以也是使用一个新的实体类进行一次数据的整体封装

import java.util.List;
public class MODEL_T_MALL_SKU_ATTR_VALUE {
//表示sku当中attr和value的封装
private List<T_MALL_SKU_ATTR_VALUE> list_av;

public List<T_MALL_SKU_ATTR_VALUE> getList_av() {
	return list_av;
}

public void setList_av(List<T_MALL_SKU_ATTR_VALUE> list_av) {
	this.list_av = list_av;
}

}
