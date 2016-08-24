package com.course.gmail;


import com.course.gmail.pages.Gmail;
import com.course.gmail.pages.Mails;
import com.course.gmail.pages.Menu;
import com.course.gmail.testconfigs.BaseTest;
import org.junit.Test;

import static com.course.gmail.helpers.Helpers.getUniqueText;
import static com.course.gmail.testdata.Credentials.email;
import static com.course.gmail.testdata.Credentials.password;


public class GmailTest extends BaseTest {
	@Test
	public void testMailsLifeCycle() {
		String topic = getUniqueText("some topic ");
		Gmail.visit();
		
		Gmail.logIn(email, password);
		
		Mails.sendMail(email, topic);
		
		Menu.refresh();
		Mails.assertMail(0, topic);
		
		Menu.openSent();
		Mails.assertMail(0, topic);
		
		Menu.openInbox();
		Mails.searchMail(topic);
		Mails.assertMails(topic);
		
	}
	
	
}
