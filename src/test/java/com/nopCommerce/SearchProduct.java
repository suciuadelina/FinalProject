package com.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProduct {
    @Test
    public void search(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        String url = "https://demo.nopcommerce.com/";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement Search= driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
        WebElement SearchButton= driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
        Search.sendKeys("Apple Macbook");
        SearchButton.click();
        WebElement AppleMacbook= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/h2"));
        Assert.assertTrue(AppleMacbook.isDisplayed());
        driver.close();

    }
}
