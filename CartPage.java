package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    
    @FindBy(css = ".cart_description .product-name a")
    private WebElement productNameInCart;
    
    @FindBy(css = ".cart_quantity_input")
    private WebElement quantityInput;
    
    @FindBy(css = "a[title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String getProductNameInCart() {
        return productNameInCart.getText();
    }
    
    public String getProductQuantity() {
        return quantityInput.getAttribute("value");
    }
    
    public void clickProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
    }
}
