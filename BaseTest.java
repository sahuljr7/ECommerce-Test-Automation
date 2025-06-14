package com.ecommerce.base;

import com.ecommerce.pages.*;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends TestBase {
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SearchResultsPage searchResultsPage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    
    @BeforeMethod
    public void setupPages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
}
