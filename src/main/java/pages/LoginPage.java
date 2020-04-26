package pages;

import Framework.Configuration;
import Framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    

    private WebDriver driver;
    private WebDriverWait wait;
    private By emailFieldLocator = By.name("email");
    private By passwordFieldLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[4]/div/button");
    private By rememberMeCheckboxLocator = By.name("remember");
    private By messageLocator = By.className("help-block");
    
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    private void setValidEmail() {
        driver.findElement(emailFieldLocator).sendKeys(Configuration.validEmail);
    }
    
    private void setValidPassword() {
        driver.findElement(passwordFieldLocator).sendKeys(Configuration.validPassword);
    }
    
    private void setInvalidEmail() {
        driver.findElement(emailFieldLocator).sendKeys(Configuration.invalidEmail);
    }
    
    private void setInvalidPassword() {
        driver.findElement(passwordFieldLocator).sendKeys(Configuration.invalidPassword);
    }
    
    public void clickRememberMe() {
        driver.findElement(rememberMeCheckboxLocator).click();
    }
    
    private void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }
    
    public String getAlertMessage() {
        return driver.findElement(messageLocator).getText();
    }
    
    public DashboardPage login() {
        setValidEmail();
        setValidPassword();
        clickLoginButton();
        return new DashboardPage(driver, wait);
    }
    
    public DashboardPage loginWithRembemberMe() {
        setValidEmail();
        setValidPassword();
        clickRememberMe();
        clickLoginButton();
        return new DashboardPage(driver, wait);
    }
    
    public DashboardPage loginWithInvalidEmail() {
        setInvalidEmail();
        setValidPassword();
        clickLoginButton();
        return new DashboardPage(driver, wait);
    }
    
    public DashboardPage loginWithInvalidPassword() {
        setValidEmail();
        setInvalidPassword();
        clickLoginButton();
        return new DashboardPage(driver, wait);
    }
    
    public DashboardPage loginWithInvalidCredentials() {
        setInvalidEmail();
        setInvalidPassword();
        clickLoginButton();
        return new DashboardPage(driver, wait);
    }

    
}
