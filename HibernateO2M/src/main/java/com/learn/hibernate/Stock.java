package com.learn.hibernate;

import java.util.HashSet;
import java.util.Set;

public class Stock {
	
	
	public Stock() {
		
	}

	private int stockId;
	private String stockCode;
	private String stockName;
	
	private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>();
	
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
	 * @return the stockDailyRecords
	 */
	public Set<StockDailyRecord> getStockDailyRecords() {
		return stockDailyRecords;
	}
	/**
	 * @param stockDailyRecords the stockDailyRecords to set
	 */
	public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}

}
