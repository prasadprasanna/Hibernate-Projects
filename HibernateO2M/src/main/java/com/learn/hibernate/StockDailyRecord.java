package com.learn.hibernate;

import java.util.Date;

public class StockDailyRecord  {
	
	
	public StockDailyRecord() {
	}
	
	private int recordId;
	private Float priceOpen;
	private Float priceClose;
	private Float priceChange;
	private Long volume;
	private Date date;
	
	private Stock stock;
	/**
	 * @return the recordId
	 */
	public int getRecordId() {
		return recordId;
	}
	/**
	 * @param recordId the recordId to set
	 */
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}
	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	/**
	 * @return the priceOpen
	 */
	public Float getPriceOpen() {
		return priceOpen;
	}
	/**
	 * @param priceOpen the priceOpen to set
	 */
	public void setPriceOpen(Float priceOpen) {
		this.priceOpen = priceOpen;
	}
	/**
	 * @return the priceClose
	 */
	public Float getPriceClose() {
		return priceClose;
	}
	/**
	 * @param priceClose the priceClose to set
	 */
	public void setPriceClose(Float priceClose) {
		this.priceClose = priceClose;
	}
	/**
	 * @return the priceChange
	 */
	public Float getPriceChange() {
		return priceChange;
	}
	/**
	 * @param priceChange the priceChange to set
	 */
	public void setPriceChange(Float priceChange) {
		this.priceChange = priceChange;
	}
	/**
	 * @return the volume
	 */
	public Long getVolume() {
		return volume;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}
