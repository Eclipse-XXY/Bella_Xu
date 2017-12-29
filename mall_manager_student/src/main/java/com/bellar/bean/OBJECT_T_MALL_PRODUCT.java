package com.bellar.bean;

public class OBJECT_T_MALL_PRODUCT extends T_MALL_PRODUCT {
	//其实对应映射的product的id的主键在实际的开发当用最好引用一个新的表结构表示一个对象要不然会导致破坏了以前的表结构的信息
	private int spu_id;

	public int getSpu_id() {
		return spu_id;
	}

	public void setSpu_id(int spu_id) {
		this.spu_id = spu_id;
	}
	

}
