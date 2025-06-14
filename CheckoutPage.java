package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    
    @FindBy(css = ".step_current.first")
    private WebElement addressStep;
    
    @FindBy(name = "processAddress")
    private WebElement proceedAddressButton;
    
    @FindBy(id = "uniform-cgv")
    private WebElement termsCheckbox;
    
    @FindBy(name = "processCarrier")
    private WebElement proceedCarrierButton;
    
    @FindBy(className = "bankwire")
    private WebElement payByBankWire;
    
    @FindBy(css = "button.button-medium")
    private WebElement confirmOrderButton;
    
    @FindBy(css = ".cheque-indent .dark")
    private WebElement orderConfirmationMessage;
    
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public boolean isAddressStepDisplayed() {
        return addressStep.isDisplayed();
    }
    
    public void clickProceedAddress() {
        proceedAddressButton.click();
    }
    
    public void acceptTerms() {
        termsCheckbox.click();
    }
    
    public void clickProceedCarrier() {
        proceedCarrierButton.click();
    }
    
    public void selectPaymentMethod() {
        payByBankWire.click();
    }
    
    public void confirmOrder() {
        confirmOrderButton.click();
    }
    
    public String getOrderConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(orderConfirmationMessage));
        return orderConfirmationMessage.getText();
    }
}
