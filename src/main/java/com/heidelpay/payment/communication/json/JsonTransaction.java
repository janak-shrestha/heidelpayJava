package com.heidelpay.payment.communication.json;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;

public class JsonTransaction {
	private Date date;
	private String type;
	private URL url;
	private BigDecimal amount;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
