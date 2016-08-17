package com.course.gmail;


import com.course.gmail.testconfigs.BaseTest;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.course.gmail.pages.Gmail.*;
import static com.course.gmail.testdata.Config.email;
import static com.course.gmail.testdata.Config.password;


public class GmailTest extends BaseTest {
	@Test
	public void testGmailLifecycle() {
		
		open("http://gmail.com");
		
		logIn(email, password);
		
		composeAndSendLetter(email, "some topic");
		
		openInboxWithUnreadLetters(1);
		assertLetterInInbox("some topic");
		
		openOutbox();
		assertLetterInOutbox(1, "some topic");
		
		searchInInbox("some topic");
		assertVisibleLetters(1);
	}
}
