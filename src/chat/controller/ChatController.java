package chat.controller;

import chat.model.Chatbot;
import chat.view.*;

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
	private ChatPanel basePanel;
	
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.collectUserText("What is your name?");
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
		
		String conversation = myDisplay.collectUserText("What would you like to talk about today?");
		//while(myBot.lengthChecker(conversation))
		//{
			
		//	conversation = myBot.procesConversation(conversation);
		//	conversation = myDisplay.grabAnswer(conversation);
			
		//}
		
	}
	public String userToChatbot(String conversation)
	{
		String responce = "";
		
		if(myBot.quitChecker(conversation))
		{
			shutDown();
		}
		responce = myBot.procesConversation(conversation);
		
		return responce;
	}
	private void shutDown()
	{
		myDisplay.showResponce("Goodbye, " + myBot.getUserName() + " it h been my pleasure to talk with you");
		System.exit(0);
	}


	public Chatbot getChatbot() 
	{
		return myBot;
	}


	public void setChatbot(Chatbot myBot)
	{
		this.myBot = myBot;
	}


	public ChatView getChatView() 
	{
		return myDisplay;
	}


	public void setChatView(ChatView myDisplay) 
	{
		this.myDisplay = myDisplay;
	}


	public ChatFrame getBaseFrame() 
	{
		return baseFrame;
	}

	public void setBaseFrame(ChatFrame baseFrame) {
		this.baseFrame = baseFrame;
	}	
	
	public void setBasePanel(ChatPanel basePanel) {
		this.basePanel = basePanel;
	}
	
	public ChatPanel getBasePanel() 
	{
		return basePanel;
	}


	
}
