package chat.model;

import twitter4j.*;
import java.util.*;
import java.io.*;
import chat.controller.ChatController;

public class CTECTwitter
{
	private Twitter chatbotTwitter;
	private List<Status> statusList;
	private List<String> tweetTexts;
	private ChatController baseController;

	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();

		this.statusList = new ArrayList<Status>();
		this.tweetTexts = new ArrayList<String>();

	}

	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter
					.updateStatus("Alex just tweeted from my java Chatbot "
							+ "program! #APCSRocks!!");
		} catch (TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}

	public void loadTweets(String twitterHandle) throws TwitterException
	{
		statusList.clear();
		tweetTexts.clear();
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
		// Grabs the current string
		// Goes through each character of the string
		// removes the punctuation from string
		// returns the string
		String punctuation = ".,`?!:;\"(){}^[]<>-@";

		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}

	private List removeCommonEnglishWords(List<String> tweetTexts)
	{
		String[] boringWords = importWordsToArray();

		for (int count = 0; count < tweetTexts.size(); count++)
		{
			for (int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if (tweetTexts.get(count).equalsIgnoreCase(
						boringWords[removeSpot]))
				{
					tweetTexts.remove(count);
					count--;
					removeSpot = boringWords.length; // Exit the inner loop.
														// makes sure we don't
														// skip any words.
				}
			}
		}
		removeTwitterUsernameFromList(tweetTexts);

		return tweetTexts;
	}

	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;

		Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		while (wordFile.hasNext())
		{
			wordCount++;
			wordFile.next();
		}
		wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		boringWords = new String[wordCount];
		int boringWordCount = 0;
		while (wordFile.hasNext())
		{
			boringWords[boringWordCount] = wordFile.next();
			boringWordCount++;
		}
		wordFile.close();

		return boringWords;
	}

	private void removeTwitterUsernameFromList(List<String> tweetTexts)
	{
		for (int wordCount = 0; wordCount < tweetTexts.size(); wordCount++)
		{
			if (tweetTexts.get(wordCount).length() >= 1
					&& tweetTexts.get(wordCount).charAt(0) == '@')
			{
				tweetTexts.remove(wordCount);
				wordCount--;
			}
		}
	}

	private void removeEmptyText()
	{
		for (int spot = 0; spot < tweetTexts.size(); spot++)
		{
			if (tweetTexts.get(spot).equals(""))
			{
				tweetTexts.remove(spot);
				// need to go backwards when you remove so that you don't skip
				// any spots.
				spot--;
			}
		}
	}

	public String topResults()
	{
		String tweetResults = "";

		int topWordLocation = 0;
		int topCount = 0;

		for (int index = 0; index < tweetTexts.size(); index++)
		{
			int wordUseCount = 1;

			for (int spot = index + 1; spot < tweetTexts.size(); spot++)
			{
				if (tweetTexts.get(index).equals(tweetTexts.get(spot)))
				{
					wordUseCount++;
				}
				if (wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}

		tweetResults = "The top word in the tweets was " + tweetTexts.get(topWordLocation) + "and it was used " + topCount + " times!";
		return tweetResults;
	}
	
	public String sampleInvestigation()
	{
		String results = "";
		
		Query query = new Query("marathon");
		query.setCount(100);
		query.setGeoCode(new GeoLocation(40.587521, -111.869178), 5, Query.MILES);
		query.setSince("2016-1-1");
		try
		{
			QueryResult result = chatbotTwitter.search(query);
			results.concat("Count : "  + result.getTweets().size());
			for (Status tweet : result.getTweets())
			{
				results.concat("@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n");
			}
		}
		catch(TwitterException error)
		{
			error.printStackTrace();
		}
		
		return results;
	}
}
