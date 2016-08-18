package com.course.gmail;


import com.course.gmail.pages.Gmail;
import com.course.gmail.pages.Mails;
import com.course.gmail.pages.Menu;
import com.course.gmail.testconfigs.BaseTest;
import org.junit.Test;

import static com.course.gmail.testdata.Config.*;


public class GmailTest extends BaseTest {
	@Test
	public void testMailsLifeCycle() {
		
		Gmail.visit();
		
		Gmail.logIn(email, password);
		
		Mails.sendMail(email, "some topic " + date);
		
		Menu.refreshMail();
		Mails.assertMails(0, "some topic " + date);
		
		Menu.openSent();
		Mails.assertMails(0, "some topic " + date);
		
		Menu.openInbox();
		Mails.searchMail("some topic " + date);
		Mails.assertMails("some topic " + date);
		
	}
}
