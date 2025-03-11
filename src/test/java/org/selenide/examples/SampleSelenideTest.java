package org.selenide.examples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith(TextReportExtension.class)
public class SampleSelenideTest {
    @BeforeEach
    void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--no-sandbox");
    }

    @Test
    void selenideUsers() {
        open("https://selenide.org/");
        $(".main-menu-pages").find(byText("Users")).click();
        $$("#user-tags .tag").shouldHave(sizeGreaterThan(8));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
