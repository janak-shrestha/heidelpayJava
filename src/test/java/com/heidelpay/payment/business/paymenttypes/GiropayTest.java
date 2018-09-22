package com.heidelpay.payment.business.paymenttypes;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Currency;

import org.junit.Ignore;
import org.junit.Test;

import com.heidelpay.payment.Charge;
import com.heidelpay.payment.business.AbstractPaymentTest;
import com.heidelpay.payment.communication.HttpCommunicationException;
import com.heidelpay.payment.paymenttypes.Giropay;

public class GiropayTest extends AbstractPaymentTest {

	@Test
	public void testCreateGiropayManatoryType() throws HttpCommunicationException {
		Giropay giropay = new Giropay();
		giropay = (Giropay) getHeidelpay().createPaymentType(giropay);
		assertNotNull(giropay.getId());
	}

	@Test
	@Ignore
	public void testChargeGiropayType() throws HttpCommunicationException, MalformedURLException {
		Giropay giropay = getHeidelpay().createPaymentType(getGiropay());
		Charge charge = giropay.charge(BigDecimal.ONE, Currency.getInstance("EUR"), new URL("https://www.google.at"));
		assertNotNull(charge);
		assertNotNull(charge.getId());
		assertNotNull(charge.getRedirectUrl());
	}

	@Test
	public void testFetchGiropayType() throws HttpCommunicationException {
		Giropay giropay = getHeidelpay().createPaymentType(getGiropay());
		assertNotNull(giropay.getId());
		Giropay fetchedGiropay = (Giropay) getHeidelpay().fetchPaymentType(giropay.getId());
		assertNotNull(fetchedGiropay.getId());
	}

	
	private Giropay getGiropay() {
		Giropay giropay = new Giropay();
		return giropay;
	}


}
