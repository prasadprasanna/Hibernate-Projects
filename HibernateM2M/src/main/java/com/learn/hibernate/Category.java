package com.learn.hibernate;

import java.util.HashSet;
import java.util.Set;

public class Category {
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer categoryId;
	private String name;
	private String desc;
	private Set<Stock> stocks = new HashSet<Stock>();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + "categoryId :: " + categoryId
				+ " name :: " + name 
				+ " desc :: " + desc;
	} 
	
	
	public Category(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the stocks
	 */
	public Set<Stock> getStocks() {
		return stocks;
	}

	/**
	 * @param stocks the stocks to set
	 */
	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}
	
	


}
