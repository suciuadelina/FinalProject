package com.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class AddToCart {
    @Test
    public void addToCart() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        String url = "https://demo.nopcommerce.com/";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement electronics= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[3]/div/div[1]/div/h2/a"));
        electronics.click();
        WebElement camera= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a"));
        camera.click();
        WebElement nikon= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[1]/a/img"));
        nikon.click();
        WebElement addToCart= driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-14\"]"));
        addToCart.click();
        sleep(5000);
        WebElement alert= driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[2]"));
        String qty = "(1)";
        Assert.assertTrue(alert.getText().contains(qty));
        driver.close();
    }

}
