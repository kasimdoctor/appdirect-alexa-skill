package com.appdirect.hackday.ivanka.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

import org.apache.commons.collections.MapUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class ChannelStartingPrice implements Serializable {
	private static final long serialVersionUID = 7068130646797428542L;

	private final Map<Currency, ChannelPrice> prices = new HashMap<>();
	private final boolean free;
	private final boolean freeTrial;

	@JsonCreator
	public ChannelStartingPrice(@JsonProperty("prices") Map<Currency, ChannelPrice> prices, @JsonProperty("free") boolean free, @JsonProperty("freeTrial") boolean freeTrial) {
		if (!MapUtils.isEmpty(prices)) {
			this.prices.putAll(prices);
		}
		this.free = free;
		this.freeTrial = freeTrial;
	}

	public static ChannelStartingPrice empty() {
		return new ChannelStartingPrice(new HashMap<>(), false, false);
	}
}
