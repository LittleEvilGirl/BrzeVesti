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

public class CategoriesPage extends AdminPage{
    
    Actions actions = new Actions(driver);
    
    private By resultsTable = By.xpath("//table[@id='categoriesTable']/tbody");
    private By tableRowsLocator = By.tagName("tr");
    private By editCategoryBtn = By.xpath(".//td[5]/div/a");
    private By editCategoryTitle = By.id("title");
    private By saveCategoryTitle = By.id("save-category-button");
    private By backToCategoriesBtn = By.id("back-button");
    private By alertBoxLocator = By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[2]/div");
    private By enbDisbCategoryBtn = By.xpath(".//td[5]/div/button[1]/span");
    private By enableSaveBtn = By.xpath("//*[@id=\"categoryEnableDialog\"]/div/div/div[3]/button[2]");
    private By disableSaveBtn = By.xpath("//*[@id=\"categoryDisableDialog\"]/div/div/div[3]/button[2]");
    private By deleteCategoryBtn = By.xpath(".//td[5]/div/button[2]");
    private By confirmDeleteBtn = By.xpath("//*[@id=\"categoryDeleteDialog\"]/div/div/div[3]/button[2]");
    private By closeDeleteBtn = By.xpath("//*[@id=\"categoryDeleteDialog\"]/div/div/div[3]/button[1]");
    private By closeEnableCategoriesBtn = By.xpath("//*[@id=\"categoryEnableDialog\"]/div/div/div[3]/button[1]");
    private By closeDisableCategoriesBtn = By.xpath("//*[@id=\"categoryDisableDialog\"]/div/div/div[3]/button[1]");

    CategoriesPage(WebDriver driver, WebDriverWait wait) {
         super(driver, wait);
    }
    
    public List<WebElement> getAllRows() {
        if (driver.findElements(tableRowsLocator).size() != 0) {
            WebElement table = driver.findElement(resultsTable);
            return table.findElements(tableRowsLocator);
        } 
        return new ArrayList<>();
    }
    
    public String reorderFirstCategoryRow () throws InterruptedException {
            List<WebElement> rows = this.getAllRows();
            WebElement sourceRow = rows.get(0);
            WebElement targetRow = rows.get(3);
            String title = this.getTitleFromRow(sourceRow);
            actions.clickAndHold(sourceRow).build().perform();
            Thread.sleep(2000);
            actions.clickAndHold().moveToElement(targetRow).release(targetRow).build().perform();
            return title;
    }
    
        public String reorderRandomCategoryRow () throws InterruptedException {
            List<WebElement> rows = this.getAllRows();
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1)); 
            WebElement targetRow = rows.get(2);
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
    
    public String editFirstCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String title = this.getTitleFromRow(firstRow);
            this.clickOnEditCategory(firstRow);
            this.saveNewCategory();
            return title;
        }
    }
    
    public String editBTCFirstCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String title = this.getTitleFromRow(firstRow);
            this.clickOnEditCategory(firstRow);
            this.backToCategories();
            return title;
        }
    }
    
    public String editRandomCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String title = this.getTitleFromRow(randomRow);
            this.clickOnEditCategory(randomRow);
            this.saveNewCategory();
            return title;
        }
    }
    
    public String editBTCRandomCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String title = this.getTitleFromRow(randomRow);
            this.clickOnEditCategory(randomRow);
            this.backToCategories();
            return title;
        }
    }
    
    public String enableFirstCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String enableStatus = this.getStatusFromRow(firstRow);
            this.enableCategory(firstRow);
            return enableStatus;
        }
    }
    
    public String closeEnableFirstCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String enableStatus = this.getStatusFromRow(firstRow);
            this.closeEnableCategory(firstRow);
            return enableStatus;
        }
    }
    
    public String enableRandomCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String enableStatus = this.getStatusFromRow(randomRow);
            this.enableCategory(randomRow);
            return enableStatus;
        }
    }
    
    public String closeEnableRandomCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String enableStatus = this.getStatusFromRow(randomRow);
            this.closeEnableCategory(randomRow);
            return enableStatus;
        }
    }
    
    public String disableFirstCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String disableStatus = this.getStatusFromRow(firstRow);
            this.disableCategory(firstRow);
            return disableStatus;
        }
    }
    
    public String closeDisableFirstCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String disableStatus = this.getStatusFromRow(firstRow);
            this.closeDisableCategory(firstRow);
            return disableStatus;
        }
    }
    
    public String disableRandomCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String disableStatus = this.getStatusFromRow(randomRow);
            this.disableCategory(randomRow);
            return disableStatus;
        }
    }
    
    public String closeDisableRandomCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String disableStatus = this.getStatusFromRow(randomRow);
            this.closeDisableCategory(randomRow);
            return disableStatus;
        }
    }

    public String deleteFirstCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String title = this.getTitleFromRow(firstRow);
            this.deleteCategory(firstRow);
            return title;
        }
    }
    
    public String closeDeleteFirstCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement firstRow = rows.get(0);
            String title = this.getTitleFromRow(firstRow);
            this.closeDeleteCategory(firstRow);
            return title;
        }
    }
    
    public String deleteRandomCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String title = this.getTitleFromRow(randomRow);
            this.deleteCategory(randomRow);
            return title;
        }
    }
    
    public String closeDeleteRandomCategory() {
        List<WebElement> rows = this.getAllRows();
        if (rows.isEmpty()) {
            return "";
        } else {
            WebElement randomRow = rows.get(Helper.getRandomIntRange(rows.size() - 1));
            String title = this.getTitleFromRow(randomRow);
            this.closeDeleteCategory(randomRow);
            return title;
        }
    }
    
    private void clickOnEditCategory(WebElement row) {
        row.findElement(editCategoryBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(editCategoryTitle)).clear();
        String newCategoryTitle = Helper.getRandomText();
        wait.until(ExpectedConditions.elementToBeClickable(editCategoryTitle)).sendKeys(newCategoryTitle);
    }    
    
    private void saveNewCategory () {
        wait.until(ExpectedConditions.elementToBeClickable(saveCategoryTitle)).click();
    }
    
    private void backToCategories() {
        wait.until(ExpectedConditions.elementToBeClickable(backToCategoriesBtn)).click();
    }
    
    public String getAlertMessage() {
        return driver.findElement(alertBoxLocator).getText();
    }
    
    private void enableCategory(WebElement row) {
        row.findElement(enbDisbCategoryBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(enableSaveBtn)).click();
    }
    
    private void closeEnableCategory(WebElement row) {
        row.findElement(enbDisbCategoryBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(closeEnableCategoriesBtn)).click();
   }
    
    private void disableCategory(WebElement row) {
        row.findElement(enbDisbCategoryBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(disableSaveBtn)).click();
    }
    
    private void closeDisableCategory(WebElement row) {
        row.findElement(enbDisbCategoryBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(closeDisableCategoriesBtn)).click();
    }
    
    private void deleteCategory(WebElement row) {
        row.findElement(deleteCategoryBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn)).click();
    }
    
    private void closeDeleteCategory(WebElement row) {
        row.findElement(deleteCategoryBtn).click();
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




    

    
    

