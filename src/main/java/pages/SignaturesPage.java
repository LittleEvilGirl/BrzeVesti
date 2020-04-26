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

public class SignaturesPage extends AdminPage{
    
    private By portalsFilter = By.id("newsProcessorSignaturePortalSelect");
    private By signaturesStatusFilter = By.id("newsProcessorSignatureStatusSelect");
    private By categoriesFilter = By.id("newsProcessorSignatureCategorySelect");
    private By portalsColumn = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/thead/tr/th[2]");
    private By confirmDeleteButton = By.xpath("//*[@id=\"newsProcessorSignatureDeleteDialog\"]/div/div/div[3]/button[2]");
    private By confirmChangeCategory = By.xpath("//*[@id=\"newsProcessorSignatureApproveDialog\"]/div/div");
    private By changeCategoryFilter = By.id("newsProcessorSignatureCategoryApprove");
    private By changeCategoryApprove = By.xpath("//*[@id=\"newsProcessorSignatureApproveDialog\"]/div/div/div[3]/button[2]");
    private By confirmIgnoreSignatureButton = By.xpath("//*[@id=\"newsProcessorSignatureIgnoreDialog\"]/div/div/div[3]/button[2]");
    private By messageBox = By.xpath("//div[@class='jumbotron']");
    private By alertBoxLocator = By.className("alert");
    private By alertBoxLocator2 = By.xpath("//div[@class='alert alert-success']");
    private By alertBoxLocator3 = By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[2]/div");
    private By resultsTable = By.xpath("//table[@id='newsProcessorSignatureTable']/tbody");
    private By tableRowsLocator = By.tagName("tr");
    
    SignaturesPage(WebDriver driver, WebDriverWait wait) {
       super(driver, wait);
    }
    
    public void selectFromPortalsDropdown(String portalName) {
        Select portalsDropdown = new Select(driver.findElement(portalsFilter));
        portalsDropdown.selectByVisibleText(portalName);
    }
    
    public void selectFromSignaturesStatusDropdown(String signaturesName) {
        Select signaturesStatusDropdown = new Select(driver.findElement(signaturesStatusFilter));
        signaturesStatusDropdown.selectByVisibleText(signaturesName);
    }
        
    public void selectFromCategoriesDropdown(String categoriesName) {
        Select categoriesDropdown = new Select(driver.findElement(categoriesFilter));
        categoriesDropdown.selectByVisibleText(categoriesName);
    }
    
    public String getTextFromPortalColumn() {
        return driver.findElement(portalsColumn).getText();
    }
    
    public List<WebElement> getAllRows() {
        if (driver.findElements(tableRowsLocator).size() != 0) {
            WebElement table = driver.findElement(resultsTable);
            return table.findElements(tableRowsLocator);
        } 
        return new ArrayList<>();
    }
    
    public List<String> getPortalValuesFromResults() {
        List<String> portalsValues = new ArrayList<>();
        List<WebElement> rows = this.getAllRows();
        for (WebElement row : rows) {
            portalsValues.add(row.findElement(By.xpath(".//td[2]")).getText());
        }
        return portalsValues;
    }
    
    public List<String> getSignaturesStatusValuesFromResults() {
        List<String> statusValues = new ArrayList<>();
        for (WebElement row : this.getAllRows()) {
            WebElement statusField = row.findElement(By.xpath(".//td[5]"));
            String statusText = statusField.getText();
            statusValues.add(statusText);
        }
        return statusValues;
    }

    public List<String> getCategoriesValuesFromResults() {
        List<String> categoriesValues = new ArrayList<>();
        List<WebElement> rows = this.getAllRows();
        for (WebElement row : rows) {
            categoriesValues.add(row.findElement(By.xpath(".//td[4]")).getText());
        }
        return categoriesValues;
    }
    
    public String changeCategoryFirstSignature() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String signature = this.getSignatureFromRow(firstRow);
            this.clickOnChangeCategory(firstRow);
            this.approveChangeCategory();
            return signature;
        }
    }
    
    public String changeCategoryLastSignature() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement lastRow = rows.get(rows.size() - 1);
            String signature = this.getSignatureFromRow(lastRow);
            this.clickOnChangeCategory(lastRow);
            this.approveChangeCategory();
            return signature;
        }
    }
    
    public String changeCategoryRandomSignature() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String signature = this.getSignatureFromRow(randomRow);
            this.clickOnChangeCategory(randomRow);
            this.approveChangeCategory();
            return signature;
        }
    }
    
    public String ignoreFirstSignature() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String signature = this.getSignatureFromRow(firstRow);
            this.clickOnIgnoreSignatureButton(firstRow);
            this.confirmIgnoreSignatureButton();
            return signature;
        }
    }
    
    public String ignoreLastSignature() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(rows.size() - 1);
            String signature = this.getSignatureFromRow(firstRow);
            this.clickOnIgnoreSignatureButton(firstRow);
            this.confirmIgnoreSignatureButton();
            return signature;
        }
    }
    
    public String ignoreRandomSignature() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String signature = this.getSignatureFromRow(firstRow);
            this.clickOnIgnoreSignatureButton(firstRow);
            this.confirmIgnoreSignatureButton();
            return signature;
        }
    }
    
    public String deleteFirstSignature() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String signature = this.getSignatureFromRow(firstRow);
            this.clickOnDeleteButton(firstRow);
            this.confirmDelete();
            return signature;
        }
    }
    
    public String deleteLastSignature() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement lastRow = rows.get(rows.size() - 1);
            String signature = this.getSignatureFromRow(lastRow);
            this.clickOnDeleteButton(lastRow);
            this.confirmDelete();
            return signature;
        }
    }
        
    public String deleteRandomSignature() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String signature = this.getSignatureFromRow(randomRow);
            this.clickOnDeleteButton(randomRow);
            this.confirmDelete();
            return signature;
        }
    }
    
    public String getAlertMessage() {
        return driver.findElement(alertBoxLocator).getText();
    }
    
    public String getAlertMessage2() {
        return driver.findElement(alertBoxLocator2).getText();
    }
    
    public String getAlertMessage3() {
        return driver.findElement(alertBoxLocator3).getText();
    }
    
    public String getMessage() {
        return driver.findElement(messageBox).getText();
    }
    
    private String getSignatureFromRow(WebElement row) {
        return row.findElement(By.xpath(".//td[3]")).getText();
    }
    
    private void clickOnChangeCategory(WebElement row) {
        row.findElement(By.xpath(".//td[6]/div/button[1]")).click();
    }
    
    private void approveChangeCategory() {
        Select categoriesDropdown = new Select(driver.findElement(changeCategoryFilter));
        wait.until(ExpectedConditions.elementToBeClickable(changeCategoryFilter)).click();
        categoriesDropdown.selectByVisibleText("(No Category)");
        wait.until(ExpectedConditions.elementToBeClickable(changeCategoryApprove)).click();
    }
    
    private void clickOnIgnoreSignatureButton(WebElement row) {
        row.findElement(By.xpath(".//td[6]/div/button[2]")).click();
    }
    
    private void confirmIgnoreSignatureButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmIgnoreSignatureButton)).click();
    }
    
    private void clickOnDeleteButton(WebElement row) {
        row.findElement(By.xpath(".//td[6]/div/button[3]")).click();
    }
    
    private void confirmDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
    }
}
