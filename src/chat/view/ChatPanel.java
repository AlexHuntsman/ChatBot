package chat.view;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

import chat.controller.ChatController;

/**
 * 
 * @author ahun0442
 * @version 0.1 11/30/15
 */

public class ChatPanel extends JPanel
{
private ChatController baseController;
private SpringLayout baseLayout;
private JButton submitButton;
private JTextArea chatArea;
private JTextField typingField;
private JLabel promptLabel;

public ChatPanel(ChatController baseController)
{
	this.baseController = baseController;
	baseLayout = new SpringLayout();
	chatArea = new JTextArea(10,30);
	typingField = new JTextField(30);
	promptLabel = new JLabel("Chat with me");
	submitButton = new JButton("Submit");
	
	setupPanel();
	setupLayout();
	setupListeners();
}

private void setupLayout()
{
	
}

private void setupPanel()
{
	this.setLayout(baseLayout);
	this.setBackground(Color.CYAN);
	this.add(chatArea);
	this.add(typingField);
	this.add(promptLabel);
	this.add(submitButton);
}

private void setupListeners()
{
	submitButton.addActionListener(new ActionListener()
	{
		public void actionPerformed (ActionEvent click)
		{
			String conversation = typingField.getText();
		}
	});
}

}
