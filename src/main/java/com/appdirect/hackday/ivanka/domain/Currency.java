package com.appdirect.hackday.ivanka.domain;

import java.util.Collections;
import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Supported currencies for the system
 */
@RequiredArgsConstructor
@Getter
public enum Currency {
	USD,
	CAD,
	EUR,
	JPY(0),
	GBP,
	KRW,
	CHF,
	SEK,
	SGD,
	MYR,
	AUD,
	MXN,
	INR,
	BRL,
	DKK,
	NZD,
	NOK,
	ZAR,
	PHP,
	CNY,
	SAR,
	GTQ;

	private final int nonRoundedDigits;

	Currency() {
		this(10);
	}

	// All currencies minus SGD.
	public static final Set<Currency> SUPPORTED_CURRENCIES = Collections.EMPTY_SET;
	//(EnumSet.complementOf(EnumSet.of(SGD)));

	public String getCode() {
		return toString();
	}

	public static Currency getFromCurrencyCode(String currencyCode) {
		for (Currency currency : SUPPORTED_CURRENCIES) {
			if (currency.getCode().equals(currencyCode)) {
				return currency;
			}
		}
		return null;
	}
}
