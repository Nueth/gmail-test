package com.course.gmail.pages;


import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;

public class Menu {
	@Step
	public static void openSent() {
		$(byTitle("Sent Mail")).click();
	}
	
	@Step
	public static void openInbox() {
		$(byTitle("Inbox")).click();
	}
	
	@Step
	public static void refresh() {
		$(".asf").click();
	}
}
