package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part of the project.
 * 
 * @author Alex Huntsman
 * @version 1.2 10/23/15 Completed the lengthChecker method. Fixed the
 *          constructor and getter for the userName.
 */
public class Chatbot 
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private ArrayList<String> keyboardMash;
	private String userName;
	private String content;

	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * 
	 * @param userName
	 *            The username for the chatbot.
	 */
	public Chatbot(String userName) 
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.keyboardMash = new ArrayList<String>();
		this.userName = userName;
		this.content = "content";

		buildMemesList();
		buildPoliticalTopicsList();
		buildKeyboardMashChecker();
	}

	public String procesConversation(String currentInput) 
	{
		String nextConversation = "oh, what else would you like to talk about?";
		int randomTopic = (int) (Math.random() * 5); //generates random number between 0 and 4
		
		switch (randomTopic)
		{
			case 0:
				if(memeChecker(currentInput))
				{
					nextConversation = "that is a very popular meme this year. What else are you " + " wanting to talk about?";
				}
				else
				{
					nextConversation = "Thats pretty cool";
				}
				break;
			case 1:
				if(politicalTopicChecker(currentInput))
				{
					nextConversation = "Hay your vote matters";
				}
				else
				{
					nextConversation = "What about 11/4/16? You know voteing day?";
				}
				break;
			case 2:
				if(contentChecker(currentInput))
				{
					nextConversation = "Starwars is amazing what else would you like to talk about.";
				}
				else
				{
					nextConversation = "What about it?";
				}
				break;
			case 3:
				if(currentInput.length() > 20)
				{
					nextConversation = "Wow you sure have a lot to say! Any thing else you'd like to say?";
				}
				else
				{
					nextConversation = "say what ever you like";
				}
				break;
			case 4:
				if(keyboardMashChecker(currentInput))
				{
					
				}
				break;
			default:
				break;
		}

		return nextConversation;
	}

	private void buildMemesList() 
	{
		this.memesList.add("me gusta");
		this.memesList.add("doge");
		this.memesList.add("pepe");
		this.memesList.add("troll");
		this.memesList.add("spooderman");
		this.memesList.add("cute animals");
		this.memesList.add("aliens");
		this.memesList.add("what if i told you");
		this.memesList.add("unhelpful highschool teacher");
		this.memesList.add("y u no");

	}

	private void buildPoliticalTopicsList() 
	{
		this.politicalTopicList.add("Democrat");
		this.politicalTopicList.add("Republican");
		this.politicalTopicList.add("11/4/16");
		this.politicalTopicList.add("Election");
		this.politicalTopicList.add("Presedent");
		this.politicalTopicList.add("Oboma");
		this.politicalTopicList.add("Election");
		this.politicalTopicList.add("Stormcloak");
		this.politicalTopicList.add("Imperial");
		this.politicalTopicList.add("Talos");
	}
	
	private void buildKeyboardMashChecker()
	{
		this.keyboardMash.add("sdf");
		this.keyboardMash.add("dfg");
		this.keyboardMash.add("cvb");
		this.keyboardMash.add(",./");
		this.keyboardMash.add("jkl");
	}

	/**
	 * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true.
	 * 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput) 
	{
		boolean hasLength = false;

		if (currentInput != null) 
		{
			if (currentInput.length() > 0) 
			{
				hasLength = true;
			}
		}

		// Another way to write the same if statemente using and
		// if( currentInput !=null && currentInput.length() > 0)
		// {
		// hasLength = true;
		// }

		return hasLength;
	}

	/**
	 * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput) 
	{
		boolean hasContent = false;

		if (currentInput.toLowerCase().contains(content)) 
		{
			hasContent = true;
		}

		return hasContent;
	}

	/**
	 * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPolitical = false;
		
		for (String topic : memesList) 
		{
			if (currentInput.toLowerCase().contains(topic.toLowerCase())) 
			{
				hasPolitical = true;
			}
		}
		
		return hasPolitical;
	}

	/**
	 * Checks to see that the supplied String value is in the current memesList
	 * variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput) 
	{
		boolean hasMeme = false;

		for (String meme : memesList) 
		{
			if (currentInput.toLowerCase().contains(meme.toLowerCase())) 
			{
				hasMeme = true;
			}
		}

		return hasMeme;
	}
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean hasKeyboardMash = false;
		
		for (String mash : keyboardMash) 
		{
			if (currentInput.toLowerCase().contains(mash.toLowerCase())) 
			{
				hasKeyboardMash = true;
			}
		}
		
		return hasKeyboardMash;
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		if(currentInput.toLowerCase().equals("quit"))
		{
			hasQuit = true;
		}
		return hasQuit;
	}

	/**
	 * Returns the username of this Chatbot instance.
	 * 
	 * @return The username of the Chatbot.
	 */
	public String getUserName() 
	{
		return userName;
	}

	/**
	 * Returns the content area for this Chatbot instance.
	 * 
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent() 
	{
		return content;
	}

	/**
	 * Getter method for the memesList object.
	 * 
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList() 
	{
		return memesList;
	}

	/**
	 * Getter method for the politicalTopicList object.
	 * 
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList() 
	{
		return politicalTopicList;
	}

	/**
	 * Updates the content area for this Chatbot instance.
	 * 
	 * @param content
	 *            The updated value for the content area.
	 */
	public void setContent(String content) 
	{
		content = "starwars";
		this.content = content;
	}
}