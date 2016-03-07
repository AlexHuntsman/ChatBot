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
	private JScrollPane textPane;
	private JButton tweetButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton testButton;
	private JButton submitButton;
	private JTextArea chatArea;
	private JTextField textField;
	private JLabel promptLabel;

	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10, 30);
		textField = new JTextField(30);
		promptLabel = new JLabel("Chat with me");
		submitButton = new JButton("Submit");
		testButton = new JButton("Chat");
		setupChatPane();
		setupPanel();

		setupLayout();

		setupListeners();
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 36,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, promptLabel, 5,
				SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -10,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -35,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 30,
				SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 50,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, -90,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -50,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, textField, 6,
				SpringLayout.SOUTH, textPane);
		baseLayout.putConstraint(SpringLayout.WEST, textField, 0,
				SpringLayout.WEST, textPane);
		baseLayout.putConstraint(SpringLayout.EAST, textField, 0,
				SpringLayout.EAST, textPane);
	}

	private void setupChatPane()
	{
		textPane = new JScrollPane(chatArea);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.CYAN);
		this.add(textPane);
		// DO NOT ADD THE LINE this.add(chatArea);
		this.add(textField);
		this.add(promptLabel);
		this.add(submitButton);
		this.add(testButton);

		textField.setToolTipText("Type in here for the chatbot");
		chatArea.setEnabled(false);

	}

	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String conversation = textField.getText();
				chatArea.append("\nUser: " + conversation);
				textField.setText("");
				String responce = baseController.userToChatbot(conversation);
				chatArea.append("\nChatBot: " + responce);

			}
		});
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("no text to send");
			}
		});
	}

	public JTextField getTextField()
	{
		return textField;
	}
}
