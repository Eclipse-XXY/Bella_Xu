package com.bellar.bean;

import java.util.List;

public class DETAIL_T_MALL_SKU extends T_MALL_SKU {
private T_MALL_PRODUCT spu;
private T_MALL_TRADE_MARK tm;
private List<T_MALL_PRODUCT_IMAGE> list_image;
private List<T_MALL_SKU_AV_NAME> list_av_name;
public T_MALL_PRODUCT getSpu() {
	return spu;
}
public void setSpu(T_MALL_PRODUCT spu) {
	this.spu = spu;
}
public T_MALL_TRADE_MARK getTm() {
	return tm;
}
public void setTm(T_MALL_TRADE_MARK tm) {
	this.tm = tm;
}
public List<T_MALL_PRODUCT_IMAGE> getList_image() {
	return list_image;
}
public void setList_image(List<T_MALL_PRODUCT_IMAGE> list_image) {
	this.list_image = list_image;
}
public List<T_MALL_SKU_AV_NAME> getList_av_name() {
	return list_av_name;
}
public void setList_av_name(List<T_MALL_SKU_AV_NAME> list_av_name) {
	this.list_av_name = list_av_name;
}

}
