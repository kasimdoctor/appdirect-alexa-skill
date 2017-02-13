package com.appdirect.hackday.ivanka.handler;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import com.appdirect.hackday.ivanka.speechlet.ADAssistantSpeechlet;

/**
 * Created by kasim.doctor on 2/9/17.
 */
public class IvankaSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {

	private static final Set<String> supportedApplicationIds = new HashSet<>();
	static {
        /*
         * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
         * Alexa Skill and put the relevant Application Ids in this Set.
         */
		supportedApplicationIds.add("amzn1.ask.skill.1872a3f1-ecef-4928-80b4-504f68885919");
	}

	public IvankaSpeechletRequestStreamHandler() {
		super(new ADAssistantSpeechlet(), supportedApplicationIds);
	}
}
