package org.selenide.examples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;

public class SampleSeleniumTest {
    private ChromeDriver driver;

    @Test
    void selenideUsers() {
        ChromeOptions options = new ChromeOptions()
                .addArguments("--headless=new")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://selenide.org/");
        driver.findElement(By.cssSelector(".main-menu-pages")).findElement(By.linkText("Users")).click();
        new FluentWait<WebDriver>(driver)
          .until(__ -> driver.findElements(By.cssSelector("#user-tags .tag")).size() >= 8);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
