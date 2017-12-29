package com.bellar.bean;

import java.util.List;

//这种类的好处就是继承了以前原有的类在写一个类在里面添加一个集合这样做的话比较省事
//需要掌握的一种方法
public class OBJECT_T_MALL_ATTR extends T_MALL_ATTR {
private List<T_MALL_VALUE> list_value;

public List<T_MALL_VALUE> getList_value() {
	return list_value;
}

public void setList_value(List<T_MALL_VALUE> list_value) {
	this.list_value = list_value;
}

}
