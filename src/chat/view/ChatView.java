package chat.view;

import javax.swing.JOptionPane;

public class ChatView 
{
	public void showResponce(String wordsFromSomewhere)
	{
		JOptionPane.showMessageDialog(null, wordsFromSomewhere);
	}
	public String grabAnswer(String conversation)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null, conversation);
		
		return answer;
	}
}
