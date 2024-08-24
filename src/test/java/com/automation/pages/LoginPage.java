package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]")
    WebElement loginErrorMsg;

    public void openWebsite() {
        driver.get(ConfigReader.getConfigValue("website.url"));
    }

    public void enterValidCredentials(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
    }

    public boolean isErrorMsgDisplayed() {
        return loginErrorMsg.getText().equals("Invalid credentials");
    }
}
