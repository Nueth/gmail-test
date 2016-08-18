package com.course.gmail.pages;


import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Mails {
	private static final String COMPOSE = "COMPOSE";
	public static ElementsCollection letters = $$(".zA");
	
	@Step
	public static void sendMail(String email, String topic) {
		$(byText(COMPOSE)).click();
		$(By.name("to")).setValue(email);
		$(By.name("subjectbox")).setValue(topic);
		$(byText("Send")).click();
	}
	
	
	public static void assertMails(int index, String topic) {
		letters.filter(visible).get(index).shouldHave(text(topic));
	}
	
	@Step
	public static void searchMail(String subject) {
		$(By.name("q")).setValue(subject).pressEnter();
	}
	
	public static void assertMails(String... mail) {
		$$(".zA .y6").filter(visible).shouldHave(exactTexts(mail));
	}
	
}
