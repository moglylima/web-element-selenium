package com.example.test;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.example.support.WebSetup;

public class DragAndDropTest {
    @Test
    public void DragnDrop() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // driver= new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5).toMillis(),
                java.util.concurrent.TimeUnit.MILLISECONDS);

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement elementoA = driver.findElement(By.id("column-a"));
        WebElement elementoB = driver.findElement(By.id("column-b"));

        new Actions(driver).dragAndDrop(elementoA, elementoB).perform();

        new Actions(driver)
                .dragAndDrop(elementoB, elementoA)
                .perform();

        // espera 5 segundos
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Actions(driver)
                .dragAndDrop(elementoA, elementoB)
                .perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
