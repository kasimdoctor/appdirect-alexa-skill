package com.appdirect.hackday.ivanka.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.appdirect.hackday.ivanka.domain.ProductListingWS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by kasim.doctor on 2/9/17.
 */
public final class FindApiCaller {
	private ObjectMapper jacksonMapper = new ObjectMapper();

	public List<String> getAppNamesThatMatch(String appNameToFind) {
		List<String> possibleAppMatches = new ArrayList<>();

		ProductListingWS[] productListingWSArray = null;
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest.get("https://testmarketplace.appdirect.com/api/marketplace/v1/listing")
					.header("Content-Type", "application/json")
					.queryString("start", 0)
					.queryString("count", 12)
					.queryString("q", appNameToFind)
					.asJson();

			productListingWSArray = jacksonMapper.readValue(jsonResponse.getBody().toString(), ProductListingWS[].class);

		} catch (UnirestException | IOException e) {
			// do something or log error...
		}

		Arrays.stream(productListingWSArray).forEach(pl -> possibleAppMatches.add(pl.getName()));

		return possibleAppMatches;
	}
}
