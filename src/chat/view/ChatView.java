package chat.view;

import javax.swing.JOptionPane;

public class ChatView 
{
	public void showResponce(String wordsFromSomewhere)
	{
		JOptionPane.showMessageDialog(null, wordsFromSomewhere);
	}
	public String grabAnswer(String grabInput)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null, grabInput);
		
		return answer;
	}
}
