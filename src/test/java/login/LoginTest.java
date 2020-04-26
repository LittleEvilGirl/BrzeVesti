package login;

import Framework.Configuration;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.LoginPage;

@FixMethodOrder(MethodSorters.JVM)
public class LoginTest {
    
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static DashboardPage dashboardPage;

    @Before
    public void setUp() throws IOException {
        Configuration.init();
        System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.get(Configuration.adminLoginUrl);
        driver.manage().window().fullscreen(); 
    }
    
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    
    @Test
    public void testSuccessfullLogin() {
        LoginPage loginPage = new LoginPage(driver, wait);
        DashboardPage dashboardPage = loginPage.login();
        
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Dashboard", dashboardPage.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin", dashboardPage.getPanelTitle());
    }
    
    @Test
    public void tesLoginWithRemeberMe() {
        LoginPage loginPage = new LoginPage(driver, wait);
        DashboardPage dashboardPage = loginPage.loginWithRembemberMe();
        
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Dashboard", dashboardPage.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin", dashboardPage.getPanelTitle());
    }
    
    @Test
    public void testLoginWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver, wait);
        DashboardPage dashboardPage = loginPage.loginWithInvalidEmail();
        
       assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/login", driver.getCurrentUrl());
       assertTrue("Failure - after delete wrong message", loginPage.getAlertMessage().contains("do not match our records"));
    }
    
    @Test
    public void testLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver, wait);
        DashboardPage dashboardPage = loginPage.loginWithInvalidPassword();
        
       assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/login", driver.getCurrentUrl());
       assertTrue("Failure - after delete wrong message", loginPage.getAlertMessage().contains("do not match our records"));
    }
    
    @Test
    public void testLoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver, wait);
        DashboardPage dashboardPage = loginPage.loginWithInvalidCredentials();
        
       assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/login", driver.getCurrentUrl());
       assertTrue("Failure - after delete wrong message", loginPage.getAlertMessage().contains("do not match our records"));
    }
    
}
