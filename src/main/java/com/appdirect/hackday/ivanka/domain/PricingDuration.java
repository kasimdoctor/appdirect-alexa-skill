package com.appdirect.hackday.ivanka.domain;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.ReadablePeriod;
import org.joda.time.Years;

@Getter
public enum PricingDuration {
	ONE_TIME("one.time", "one.time", "", "", "one.time.fee", Period.ZERO),
	MONTHLY("monthly", "Month", "mo", "Months", "month.fee", Months.ONE),
	QUARTERLY("quarterly", "Quarter", "qrt", "Quarters", "quarter.fee", Months.THREE),
	SIX_MONTHS("six.months", "six.months", "six.mo", "six.months", "six.months.fee", Months.SIX),
	YEARLY("yearly", "Year", "yr", "Years", "year.fee", Years.ONE),
	TWO_YEARS("two.years", "two.years", "two.yr", "two.years", "two.years.fee", Years.TWO),
	THREE_YEARS("three.years", "three.years", "three.yr", "three.years", "three.years.fee", Years.THREE),
	DAILY("daily", "Day", "day", "Days", "day.fee", Days.ONE);

	public static final List<PricingDuration> RECURRING_DURATIONS = Arrays.asList(MONTHLY, QUARTERLY, SIX_MONTHS, YEARLY, TWO_YEARS, THREE_YEARS, DAILY);

	private final String meaning;
	private final String label;
	private final String shortLabel;
	private final String durationsLabel;
	private final String feeLabel;
	private final ReadablePeriod period;

	private PricingDuration(String meaning, String label, String shortLabel, String durationsLabel, String feeLabel, ReadablePeriod period) {
		this.meaning = meaning;
		this.label = label;
		this.shortLabel = shortLabel;
		this.durationsLabel = durationsLabel;
		this.feeLabel = feeLabel;
		this.period = period;
	}

	public int getDurationInMonths() {
		return period.get(DurationFieldType.months()) + period.get(DurationFieldType.years()) * 12;
	}
}
