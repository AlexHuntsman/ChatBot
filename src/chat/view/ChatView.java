package chat.view;

import javax.swing.JOptionPane;

public class ChatView 
{
	public void showResponce(String grabInput)
	{
		JOptionPane.showMessageDialog(null, grabInput);
	}
	public String grabAnswer(String stuff)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null, stuff);
		
		return answer;
	}
}
