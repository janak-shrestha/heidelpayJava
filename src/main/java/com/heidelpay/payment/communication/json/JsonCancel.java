package com.heidelpay.payment.communication.json;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Currency;
import java.util.Date;

public class JsonCancel extends JsonIdObject implements JsonObject {
	private String isSuccess;
	private String isPending;
	private String isError;
	private JsonMessage message;
	private Date date;	
	
	private BigDecimal amount;
	private Currency currency;
	private URL returnUrl;
	
	private JsonResources resources; 
	private JsonProcessing processing = new JsonProcessing();
	
	public JsonCancel() {
		super();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public JsonCancel setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public Currency getCurrency() {
		return currency;
	}

	public JsonCancel setCurrency(Currency currency) {
		this.currency = currency;
		return this;
	}

	public URL getReturnUrl() {
		return returnUrl;
	}

	public JsonCancel setReturnUrl(URL returnUrl) {
		this.returnUrl = returnUrl;
		return this;
	}

	public JsonProcessing getProcessing() {
		return processing;
	}

	public JsonCancel setProcessing(JsonProcessing processing) {
		this.processing = processing;
		return this;
	}


	public JsonResources getResources() {
		return resources;
	}

	public void setResources(JsonResources resources) {
		this.resources = resources;
	}

	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getIsPending() {
		return isPending;
	}

	public void setIsPending(String isPending) {
		this.isPending = isPending;
	}

	public String getIsError() {
		return isError;
	}

	public void setIsError(String isError) {
		this.isError = isError;
	}

	public JsonMessage getMessage() {
		return message;
	}

	public void setMessage(JsonMessage message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
