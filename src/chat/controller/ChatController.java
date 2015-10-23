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
	}
}
