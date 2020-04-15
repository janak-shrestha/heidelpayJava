package com.heidelpay.payment.business.paymenttypes;

/*-
 * #%L
 * Heidelpay Java SDK
 * %%
 * Copyright (C) 2018 Heidelpay GmbH
 * %%
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Currency;

import org.junit.Test;

import com.heidelpay.payment.Charge;
import com.heidelpay.payment.business.AbstractPaymentTest;
import com.heidelpay.payment.communication.HttpCommunicationException;
import com.heidelpay.payment.paymenttypes.Alipay;

public class AlipayTest extends AbstractPaymentTest {

	@Test
	public void testCreateAlipayManatoryType() throws HttpCommunicationException {
		Alipay alipay = new Alipay();
		alipay = getHeidelpay().createPaymentType(alipay);
		assertNotNull(alipay.getId());
	}

	@Test
	public void testChargeAlipayType() throws HttpCommunicationException, MalformedURLException {
		Alipay alipay = getHeidelpay().createPaymentType(getAlipay());
		Charge charge = alipay.charge(BigDecimal.ONE, Currency.getInstance("EUR"), new URL("https://www.google.at"));
		assertNotNull(charge);
		assertNotNull(charge.getId());
		assertNotNull(charge.getRedirectUrl());
	}

	@Test
	public void testFetchAlipayType() throws HttpCommunicationException {
		Alipay alipay = getHeidelpay().createPaymentType(getAlipay());
		assertNotNull(alipay.getId());
		Alipay fetchedAlipay = (Alipay) getHeidelpay().fetchPaymentType(alipay.getId());
		assertNotNull(fetchedAlipay.getId());
	}

	
	private Alipay getAlipay() {
		Alipay alipay = new Alipay();
		return alipay;
	}


}
