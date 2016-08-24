package com.course.gmail.pages;


import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Mails {
	public static ElementsCollection mails = $$("[role='main'] .zA");
	
	@Step
	public static void sendMail(String email, String topic) {
		$(byText("COMPOSE")).click();
		$(By.name("to")).setValue(email);
		$(By.name("subjectbox")).setValue(topic);
		$(byText("Send")).click();
	}
	
	
	public static void assertMail(int index, String mailText) {
		mails.get(index).shouldHave(text(mailText));
	}
	
	@Step
	public static void searchMail(String text) {
		$(By.name("q")).setValue(text).pressEnter();
	}
	
	public static void assertMails(String... mailTexts) {
		mails.shouldHave(texts(mailTexts));
	}
	
}
