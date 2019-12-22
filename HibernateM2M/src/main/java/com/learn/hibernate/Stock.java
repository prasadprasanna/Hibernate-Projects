package com.learn.hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Stock implements Serializable{
	
	private static final long serialVersionUID = 6200123129270345252L;
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	private int stockId;
	private String stockCode;
	private String stockName;
	private Set<Category> categories = new HashSet<Category>();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + "stockId :: " + stockId
				+ " stockCode :: " + stockCode 
				+ " stockName :: " + stockName
				+" categories ::  " + categories;
	} 
	
	
	/**
	 * @return the stockId
	 */
	public int getStockId() {
		return stockId;
	}
	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	/**
	 * @return the stockCode
	 */
	public String getStockCode() {
		return stockCode;
	}
	/**
	 * @param stockCode the stockCode to set
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	/**
	 * @return the stockName
	 */
	public String getStockName() {
		return stockName;
	}
	/**
	 * @param stockName the stockName to set
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	/**
	 * @return the categories
	 */
	public Set<Category> getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	

}
