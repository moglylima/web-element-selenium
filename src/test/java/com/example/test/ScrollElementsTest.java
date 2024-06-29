package com.example.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollElementsTest {
    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setUp() {
        // Configuração do WebDriver
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    @Test
    public void rolagemParaElemento() throws InterruptedException {

        By xpath = By.xpath("//*[@id=\"content\"]/div/div/div/div/div[4]");

        // Inicializar o WebDriver
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        // Inicializar o JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Esperar até que o elemento seja carregado
        WebDriverWait wait = new WebDriverWait(driver, 10);

        while (true) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
                break;
            } catch (Exception e) {
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                Thread.sleep(1000);
            }
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
