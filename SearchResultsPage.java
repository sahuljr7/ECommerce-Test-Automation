package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;
    
    @FindBy(css = ".product_list .product-name")
    private List<WebElement> productNames;
    
    @FindBy(css = ".heading-counter")
    private WebElement resultsCounter;
    
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public boolean isSearchResultsDisplayed() {
        return resultsCounter.isDisplayed();
    }
    
    public int getSearchResultsCount() {
        return productNames.size();
    }
    
    public void clickOnProduct(String productName) {
        for (WebElement product : productNames) {
            if (product.getText().equalsIgnoreCase(productName)) {
                product.click();
                break;
            }
        }
    }
    
    public boolean isProductAvailable(String productName) {
        for (WebElement product : productNames) {
            if (product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }
}
