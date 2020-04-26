package pages;

import Framework.Helper;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortalPage extends AdminPage{
    
    Actions actions = new Actions(driver);
    
    private By resultsTable = By.xpath("//*[@id=\"portalsTable\"]/tbody");
    private By tableRowsLocator = By.tagName("tr");
    private By editPortalBtn = By.xpath(".//td[5]/div/a");
    private By savePortalProperties = By.id("save-portal-button");
    private By backToPortalsBtn = By.id("back-button");
    private By alertBoxLocator = By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[2]/div");
    private By enbDisbPortalBtn = By.xpath(".//td[5]/div/button[1]");
    private By enableBtn = By.xpath("//*[@id=\"portalEnableDialog\"]/div/div/div[3]/button[2]");
    private By closeEnableBtn = By.xpath("//*[@id=\"portalEnableDialog\"]/div/div/div[3]/button[1]");
    private By disableBtn = By.xpath("//*[@id=\"portalDisableDialog\"]/div/div/div[3]/button[2]");
    private By closeDisableBtn = By.xpath("//*[@id=\"portalDisableDialog\"]/div/div/div[3]/button[1]");
    private By deletePortalBtn = By.xpath(".//td[5]/div/button[2]");
    private By confirmDeleteBtn = By.xpath("//*[@id=\"portalDeleteDialog\"]/div/div/div[3]/button[2]");
    private By closeDeleteBtn = By.xpath("//*[@id=\"portalDeleteDialog\"]/div/div/div[3]/button[1]");
    
    PortalPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    public List<WebElement> getAllRows() {
        if (driver.findElements(tableRowsLocator).size() != 0) {
            WebElement table = driver.findElement(resultsTable);
            return table.findElements(tableRowsLocator);
        } 
        return new ArrayList<>();
    }
    
    public String reorderFirstPortalRow () throws InterruptedException {
            List<WebElement> rows = this.getAllRows();
            WebElement sourceRow = rows.get(0);
            WebElement targetRow = rows.get(1);
            String title = this.getTitleFromRow(sourceRow);
            actions.clickAndHold(sourceRow).build().perform();
            Thread.sleep(2000);
            actions.clickAndHold().moveToElement(targetRow).release(targetRow).build().perform();
            return title;
    }
    
    public String reorderRandomPortalRow () throws InterruptedException {
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
    
    public String editFirstPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String title = this.getTitleFromRow(firstRow);
            this.clickOnEditPortal(firstRow);
            this.saveNewPortal();
            return title;
        }
    }
    
    public String editBTPFirstPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String title = this.getTitleFromRow(firstRow);
            this.clickOnEditPortal(firstRow);
            this.backToPortals();
            return title;
        }
    }
    
    public String editRandomPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String title = this.getTitleFromRow(randomRow);
            this.clickOnEditPortal(randomRow);
            this.saveNewPortal();
            return title;
        }
    }
    
    public String editBTPRandomPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String title = this.getTitleFromRow(randomRow);
            this.clickOnEditPortal(randomRow);
            this.backToPortals();
            return title;
        }
    }
    
    public String enableFirstPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String enableStatus = this.getStatusFromRow(firstRow);
            this.enablePortal(firstRow);
            return enableStatus;
        }
    }
    
    public String closeEnableFirstPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String enableStatus = this.getStatusFromRow(firstRow);
            this.closeEnablePortal(firstRow);
            return enableStatus;
        }
    }
        public String enableRandomPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String enableStatus = this.getStatusFromRow(randomRow);
            this.enablePortal(randomRow);
            return enableStatus;
        }
    }
    
    public String closeEnableRandomPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String enableStatus = this.getStatusFromRow(randomRow);
            this.closeEnablePortal(randomRow);
            return enableStatus;
        }
    }
    
    public String disableFirstPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String disableStatus = this.getStatusFromRow(firstRow);
            this.disablePortal(firstRow);
            return disableStatus;
        }
    }
    
    public String closeDisableFirstPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String disableStatus = this.getStatusFromRow(firstRow);
            this.closeDisablePortal(firstRow);
            return disableStatus;
        }
    }
    
    public String disableRandomPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String disableStatus = this.getStatusFromRow(randomRow);
            this.disablePortal(randomRow);
            return disableStatus;
        }
    }
    
    public String closeDisableRandomPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String disableStatus = this.getStatusFromRow(randomRow);
            this.closeDisablePortal(randomRow);
            return disableStatus;
        }
    }

    public String deleteFirstPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String title = this.getTitleFromRow(firstRow);
            this.deletePortal(firstRow);
            return title;
        }
    }
    
    public String closeDeleteFirstPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String title = this.getTitleFromRow(firstRow);
            this.closeDeletePortal(firstRow);
            return title;
        }
    }
    
    public String deleteRandomPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String title = this.getTitleFromRow(randomRow);
            this.deletePortal(randomRow);
            return title;
        }
    }
    
    public String closeDeleteRandomPortal() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String title = this.getTitleFromRow(randomRow);
            this.closeDeletePortal(randomRow);
            return title;
        }
    }
    
    private void clickOnEditPortal(WebElement row) {
        row.findElement(editPortalBtn).click();
        driver.findElement(By.xpath("//*[@id=\"title\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"title\"]")).clear();
        String newPortalTitle = Helper.getRandomText();
        driver.findElement(By.id("title")).sendKeys(newPortalTitle);
        driver.findElement(By.id("url")).click();
        String newPortalUrl = "https://www.danas.rs";
        driver.findElement(By.id("url")).clear();
        driver.findElement(By.id("url")).sendKeys(newPortalUrl);
        Select regionDropdown = new Select(driver.findElement(By.name("region_id")));
        regionDropdown.selectByIndex(0);
    }    
    
    private void saveNewPortal () {
        wait.until(ExpectedConditions.elementToBeClickable(savePortalProperties)).click();
    }
    
    private void backToPortals() {
        wait.until(ExpectedConditions.elementToBeClickable(backToPortalsBtn)).click();
    }
    
    public String getAlertMessage() {
        return driver.findElement(alertBoxLocator).getText();
    }
    
    private void enablePortal(WebElement row) {
        row.findElement(enbDisbPortalBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(enableBtn)).click();
    }
    
    private void closeEnablePortal(WebElement row) {
        row.findElement(enbDisbPortalBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(closeEnableBtn)).click();
   }
    
    private void disablePortal(WebElement row) {
        row.findElement(enbDisbPortalBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(disableBtn)).click();
    }
    
    private void closeDisablePortal(WebElement row) {
        row.findElement(enbDisbPortalBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(closeDisableBtn)).click();
    }
    
    private void deletePortal(WebElement row) {
        row.findElement(deletePortalBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn)).click();
    }
    
    private void closeDeletePortal(WebElement row) {
        row.findElement(deletePortalBtn).click();
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

