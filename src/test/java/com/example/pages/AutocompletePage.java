package com.example.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.BasePage;

public class AutocompletePage extends BasePage {

    private By inputField = By.xpath("//*[@id=\"wrapper\"]/div[1]/div/div/busca/div/input");
    private By itemResultList = By.className("busca__auto-completar__resultado__item");

    public AutocompletePage(WebDriver driver) {
        super(driver);
    }

    public AutocompletePage searchImputCityAndInsertName(String text) {
        driver.findElement(inputField).sendKeys(text);
        return this;
    }

    public List<WebElement> listResultCity() {
        return driver.findElements(itemResultList);
    }

    public AutocompletePage clickInCityOnListAutocomplete(int index) {
        listResultCity().get(index).click();
        return this;
    }

    // selecionar cidade na lista de resultados
    public AutocompletePage selectCity(String cityName) {
        for (WebElement element : listResultCity()) {
            if (element.getText().contains(cityName)) {
                element.click();
                break;
            }
        }
        return this;
    }

}
