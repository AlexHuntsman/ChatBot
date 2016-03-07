package chat.model;

import twitter4j.*;
import java.util.*;
import chat.controller.ChatController;

public class CTECTwitter
{
	private Twitter chatbotTwitter;
	private ArrayList<Status> statusList;
	private ArrayList<String> tweetTexts;
	private ChatController baseController;

	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();
		statusList = new ArrayList<Status>();
		tweetTexts = new ArrayList<String>();

	}
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
}
