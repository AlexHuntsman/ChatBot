package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatView 
{
	private String windowMessage;
	private ImageIcon chatIcon;
	public ChatView()
	{
		windowMessage = "Hello from your freindly chatbot :D";
		chatIcon = new ImageIcon(getClass().getResource("images/robot.png"));
	}
	public void showResponce(String wordsFromSomewhere)
	{
		JOptionPane.showMessageDialog(null, wordsFromSomewhere,windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon);
	}
	public String collectUserText(String conversation)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null, conversation, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Answer here :)").toString();
		
		return answer;
	}
}
