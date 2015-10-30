package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 * Application controller for the ChatBot project.
 * @author ahun0442
 * @version 1.1.1 10/21/15 fixed error.
 */

public class ChatController 
{
	private Chatbot myBot;
	private ChatView myDisplay;
	
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabAnswer("What is your name?");
		myBot = new Chatbot(userName);
	}
	
	
	public void start()
	{
		myDisplay.showResponce("hello "+ myBot.getUserName());
		chat();
		
	}
	
	private void chat()
	{
		
		String conversation = myDisplay.grabAnswer("What would you like to talk about today?");
		while(myBot.lengthChecker(conversation))
		{
			if(myBot.contentChecker(conversation))
			{
				myDisplay.showResponce("wow i had no idea you liked "+ myBot.getContent());
			}
			else if(myBot.memeChecker(conversation))
			{
				myDisplay.showResponce("That meme is sweet");
			}
			
			conversation = myDisplay.grabAnswer(conversation);
			
//			if(!myBot.quitChecker(conversation))
//			{
//				conversation =simple.processInput(conversation);
//			}
//			else
//			{
//				shutDown()
//			}
		}
	}
}
