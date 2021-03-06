package com.heidelpay.payment.paymenttypes;

/*-
 * #%L
 * Heidelpay Java SDK
 * %%
 * Copyright (C) 2018 Heidelpay GmbH
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
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

/**
 * @deprecated use {@code SepaDirectDebitSecured} as a default implementation.
 * @author rene.felder
 *
 */
@Deprecated
public class SepaDirectDebitGuaranteed extends SepaDirectDebit implements PaymentType {

	@Deprecated
	public SepaDirectDebitGuaranteed(String iban) {
		super(iban);
	}

	@Deprecated
	@Override
	public String getTypeUrl() {
		return "types/sepa-direct-debit-guaranteed";
	}

}
