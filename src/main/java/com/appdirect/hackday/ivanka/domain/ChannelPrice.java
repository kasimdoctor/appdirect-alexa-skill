package com.appdirect.hackday.ivanka.domain;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonInclude(Include.NON_NULL)
public class ChannelPrice implements Serializable {
	private final BigDecimal price;
	private final PricingDuration duration;
	private final BigDecimal taxes;
	private final BigDecimal priceWithTaxes;

	@JsonCreator
	public ChannelPrice(@JsonProperty("price") BigDecimal price, @JsonProperty("duration") PricingDuration duration,
	                    @JsonProperty("taxes") BigDecimal taxes, @JsonProperty("priceWithTaxes") BigDecimal priceWithTaxes) {
		this.price = price;
		this.duration = duration;
		this.taxes = taxes;
		this.priceWithTaxes = priceWithTaxes;
	}

	public ChannelPrice(BigDecimal price, PricingDuration duration) {
		this(price, duration, null, null);
	}
}
