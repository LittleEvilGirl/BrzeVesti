package pages;

import Framework.Helper;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SourcesPage extends AdminPage{
    
    private By resultsTable = By.xpath("//*[@id=\"sourcesTable\"]/tbody");
    private By tableRowsLocator = By.tagName("tr");
    
    private By portalsFilter = By.id("sourcePortalSelect");
    private By sourceStatusFilter = By.id("sourceStatusSelect");
    private By categoriesStatusFilter = By.id("sourceCategorySelect");
    private By portalsColumn = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[1]/td[1]");
    private By messageLocator = By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[2]/div/p");
    
    
    private By confirmDeleteButton = By.xpath("//*[@id=\"newsProcessorSignatureDeleteDialog\"]/div/div/div[3]/button[2]");
    private By confirmChangeCategory = By.xpath("//*[@id=\"newsProcessorSignatureApproveDialog\"]/div/div");
    private By changeCategoryFilter = By.id("newsProcessorSignatureCategoryApprove");
    private By changeCategoryApprove = By.xpath("//*[@id=\"newsProcessorSignatureApproveDialog\"]/div/div/div[3]/button[2]");
    private By confirmIgnoreSignatureButton = By.xpath("//*[@id=\"newsProcessorSignatureIgnoreDialog\"]/div/div/div[3]/button[2]");
    private By messageBox = By.xpath("//div[@class='jumbotron']");
    private By alertBoxLocator = By.className("alert");
    private By alertBoxLocator2 = By.xpath("//div[@class='alert alert-success']");
    private By alertBoxLocator3 = By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[2]/div");
    
    
    
    SourcesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    public void selectFromPortalsDropdown(String portalName) {
        Select portalsDropdown = new Select(driver.findElement(portalsFilter));
        portalsDropdown.selectByVisibleText(portalName);
    }
    
    public void selectFromSourceStatusDropdown(String sourceStatusName) {
        Select sourceStatusDropdown = new Select(driver.findElement(sourceStatusFilter));
        sourceStatusDropdown.selectByVisibleText(sourceStatusName);
    }
    
    public void selectFromCategoriesDropdown(String categoriesName) {
        Select categoriesDropdown = new Select(driver.findElement(categoriesStatusFilter));
        categoriesDropdown.selectByVisibleText(categoriesName);
    }
    
    public String getTextFromPortalColumn() {
        return driver.findElement(portalsColumn).getText();
    }
    
    public List<WebElement> getAllRows() {
        WebElement table = driver.findElement(resultsTable);
        return table.findElements(tableRowsLocator);
    }
    
    public List<String> getPortalValuesFromResults() {
        List<String> portalsValues = new ArrayList<>();
        List<WebElement> rows = this.getAllRows();
        for (WebElement row : rows) {
            portalsValues.add(row.findElement(By.xpath(".//td[1]")).getText()); 
        }
        return portalsValues;
    }
    
    public List<String> getSourceStatusValuesFromResults() {
        List<String> sourceStatusValues = new ArrayList<>();
        List<WebElement> rows = this.getAllRows();
        for (WebElement row : rows) {
            sourceStatusValues.add(row.findElement(By.xpath(".//td[7]")).getText());
        }
        return sourceStatusValues;
    }

    public List<String> getCategoriesValuesFromResults() {
        List<String> CategoriesValues = new ArrayList<>();
        List<WebElement> rows = this.getAllRows();
        for (WebElement row : rows) {
            CategoriesValues.add(row.findElement(By.xpath(".//td[6]")).getText());
        }
        return CategoriesValues;
    }
    
    public String getMessageText() {
        return driver.findElement(messageLocator).getText();
    }
}