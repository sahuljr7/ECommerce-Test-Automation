package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.constants.AppConstants;
import com.ecommerce.utils.ExcelUtil;
import com.ecommerce.utils.JsonDataReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class LoginTest extends BaseTest {
    
    @DataProvider(name = "loginExcelData")
    public Object[][] getLoginExcelData() {
        ExcelUtil excelUtil = new ExcelUtil(AppConstants.TEST_DATA_SHEET_PATH, "login");
        List<Map<String, String>> testData = excelUtil.getTestData();
        excelUtil.close();
        
        Object[][] data = new Object[testData.size()][1];
        for (int i = 0; i < testData.size(); i++) {
            data[i][0] = testData.get(i);
        }
        return data;
    }
    
    @DataProvider(name = "loginJsonData")
    public Object[][] getLoginJsonData() {
        JsonDataReader jsonDataReader = new JsonDataReader(AppConstants.TEST_DATA_JSON_PATH);
        List<Map<String, String>> testData = jsonDataReader.getTestData().get("login");
        
        Object[][] data = new Object[testData.size()][1];
        for (int i = 0; i < testData.size(); i++) {
            data[i][0] = testData.get(i);
        }
        return data;
    }
    
    @Test(priority = 1, dataProvider = "loginExcelData")
    public void loginWithInvalidCredentialsExcel(Map<String, String> testData) {
        homePage.clickSignIn();
        loginPage.login(testData.get("email"), testData.get("password"));
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");
        Assert.assertEquals(loginPage.getErrorMessageText(), testData.get("expectedError"));
    }
    
    @Test(priority = 2, dataProvider = "loginJsonData")
    public void loginWithInvalidCredentialsJson(Map<String, String> testData) {
        homePage.clickSignIn();
        loginPage.login(testData.get("email"), testData.get("password"));
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");
        Assert.assertEquals(loginPage.getErrorMessageText(), testData.get("expectedError"));
    }
    
    @Test(priority = 3)
    public void loginWithValidCredentials() {
        homePage.clickSignIn();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(homePage.isUserLoggedIn(prop.getProperty("username")));
    }
}
