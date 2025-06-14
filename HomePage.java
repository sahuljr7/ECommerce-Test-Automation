package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    
    @FindBy(linkText = "Sign in")
    private WebElement signInLink;
    
    @FindBy(id = "search_query_top")
    private WebElement searchBox;
    
    @FindBy(name = "submit_search")
    private WebElement searchButton;
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickSignIn() {
        signInLink.click();
    }
    
    public void searchForProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
    }
    
    public boolean isUserLoggedIn(String username) {
        return driver.findElement(By.cssSelector("a.account span")).getText().equals(username);
    }
}
