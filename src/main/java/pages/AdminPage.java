package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected By logoLocator = By.xpath("//*[@id=\"app-layout\"]/nav/div/div[1]/a");
    protected By dashboardLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");
    protected By signaturesLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[2]/a");
    protected By categoriesLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[3]/a");
    protected By regionsLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[4]/a");
    protected By portalLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[5]/a");
    protected By sourcesLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[6]/a");
    protected By cubesListLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/a");
    protected By logoutLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li/a");
    protected By headingTitleLocator = By.className("panel-heading");
    protected By headingLogoLocator = By.className("navbar-brand");
      
    public AdminPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public BrzeVestiPage clickOnLogoLink() {
        driver.findElement(logoLocator).click();
        return new BrzeVestiPage(driver, wait);
    }
        
    public DashboardPage clickOnDashboardLink() {
        driver.findElement(dashboardLinkLocator).click();
        return new DashboardPage(driver, wait);
    }
    
    public SignaturesPage clickOnSignaturesLink() {
        driver.findElement(signaturesLinkLocator).click();
        return new SignaturesPage(driver, wait);
    }
    
    public CategoriesPage clickOnCategoriesLink() {
        driver.findElement(categoriesLinkLocator).click();
        return new CategoriesPage(driver, wait);
    }
    
    public RegionsPage clickOnRegionsLink() {
        driver.findElement(regionsLinkLocator).click();
        return new RegionsPage(driver, wait);
    }
    
    public PortalPage clickOnPortalLink() {
        driver.findElement(portalLinkLocator).click();
        return new PortalPage(driver, wait);
    }
    
    public SourcesPage clickOnSourcesLink() {
        driver.findElement(sourcesLinkLocator).click();
        return new SourcesPage(driver, wait);
    }
    
    public DashboardPage clickOnLogoutLink() {
        driver.findElement(cubesListLocator).click();
        driver.findElement(logoutLocator).click();
        return new DashboardPage (driver, wait);
    }

    public String getPanelHeading() {
        return driver.findElement(headingTitleLocator).getText();
    }
    
    public String getHeadingLogo() {
        return driver.findElement(headingLogoLocator).getText();
    }
    
    public String getPanelTitle() {
        return driver.getTitle();
    }
}


