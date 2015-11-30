package chat.controller;

import chat.view.ChatView;
import chat.view.ChatFrame;
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
	private ChatFrame baseFrame;
	
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabAnswer("What is your name?");
		myBot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
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
			
			conversation = myBot.procesConversation(conversation);
			conversation = myDisplay.grabAnswer(conversation);
			
		}
		
	}
	private void shutDown()
	{
		myDisplay.showResponce("Goodbye, " + myBot.getUserName() + " it h been my pleasure to talk with you");
		System.exit(0);
	}


	public Chatbot getMyBot() {
		return myBot;
	}


	public void setMyBot(Chatbot myBot) {
		this.myBot = myBot;
	}


	public ChatView getMyDisplay() {
		return myDisplay;
	}


	public void setMyDisplay(ChatView myDisplay) {
		this.myDisplay = myDisplay;
	}


	public ChatFrame getBaseFrame() {
		return baseFrame;
	}


	public void setBaseFrame(ChatFrame baseFrame) {
		this.baseFrame = baseFrame;
	}
	
}
