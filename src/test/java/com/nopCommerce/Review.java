package com.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Review {
    @Test
    public void addReview(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        String url = "https://demo.nopcommerce.com/";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement login= driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        login.click();
        WebElement email= driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        email.sendKeys("adelina.suciu99@yahoo.com");
        WebElement password= driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        password.sendKeys("password");
        WebElement loginButton= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
        loginButton.click();
        WebElement htc= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[1]/a/img"));
        htc.click();
        WebElement addReview= driver.findElement(By.xpath("//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[3]/div[2]/a[2]"));
        addReview.click();
        WebElement title = driver.findElement(By.id("AddProductReview_Title"));
        title.sendKeys("Good quality");
        WebElement text= driver.findElement(By.id("AddProductReview_ReviewText"));
        text.sendKeys("Good quality product");
        WebElement rating= driver.findElement(By.xpath("//*[@id=\"addproductrating_4\"]"));
        rating.click();
        WebElement submit= driver.findElement(By.xpath("//*[@id=\"review-form\"]/form/div[2]/button"));
        submit.click();
        String message1="Product review is successfully added.";
        WebElement reviewAdded = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
        reviewAdded.getText();
        Assert.assertTrue(reviewAdded.getText().contains(message1));
        driver.close();

    }
}
