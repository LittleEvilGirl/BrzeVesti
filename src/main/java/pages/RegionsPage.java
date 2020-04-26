package pages;

import Framework.Helper;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegionsPage extends AdminPage{
    
    Actions actions = new Actions(driver);
    
    private By resultsTable = By.xpath("//table[@id='regionsTable']/tbody");
    private By tableRowsLocator = By.tagName("tr");
    private By editRegionBtn = By.xpath(".//td[5]/div/a");
    private By editRegionsTitle = By.id("title");
    private By saveRegionTitle = By.id("save-region-button");
    private By backToRegionsBtn = By.id("back-button");
    private By alertBoxLocator = By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[2]/div");
    private By enbDisbRegionBtn = By.xpath(".//td[5]/div/button[1]");
    private By enableBtn = By.xpath("//*[@id=\"regionEnableDialog\"]/div/div/div[3]/button[2]");
    private By closeEnableBtn = By.xpath("//*[@id=\"regionEnableDialog\"]/div/div/div[3]/button[1]");
    private By disableBtn = By.xpath("//*[@id=\"regionDisableDialog\"]/div/div/div[3]/button[2]");
    private By closeDisableBtn = By.xpath("//*[@id=\"regionDisableDialog\"]/div/div/div[3]/button[1]");
    private By deleteRegionBtn = By.xpath(".//td[5]/div/button[2]");
    private By confirmDeleteBtn = By.xpath("//*[@id=\"regionDeleteDialog\"]/div/div/div[3]/button[2]");
    private By closeDeleteBtn = By.xpath("//*[@id=\"regionDeleteDialog\"]/div/div/div[3]/button[2]");
    
    RegionsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    public List<WebElement> getAllRows() {
        if (driver.findElements(tableRowsLocator).size() != 0) {
            WebElement table = driver.findElement(resultsTable);
            return table.findElements(tableRowsLocator);
        } 
        return new ArrayList<>();
    }
    
    public String reorderFirstRegionRow () throws InterruptedException {
            List<WebElement> rows = this.getAllRows();
            WebElement sourceRow = rows.get(0);
            WebElement targetRow = rows.get(1);
            String title = this.getTitleFromRow(sourceRow);
            actions.clickAndHold(sourceRow).build().perform();
            Thread.sleep(2000);
            actions.clickAndHold().moveToElement(targetRow).release(targetRow).build().perform();
            return title;
    }
    
        public String reorderRandomRegionRow () throws InterruptedException {
            List<WebElement> rows = this.getAllRows();
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1)); 
            WebElement targetRow = rows.get(1);
            String titleRandomRow = this.getTitleFromRow(randomRow);
            String titleTargetRow = this.getTitleFromRow(targetRow);
            if(titleRandomRow.equals(titleTargetRow)) {
                return "";
            }
            actions.clickAndHold(randomRow).build().perform();
            Thread.sleep(2000);
            actions.clickAndHold().moveToElement(targetRow).release(targetRow).build().perform();
            return titleRandomRow;
    }
    
    public String editFirstRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String title = this.getTitleFromRow(firstRow);
            this.clickOnEditRegion(firstRow);
            this.saveNewRegion();
            return title;
        }
    }
    
    public String editBTRFirstRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String title = this.getTitleFromRow(firstRow);
            this.clickOnEditRegion(firstRow);
            this.backToRegions();
            return title;
        }
    }
    
    public String editRandomRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String title = this.getTitleFromRow(randomRow);
            this.clickOnEditRegion(randomRow);
            this.saveNewRegion();
            return title;
        }
    }
    
    public String editBTRRandomRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String title = this.getTitleFromRow(randomRow);
            this.clickOnEditRegion(randomRow);
            this.backToRegions();
            return title;
        }
    }
    
    public String enableFirstRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String enableStatus = this.getStatusFromRow(firstRow);
            this.enableRegion(firstRow);
            return enableStatus;
        }
    }
    
    public String closeEnableFirstRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String enableStatus = this.getStatusFromRow(firstRow);
            this.closeEnableRegion(firstRow);
            return enableStatus;
        }
    }
        public String enableRandomRegions() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String enableStatus = this.getStatusFromRow(randomRow);
            this.enableRegion(randomRow);
            return enableStatus;
        }
    }
    
    public String closeEnableRandomRegions() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String enableStatus = this.getStatusFromRow(randomRow);
            this.closeEnableRegion(randomRow);
            return enableStatus;
        }
    }
    
    public String disableFirstRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String disableStatus = this.getStatusFromRow(firstRow);
            this.disableRegion(firstRow);
            return disableStatus;
        }
    }
    
    public String closeDisableFirstRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String disableStatus = this.getStatusFromRow(firstRow);
            this.closeDisableRegion(firstRow);
            return disableStatus;
        }
    }
    
    public String disableRandomRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String disableStatus = this.getStatusFromRow(randomRow);
            this.disableRegion(randomRow);
            return disableStatus;
        }
    }
    
    public String closeDisableRandomRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String disableStatus = this.getStatusFromRow(randomRow);
            this.closeDisableRegion(randomRow);
            return disableStatus;
        }
    }

    public String deleteFirstRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String title = this.getTitleFromRow(firstRow);
            this.deleteRegion(firstRow);
            return title;
        }
    }
    
    public String closeDeleteFirstRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String title = this.getTitleFromRow(firstRow);
            this.closeDeleteRegion(firstRow);
            return title;
        }
    }
    
    public String deleteRandomRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String title = this.getTitleFromRow(randomRow);
            this.deleteRegion(randomRow);
            return title;
        }
    }
    
    public String closeDeleteRandomRegion() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String title = this.getTitleFromRow(randomRow);
            this.closeDeleteRegion(randomRow);
            return title;
        }
    }
    
    private void clickOnEditRegion(WebElement row) {
        row.findElement(editRegionBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(editRegionsTitle)).clear();
        String newCategoryTitle = Helper.getRandomText();
        wait.until(ExpectedConditions.elementToBeClickable(editRegionsTitle)).sendKeys(newCategoryTitle);
    }    
    
    private void saveNewRegion () {
        wait.until(ExpectedConditions.elementToBeClickable(saveRegionTitle)).click();
    }
    
    private void backToRegions() {
        wait.until(ExpectedConditions.elementToBeClickable(backToRegionsBtn)).click();
    }
    
    public String getAlertMessage() {
        return driver.findElement(alertBoxLocator).getText();
    }
    
    private void enableRegion(WebElement row) {
        row.findElement(enbDisbRegionBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(enableBtn)).click();
    }
    
    private void closeEnableRegion(WebElement row) {
        row.findElement(enbDisbRegionBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(closeEnableBtn)).click();
   }
    
    private void disableRegion(WebElement row) {
        row.findElement(enbDisbRegionBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(disableBtn)).click();
    }
    
    private void closeDisableRegion(WebElement row) {
        row.findElement(enbDisbRegionBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(closeDisableBtn)).click();
    }
    
    private void deleteRegion(WebElement row) {
        row.findElement(deleteRegionBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn)).click();
    }
    
    private void closeDeleteRegion(WebElement row) {
        row.findElement(deleteRegionBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(closeDeleteBtn)).click();
   }
    
    public String getStatusFromRow(WebElement row) {
            String status = row.findElement(By.xpath(".//td[4]")).getText();
            return status;
    }
    
    private String getTitleFromRow(WebElement row) {
            return row.findElement(By.xpath(".//td[3]")).getText();
    }
}

    

