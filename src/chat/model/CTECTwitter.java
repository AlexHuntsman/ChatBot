package chat.model;

import twitter4j.*;
import java.util.*;
import java.io.*;
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
			chatbotTwitter.updateStatus("Alex just tweeted from my java Chatbot " + "program! #APCSRocks!!");
		} catch (TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}

	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle,
					statusPage));
			page++;
		}
		for (Status currentStatus : statusList)
		{
			String[] tweetText = currentStatus.getText().split("");
			for (String word : tweetText)
			{
				tweetTexts.add(removePunctuation(word).toLowerCase());
			}

		}
		removeCommonEnglishWords(tweetTexts);
		removeEmptyText();
	}

	private String removePunctuation(String currentString)
	{
		
		return null;
	}

	private List removeCommonEnglishWords(ArrayList<String> wordlist)
	{
		
		return null;
	}

	private void removeEmptyText()
	{

	}
}
