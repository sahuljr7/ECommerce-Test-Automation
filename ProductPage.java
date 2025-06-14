package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    
    @FindBy(css = "h1[itemprop='name']")
    private WebElement productName;
    
    @FindBy(id = "add_to_cart")
    private WebElement addToCartButton;
    
    @FindBy(css = ".layer_cart_product h2")
    private WebElement successMessage;
    
    @FindBy(css = "a[title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;
    
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String getProductName() {
        return productName.getText();
    }
    
    public void clickAddToCart() {
        addToCartButton.click();
    }
    
    public boolean isAddToCartSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }
    
    public void clickProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
    }
}
