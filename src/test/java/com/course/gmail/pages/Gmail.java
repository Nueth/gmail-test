package com.course.gmail.pages;


import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class Gmail {
	private static final String COMPOSE = "COMPOSE";
	public static ElementsCollection letters = $$(".zA");
	
	@Step
	public static void logIn(String email, String password) {
		$("#Email").setValue(email);
		$("#next").click();
		$("#Passwd").setValue(password);
		$("#signIn").click();
	}
	
	@Step
	public static void composeAndSendLetter(String email, String topic) {
		$(byText(COMPOSE)).click();
		$(By.name("to")).setValue(email);
		$(By.name("subjectbox")).setValue(topic);
		$(byText("Send")).click();
	}
	
	@Step
	public static void openInboxWithUnreadLetters(int count) {
		$(byText("Inbox (" + count + ")")).click();
	}
	
	public static void assertLetterInInbox(String topic) {
		letters.find(hasText(topic));
	}
	
	@Step
	public static void openOutbox() {
		$(byText("Sent Mail")).click();
	}
	
	public static void assertLetterInOutbox(int index, String topic) {
		letters.get(index - 1).shouldHave(text(topic));
	}
	
	@Step
	public static void searchInInbox(String topic) {
		$(By.name("q")).setValue(topic).pressEnter();
	}
	
	public static void assertVisibleLetters(int count) {
		letters.filter(visible).shouldHaveSize(count);
	}
}
