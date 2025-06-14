# E-Commerce Test Automation Framework

A hybrid automation framework for e-commerce applications using Selenium WebDriver, TestNG, and Page Object Model.

## Key Features

- **Technology Stack**: Java, Selenium, TestNG
- **Design Pattern**: Page Object Model (POM)
- **Data-Driven Testing**: Supports Excel & JSON test data
- **Reporting**: Extent Reports integration
- **CI/CD Ready**: Jenkins compatible

## Test Coverage

- Login functionality
- Product search
- Cart management
- Checkout process

## Setup

1. Clone repository
2. Install dependencies: `mvn clean install`
3. Run tests: `mvn test`
4. View reports in `test-output/` folder

## Configuration

- Update `src/main/resources/config/config.properties` for environment settings
- Add test data in `src/main/resources/testdata/`
