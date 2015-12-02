package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import chat.model.Chatbot;

/**
 * Class designed for testing the Chatbot object with JUnit. 
 * We will be developing tests for this as a class.
 * Each additional test will be a version decimal update.
 * @author CodyH
 * @version 1.0
 */
public class ChatbotTest
{
	private Chatbot myBot;
	private String userName;

	@Before
	public void setUp() throws Exception
	{
		userName = "test";
		myBot = new Chatbot(userName);
	}

	@After
	public void tearDown() throws Exception
	{
		userName = null;
		myBot = null;
	}

	@Test
	public void testChatbot()
	{
		assertNotNull("The memesList is not present",myBot.getMemesList());
		assertNotNull("The politicalTopicsList is not present", myBot.getPoliticalTopicList());
		assertSame("The username is the same object", userName, myBot.getUserName());
	}

	@Test
	public void testLengthChecker()
	{
		assertFalse("Correct zero length check",myBot.lengthChecker(""));
		assertFalse("Correct null check", myBot.lengthChecker(null));
		assertTrue("Correct length check", myBot.lengthChecker("       "));
	}

	@Test
	public void testContentChecker()
	{
		String content = "starwars";
		myBot.setContent(content);
		assertFalse("Check blank failed", myBot.contentChecker(" "));
		assertFalse("Check partial failed", myBot.contentChecker("words"));
		assertFalse("Check partial failed", myBot.contentChecker("some"));
		assertTrue("Check match failed", myBot.contentChecker(content));
		assertTrue("Check match plus failed", myBot.contentChecker("content " + content));
		assertTrue("Opposite check match failed", myBot.contentChecker(content + " other content"));
	}
	
	@Test
	public void testKeyboardMashChecker()
	{
		assertFalse("Mash incorrectly detected", myBot.keyboardMashChecker("S.D.F."));
		assertFalse("Mash incorrectly detected", myBot.keyboardMashChecker("derf"));
		assertTrue("Mash not detected", myBot.keyboardMashChecker("sdf"));
		assertTrue("Mash not detected", myBot.keyboardMashChecker("dfg"));
		assertTrue("Mash not detected", myBot.keyboardMashChecker("cvb"));
		assertTrue("Mash not detected", myBot.keyboardMashChecker(",./"));
	}

	@Test
	public void testPoliticalTopicChecker()
	{
		assertTrue("Topic check", myBot.getPoliticalTopicList().contains("Democrat"));
		assertTrue("Topic check", myBot.getPoliticalTopicList().contains("Republican"));
		assertTrue("Topic check", myBot.getPoliticalTopicList().contains("11/4/16"));
	}

	@Test
	public void testMemeChecker()
	{
		assertTrue("Topic check", myBot.getMemesList().contains("doge"));
		assertTrue("Topic check", myBot.getMemesList().contains("cute animals"));
	}
	
	@Test
	public void testQuitChecker()
	{
		assertFalse("False positive", myBot.quitChecker("exit"));
		assertTrue("False negative", myBot.quitChecker("quit"));
	}
	
	@Test
	public void testBuildMemesList()
	{
		assertTrue("Size check", myBot.getMemesList().size() >= 10);
		assertTrue("Topic check", myBot.getMemesList().contains("doge"));
		assertTrue("Topic check", myBot.getMemesList().contains("cute animals"));
	}
	
	@Test
	public void testBuildPoliticalTopicList()
	{
		assertTrue("Size check", myBot.getPoliticalTopicList().size() >= 10);
		assertTrue("Topic check", myBot.getPoliticalTopicList().contains("Democrat"));
		assertTrue("Topic check", myBot.getPoliticalTopicList().contains("Republican"));
		assertTrue("Topic check", myBot.getPoliticalTopicList().contains("11/4/16"));
	}

	@Test
	public void testGetUserName()
	{
		assertSame("Getters work", userName, myBot.getUserName());
	}

	@Test
	public void testGetContent()
	{
		String content = "starwars";
		myBot.setContent(content);
		assertSame("Setters and Getters work", content, myBot.getContent());
	}

	@Test
	public void testGetMemesList()
	{
		assertNotNull("Getters work again", myBot.getMemesList());
	}

	@Test
	public void testGetPoliticalTopicList()
	{
		assertNotNull("Getters still work in Java", myBot.getPoliticalTopicList());
	}
	
	@Test
	public void testSetContent()
	{
		String oldContent = myBot.getContent();
		String content = "starwars";
		myBot.setContent(content);
		assertNotSame("Changed values", oldContent, myBot.getContent());
		assertSame("Setters work", content, myBot.getContent());
	}

}
