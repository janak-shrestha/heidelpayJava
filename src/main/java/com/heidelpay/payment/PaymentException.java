package com.heidelpay.payment;

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

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code PaymentException} represents an Api Error as described here:
 * {@link https://docs.heidelpay.com/docs/error-handling}.
 */
public class PaymentException extends RuntimeException {
	private static final long serialVersionUID = 1490670397634763643L;

	private List<PaymentError> paymentErrorList;
	private String timestamp;
	private String url;
	private Integer statusCode;

	/**
	 * Creates an unspecific {@code PaymentException}.
	 * @deprecated should be avoided, specific Exceptions are refered.
	 * @param message the message 
	 */
	public PaymentException(String message) {
		super(message);
	}
	
	/**
	 * Creates a {@code PaymentException} from the given values.
	 * 
	 * @param url
	 *            - the url called but respondend with an error.
	 * @param statusCode
	 *            the http status code
	 * @param timestamp
	 *            the timestamp the cal was made
	 * @param errors
	 *            the list of {@code PymentError}.
	 */
	public PaymentException(String url, Integer statusCode, String timestamp, List<PaymentError> errors) {
		super(toMessage(url, statusCode, errors));
		this.timestamp = timestamp;
		this.url = url;
		this.paymentErrorList = errors;
		this.statusCode = statusCode;

	}

	/**
	 * Creates a {@code PaymentException} for the given values. The merchantMessage,
	 * customerMessage and the code will be packed into a {@code PaymentError}.
	 * 
	 * @param merchantMessage
	 *            the internal, detailed message
	 * @param customerMessage
	 *            the message to be shown to the customer
	 * @param url
	 *            the url that could not be called for any reason
	 * @param code
	 *            the heidelpay error code.
	 */
	public PaymentException(String merchantMessage, String customerMessage, String code, String url) {
		super(merchantMessage);
		this.paymentErrorList = new ArrayList<PaymentError>();
		this.paymentErrorList.add(new PaymentError(merchantMessage, customerMessage, code));
	}

	/**
	 * Returns the details of the api/pyment error as List of {@code PaymentError}s.
	 * 
	 * @return List of {@code PaymentError}s
	 */
	public List<PaymentError> getPaymentErrorList() {
		return paymentErrorList;
	}

	/**
	 * Returns the timestamp the api-call was made, or the error occured at the sdk.
	 * 
	 * @return imestamp the api-call was made, or the error occured at the sdk.
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * 
	 * @return the url called but returned with an error.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * @return the http-status call
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	private static String toMessage(String url, Integer statusCode, List<PaymentError> errors) {
		StringBuffer sb = new StringBuffer();
		if (url != null && statusCode != null) {
			sb.append("Heidelpay responded with ");
			sb.append(statusCode);
			sb.append(" when calling ");
			sb.append(url);
			sb.append(". ");
		}

		return withErrors(sb, errors).toString();
	}

	private static StringBuffer withErrors(StringBuffer sb, List<PaymentError> errors) {
		if (errors == null || errors.size() <= 0) {
			return sb;
		}
		sb.append("[");
		for (int i = 0; i < errors.size(); i++) {
			sb.append(errors.get(i).toString());
			if (i < errors.size() - 1) {
				sb.append(",");
			} else {
				sb.append("]");
			}
		}
		return sb;
	}

}
