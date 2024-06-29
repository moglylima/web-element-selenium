package com.example.test;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowTest {

    @Test
    public void NewWindow() {
        // Configura o caminho do driver do Chrome
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5).toMillis(),
                java.util.concurrent.TimeUnit.MILLISECONDS);

        driver.get("https://the-internet.herokuapp.com/windows");

        String mainWindow = driver.getWindowHandle();

        WebElement link = driver.findElement(By.linkText("Click Here"));

        link.click();

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                driver.quit();
                return;
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }
}
