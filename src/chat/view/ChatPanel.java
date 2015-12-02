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
private JTextField textField;
private JLabel promptLabel;

public ChatPanel(ChatController baseController)
{
	this.baseController = baseController;
	baseLayout = new SpringLayout();
	chatArea = new JTextArea(10,30);
	textField = new JTextField(30);
	promptLabel = new JLabel("Chat with me");
	submitButton = new JButton("Submit");
	
	setupPanel();
	setupLayout();
	setupListeners();
}

private void setupLayout()
{
	baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.WEST, chatArea, 31, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.NORTH, textField, 23, SpringLayout.SOUTH, chatArea);
	baseLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, chatArea);
	baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 36, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.NORTH, promptLabel, 5, SpringLayout.NORTH, submitButton);
	baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.SOUTH, this);
	baseLayout.putConstraint(SpringLayout.EAST, submitButton, -35, SpringLayout.EAST, this);
}

private void setupPanel()
{
	this.setLayout(baseLayout);
	this.setBackground(Color.CYAN);
	this.add(chatArea);
	this.add(textField);
	this.add(promptLabel);
	this.add(submitButton);
	textField.setToolTipText("Type in here for the chatbot");
	chatArea.setEnabled(false);
	
}

private void setupListeners()
{
	submitButton.addActionListener(new ActionListener()
	{
		public void actionPerformed (ActionEvent click)
		{
			String conversation = textField.getText();
			chatArea.append("\nUser: " + conversation);
			textField.setText("");
			String responce = baseController.userToChatbot(conversation);
			chatArea.append("\nChatBot: " + responce);
			
		}
	});
}
 public JTextField getTextField()
 {
	 return textField;
 }
}
