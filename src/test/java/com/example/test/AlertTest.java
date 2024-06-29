package com.example.test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

    public void sleepTime(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Alert() {
        // Configura o caminho do driver do Chrome
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5).toMillis(),
                java.util.concurrent.TimeUnit.MILLISECONDS);
        // driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // driver.get("https://letcode.in/alert");

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[1]/button")).click();

        sleepTime(2000);
        Alert alert = driver.switchTo().alert();
        String textoDoAlerta = alert.getText();
        assertEquals(textoDoAlerta, "I am a JS Alert");
        System.out.println("Info Alert --> " + textoDoAlerta);
        sleepTime(3000);
        alert.accept();

        driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[2]/button")).click();
        sleepTime(2000);
        alert = driver.switchTo().alert();
        textoDoAlerta = alert.getText();
        assertEquals(textoDoAlerta, "I am a JS Confirm");
        System.out.println("Info Alert --> " + textoDoAlerta);

        // click on cancel
        alert.dismiss();

        sleepTime(3000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[3]/button")).click();
        sleepTime(2000);
        alert = driver.switchTo().alert();
        textoDoAlerta = alert.getText();
        assertEquals(textoDoAlerta, "I am a JS prompt");
        System.out.println("Info Alert --> " + textoDoAlerta);
        alert.sendKeys("Teste");
        sleepTime(3000);
        alert.accept();

        sleepTime(3000);
        driver.quit();
    }

}
