package com.example.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.example.pages.AutocompletePage;
import com.example.support.WebSetup;

public class AutoCompleteTest {

    WebDriver webdriver = WebSetup.getDriver();
    private AutocompletePage autocompletePage;

    @Before
    public void setUp() {
        autocompletePage = new AutocompletePage(webdriver);
        autocompletePage.navigateTo("https://cidades.ibge.gov.br/");
    }

    @Test
    public void testAutoCompleteCityExist() {
        autocompletePage.searchImputCityAndInsertName("São Paulo");
        autocompletePage.selectCity("São Paulo");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
        webdriver.quit();
    }

}