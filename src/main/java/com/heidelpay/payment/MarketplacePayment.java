package com.heidelpay.payment;

import java.util.List;

import com.heidelpay.payment.communication.json.JsonObject;
import com.heidelpay.payment.paymenttypes.PaymentType;

public class MarketplacePayment extends AbstractPayment {

	private List<MarketplaceAuthorization> authorizationsList;
	private List<MarketplaceCharge> chargesList;
	private List<MarketplaceCancel> cancelList;
	
	public MarketplacePayment() {
		super();
	}

	public MarketplacePayment(Heidelpay heidelpay) {
		super(heidelpay);
	}

	@Override
	public String getTypeUrl() {
		return "marketplace/payments";
	}

	public List<MarketplaceCharge> getChargesList() {
		return chargesList;
	}

	public MarketplaceCharge getCharge(String chargeId) {
		if (chargesList == null)
			return null;
		for (MarketplaceCharge charge : chargesList) {
			if (chargeId.equalsIgnoreCase(charge.getId())) {
				return charge;
			}
		}
		return null;
	}

	public MarketplaceCharge getCharge(int index) {
		return getChargesList().get(index);
	}

	public void setChargesList(List<MarketplaceCharge> chargesList) {
		this.chargesList = chargesList;
	}

	public List<MarketplaceCancel> getCancelList() {
		return cancelList;
	}

	public MarketplaceCancel getCancel(String cancelId) {
		if (getCancelList() == null)
			return null;
		for (MarketplaceCancel cancel : getCancelList()) {
			if (cancelId.equalsIgnoreCase(cancel.getId())) {
				return cancel;
			}
		}
		return null;
	}

	public void setCancelList(List<MarketplaceCancel> cancelList) {
		this.cancelList = cancelList;
	}

	public List<MarketplaceAuthorization> getAuthorizationsList() {
		return authorizationsList;
	}

	public MarketplaceAuthorization getAuthorization(String authorizeId) {
		if (authorizationsList == null)
			return null;
		for (MarketplaceAuthorization charge : authorizationsList) {
			if (authorizeId.equalsIgnoreCase(charge.getId())) {
				return charge;
			}
		}
		return null;
	}

	public MarketplaceAuthorization getAuthorization(int index) {
		return getAuthorizationsList().get(index);
	}

	public void setAuthorizationsList(List<MarketplaceAuthorization> authorizationsList) {
		this.authorizationsList = authorizationsList;
	}

	@Override
	public PaymentType map(PaymentType paymentType, JsonObject jsonObject) {
		return null;
	}
}