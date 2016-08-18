package com.course.gmail.pages;


import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Gmail {
	
	@Step
	public static void visit() {
		open("http://gmail.com");
	}
	
	@Step
	public static void logIn(String email, String password) {
		$("#Email").setValue(email);
		$("#next").click();
		$("#Passwd").setValue(password);
		$("#signIn").click();
	}
	
	
}
