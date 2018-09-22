package com.heidelpay.payment;

/*-
 * #%L
 * Heidelpay Java SDK
 * %%
 * Copyright (C) 2018 Heidelpay GmbH
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import java.math.BigDecimal;
import java.net.URL;
import java.util.Currency;
import java.util.List;

import com.heidelpay.payment.communication.HttpCommunicationException;

public class Charge extends AbstractPayment {
	private BigDecimal amount;
	private Currency currency;
	private URL returnUrl;

	private String typeId;
	private String customerId;
	private String metadataId;
	private String paymentId;
	private String riskId;
	
	private URL redirectUrl;

	private Processing processing = new Processing();
	
	private List<Cancel> cancelList;
	
	public Charge() {
		super();
	}
	public Charge(Heidelpay heidelpay) {
		super(heidelpay);
	}
	
	public Cancel cancel() throws HttpCommunicationException {
		return getHeidelpay().cancelCharge(getPayment().getId(), getId());
	}
	public Cancel cancel(BigDecimal amount) throws HttpCommunicationException {
		return getHeidelpay().cancelCharge(getPayment().getId(), getId(), amount);
	}
	public List<Cancel> getCancelList() {
		return cancelList;
	}
	public void setCancelList(List<Cancel> cancelList) {
		this.cancelList = cancelList;
	}
	public Cancel getCancel(String cancelId) {
		if (cancelList == null) return null;
		for (Cancel cancel : cancelList) {
			if (cancelId.equalsIgnoreCase(cancel.getId())) {
				return cancel;
			}
		} 
		return null;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public Charge setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}
	public Currency getCurrency() {
		return currency;
	}
	public Charge setCurrency(Currency currency) {
		this.currency = currency;
		return this;
	}
	public String getTypeId() {
		return typeId;
	}
	public Charge setTypeId(String typeId) {
		this.typeId = typeId;
		return this;
	}
	public String getCustomerId() {
		return customerId;
	}
	public Charge setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}
	public String getMetadataId() {
		return metadataId;
	}
	public Charge setMetadataId(String metadataId) {
		this.metadataId = metadataId;
		return this;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public Charge setPaymentId(String paymentId) {
		this.paymentId = paymentId;
		return this;
	}
	public String getRiskId() {
		return riskId;
	}
	public Charge setRiskId(String riskId) {
		this.riskId = riskId;
		return this;
	}
	public Processing getProcessing() {
		return processing;
	}
	public void setProcessing(Processing processing) {
		this.processing = processing;
	}
	public URL getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(URL returnUrl) {
		this.returnUrl = returnUrl;
	}

	@Override
	public String getTypeUrl() {
		return "payments/<paymentId>/charges";
	}
	public URL getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(URL redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

}
