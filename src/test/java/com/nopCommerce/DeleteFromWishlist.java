package com.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class DeleteFromWishlist {
    @Test
    public void Wishlist() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        String url = "https://demo.nopcommerce.com/";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement apparel= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[3]/div/div[2]/div/div/a/img"));
        apparel.click();
        WebElement shoes= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/a/img"));
        shoes.click();
        WebElement firstPair= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[1]/a/img"));
        firstPair.click();
        WebElement size= driver.findElement(By.xpath("//*[@id=\"product_attribute_9\"]"));
        Select sizeSelect = new Select(size);
        sizeSelect.selectByValue("22");
        WebElement color= driver.findElement(By.xpath("//*[@id=\"color-squares-10\"]/li[2]/label/span/span"));
        color.click();
        WebElement wish1= driver.findElement(By.id("add-to-wishlist-button-25"));
        wish1.click();
        WebElement Wishlist=driver.findElement(By.className("ico-wishlist"));
        Wishlist.click();
        WebElement deleteButton= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[8]/button"));
        deleteButton.click();
        sleep(5000);
        String message="The wishlist is empty!";
        WebElement emptyWishlist = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div"));
        emptyWishlist.getText();
        Assert.assertTrue(emptyWishlist.getText().contains(message));
        //driver.close();
    }
}
