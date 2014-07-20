package com.cshuig.scm.common;

public class SystemContext {

	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
	
	/** 排序的字段 **/
	private static ThreadLocal<String> orderField = new ThreadLocal<String>();
	
	/** 排序的方式：升序与降序 **/
	private static ThreadLocal<String> order = new ThreadLocal<String>();
	
	
	public static Integer getPageSize() {
		return SystemContext.pageSize.get();
	}
	public static void setPageSize(Integer _pageSize) {
		SystemContext.pageSize.set(_pageSize);;
	}
	public static void removePageSize(){
		SystemContext.pageSize.remove();
	}
	
	public static Integer getPageIndex() {
		return SystemContext.pageIndex.get();
	}
	public static void setPageIndex(Integer _pageIndex) {
		SystemContext.pageIndex.set(_pageIndex);;
	}
	public static void removePageIndex(){
		SystemContext.pageIndex.remove();
	}
	
	
	public static String getOrderField() {
		return SystemContext.orderField.get();
	}
	public static void setOrderField(String _orderField) {
		SystemContext.orderField.set(_orderField);;
	}
	public static void removeOrderField(){
		SystemContext.orderField.remove();
	}
	
	
	public static String getOrder() {
		return SystemContext.order.get();
	}
	public static void setOrder(String _order) {
		SystemContext.order.set(_order);;
	}
	public static void removeOrder(){
		SystemContext.order.remove();
	}
}
