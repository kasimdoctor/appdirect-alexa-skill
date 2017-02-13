package com.appdirect.hackday.ivanka.speechlet;

import java.util.List;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.appdirect.hackday.ivanka.api.FindApiCaller;

/**
 * Created by kasim.doctor on 2/9/17.
 */
public class ADAssistantSpeechlet implements Speechlet {

	private static final String SLOT_APP_NAME = "AppName";
	private static final String SLOT_TO_BUY_APP = "ToBuyApp";

	private FindApiCaller findApiCaller;

	public ADAssistantSpeechlet() {
		findApiCaller = new FindApiCaller();
	}

	@Override
	public void onSessionStarted(SessionStartedRequest sessionStartedRequest, Session session) throws SpeechletException {
		// Initialization logic goes here...
	}

	@Override
	public SpeechletResponse onLaunch(LaunchRequest launchRequest, Session session) throws SpeechletException {
		return getWelcomeResponse();
	}

	@Override
	public SpeechletResponse onIntent(IntentRequest intentRequest, Session session) throws SpeechletException {
		Intent intent = intentRequest.getIntent();
		String intentName = (intent != null) ? intent.getName() : null;

		if ("FindApp".equals(intentName)) {
			return getFindAppResponse(intent);

		}  else if ("BuyApp".equals(intentName)) {
			return getBuyAppResponse(intent);

		} else if ("AMAZON.StopIntent".equals(intentName)) {
			PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
			outputSpeech.setText("Goodbye.");
			return SpeechletResponse.newTellResponse(outputSpeech);

		} else {
			throw new SpeechletException("Invalid Intent");
		}
	}

	@Override
	public void onSessionEnded(SessionEndedRequest sessionEndedRequest, Session session) throws SpeechletException {
		// do nothing...
	}

	/**
	 * Creates and returns a {@code SpeechletResponse} with a welcome message.
	 *
	 * @return SpeechletResponse spoken and visual response for the given intent
	 */
	private SpeechletResponse getWelcomeResponse() {
		String speechText = "Welcome AppDirect user ! " +
				"My name is Emma and I am here to help you find and buy " +
				"cloud apps from the AppDirect marketplace. I can search for apps " +
				"from the AppDirect marketplace and buy any application on your behalf.";

		// Create the plain text output.
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		// Create reprompt
		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(speech);

		return SpeechletResponse.newAskResponse(speech, reprompt);
	}

	private SpeechletResponse getFindAppResponse(Intent intent) {
		StringBuilder speechOutput = new StringBuilder();
		List<String> appNamesThatMatch = null;

		Slot slot = intent.getSlot(SLOT_APP_NAME);
		if(slot != null) {
			appNamesThatMatch = findApiCaller.getAppNamesThatMatch(slot.getValue());
		}

		if(!appNamesThatMatch.isEmpty()) {
			speechOutput.append("Here are the apps matching your search criteria of " + slot.getValue() + "\n");
			for(String appName: appNamesThatMatch) {
				speechOutput.append(appName + ", ");
			}
		}
		speechOutput.append("\nWould you like me to buy any particular application for you?");

		PlainTextOutputSpeech appNamesOutputSpeech = new PlainTextOutputSpeech();
		appNamesOutputSpeech.setText(speechOutput.toString());

		// Create reprompt
		String repromptText = " Now, which application would you like to buy?";
		PlainTextOutputSpeech repromptOutputSpeech = new PlainTextOutputSpeech();
		repromptOutputSpeech.setText(repromptText);
		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(repromptOutputSpeech);


		return SpeechletResponse.newAskResponse(appNamesOutputSpeech, reprompt);
	}

	private SpeechletResponse getBuyAppResponse(Intent intent) {

		StringBuilder speechOutput = new StringBuilder();

		Slot slot = intent.getSlot(SLOT_TO_BUY_APP);
		if(slot != null) {
			// TODO: Call the Billing Apps API here..
			speechOutput.append("Sure ! I will go ahead and buy " + slot.getValue() + " for you from the AppDirect marketplace.\n");
		}

		PlainTextOutputSpeech appNamesOutputSpeech = new PlainTextOutputSpeech();
		appNamesOutputSpeech.setText(speechOutput.toString());

		return SpeechletResponse.newTellResponse(appNamesOutputSpeech);
	}
}
