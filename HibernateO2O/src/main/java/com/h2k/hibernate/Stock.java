package com.h2k.hibernate;

public class Stock {
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	private int stockId;
	private String stockCode;
	private String stockName;
	
	private StockDetail stockDetail;
	
	@Override
	public String toString() {
		return ""+
				" stockId " + stockId
				+ " stockCode " + stockCode
				+ " stockName " + stockName
				+ " stockDetail " + stockDetail;
				
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
	 * @return the stockDetail
	 */
	public StockDetail getStockDetail() {
		return stockDetail;
	}
	/**
	 * @param stockDetail the stockDetail to set
	 */
	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}
}
