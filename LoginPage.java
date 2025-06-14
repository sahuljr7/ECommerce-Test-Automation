package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    
    @FindBy(id = "email")
    private WebElement emailInput;
    
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    
    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;
    
    @FindBy(css = ".alert.alert-danger")
    private WebElement errorMessage;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }
    
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }
    
    public void clickSignIn() {
        signInButton.click();
    }
    
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
    
    public String getErrorMessageText() {
        return errorMessage.getText();
    }
    
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
    }
}
