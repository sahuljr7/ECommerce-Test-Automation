package com.ecommerce.base;

import com.ecommerce.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.util.Properties;

@Listeners(com.ecommerce.listeners.TestListener.class)
public class TestBase {
    public WebDriver driver;
    public Properties prop;
    
    @BeforeTest
    public void setUp() {
        ConfigReader configReader = new ConfigReader();
        prop = configReader.init_prop();
        String browser = prop.getProperty("browser");
        driver = DriverFactory.init_driver(browser);
        driver.get(prop.getProperty("url"));
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
