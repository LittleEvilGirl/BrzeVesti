package categories;

import Framework.Helper;
import baseTest.BaseTest;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.PortalPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesPage;

@FixMethodOrder(MethodSorters.JVM)
public class CategoriesTest extends BaseTest{
    
    private By disableSpan = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[4]/span");
    
    @Test
    public void testBrzeVestiLink() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        categoriesPage.clickOnLogoLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
    }
    
    @Test
    public void testDashboardLink() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        DashboardPage dashboardPage1 = categoriesPage.clickOnDashboardLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Dashboard", dashboardPage1.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin", dashboardPage1.getPanelTitle());
    }
    
    @Test
    public void testSignaturesLink() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        SignaturesPage signaturesPage = categoriesPage.clickOnSignaturesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/signatures", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Signatures", signaturesPage.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Signatures", signaturesPage.getPanelTitle());
    }
    
    @Test
    public void testCategoriesLink() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        categoriesPage.clickOnCategoriesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
    
    @Test
    public void testRegionsLink() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        RegionsPage regionsPage = categoriesPage.clickOnRegionsLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
    @Test
    public void testPortalsLink() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        PortalPage portalPage = categoriesPage.clickOnPortalLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
    
    @Test
    public void testSourcesLink() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        SourcesPage sourcesPage = categoriesPage.clickOnSourcesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/sources", driver.getCurrentUrl());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Sources", sourcesPage.getPanelTitle());
    }
    
    @Test
    public void testLogoutLink() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        DashboardPage logoutButton = categoriesPage.clickOnLogoutLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
        assertEquals("Failure: Title's doesn't match", "Brze vesti", logoutButton.getPanelTitle());
    }
    
    @Test
    public void testAddNewCaregory() throws IOException {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[1]/a")).click();
        String newCategoryTitle = Helper.getRandomText();
        driver.findElement(By.id("title")).sendKeys(newCategoryTitle);
        driver.findElement(By.id("save-category-button")).click();
        WebElement message = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[2]/div"));
        assertEquals("Titles doesn't match", "Category \"" + newCategoryTitle + "\" has been successfully saved!", message.getText());
    }
    
    @Test
    public void testReorderFirstCategory() throws InterruptedException {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String reorderCategory = categoriesPage.reorderFirstCategoryRow();
        Assume.assumeTrue(reorderCategory != "");
        assertTrue("Failure - category wasn't reordered", categoriesPage.getAlertMessage().contains("has been reordered"));
        assertTrue("Failure - wrong category reordered", categoriesPage.getAlertMessage().contains(reorderCategory));
    }
    
    @Test
    public void testReorderRandomCategory() throws InterruptedException {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String reorderCategory = categoriesPage.reorderRandomCategoryRow();
        Assume.assumeTrue(reorderCategory != "");
        assertTrue("Failure - category wasn't reordered", categoriesPage.getAlertMessage().contains("has been reordered"));
        assertTrue("Failure - wrong category reordered", categoriesPage.getAlertMessage().contains(reorderCategory));
    }
    
    @Test
    public void testEditFirstCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String editCategory = categoriesPage.editFirstCategory();
        Assume.assumeTrue(editCategory != "");
        assertTrue("Failure - category wasn't edited", categoriesPage.getAlertMessage().contains("has been successfully saved!"));
    }
    
    @Test
    public void testEditBTCFirstCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String editCategory = categoriesPage.editBTCFirstCategory();
        Assume.assumeTrue(editCategory != "");
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
    
    @Test
    public void testEditRandomCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String editCategory = categoriesPage.editRandomCategory();
        Assume.assumeTrue(editCategory != "");
        assertTrue("Failure - category wasn't edited", categoriesPage.getAlertMessage().contains("has been successfully saved!"));
    }
    
    @Test
    public void testEditBTCRandomCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String editCategory = categoriesPage.editBTCRandomCategory();
        Assume.assumeTrue(editCategory != "");
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
    
    @Test
    public void testEnableFirstCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String enableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("D".equals(enableStatus));
        String enableCategory = categoriesPage.enableFirstCategory();
        assertTrue("Failure - category wasn't edited", categoriesPage.getAlertMessage().contains("has been enabled"));
    }
    
    @Test
    public void testCloseEnableFirstCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String enableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("D".equals(enableStatus));
        String enableCategory = categoriesPage.closeEnableFirstCategory();
        
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
    
    @Test
    public void testEnableRandomCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String enableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("D".equals(enableStatus));
        String enableCategory = categoriesPage.enableRandomCategory();
        assertTrue("Failure - category wasn't enabled", categoriesPage.getAlertMessage().contains("has been enabled"));
    }
    
    @Test
    public void testCloseEnableRandomCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String enableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("D".equals(enableStatus));
        String enableCategory = categoriesPage.closeEnableRandomCategory();
        
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
    
    @Test
    public void testDisableFirstCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String disableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("E".equals(disableStatus));
        String editCategory = categoriesPage.disableFirstCategory();
        assertTrue("Failure - category wasn't disabled", categoriesPage.getAlertMessage().contains("has been disabled"));
    }
    
    @Test
    public void testCloseDisableFirstCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String disableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("E".equals(disableStatus));
        String editCategory = categoriesPage.closeDisableFirstCategory();
        
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
    
    @Test
    public void testDisableRandomCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String disableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("E".equals(disableStatus));
        String editCategory = categoriesPage.disableRandomCategory();
        assertTrue("Failure - category wasn't disabled", categoriesPage.getAlertMessage().contains("has been disabled"));
    }
    
    @Test
    public void testCloseDisableRandomCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String disableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("E".equals(disableStatus));
        String editCategory = categoriesPage.closeDisableRandomCategory();
        
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
        
    }
    
    @Test
    public void testDeleteFirstCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String deleteCategory = categoriesPage.deleteFirstCategory();
        Assume.assumeTrue(deleteCategory != "");
        assertTrue("Failure - category wasn't deleted", categoriesPage.getAlertMessage().contains("has been successfully deleted!"));
        assertTrue("Failure - wrong category deleted", categoriesPage.getAlertMessage().contains(deleteCategory));
    }
    
    @Test
    public void testCloseDeleteFirstCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String deleteCategory = categoriesPage.closeDeleteFirstCategory();
        Assume.assumeTrue(deleteCategory != "");
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
    
    @Test
    public void testDeleteRandomCategory() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String deleteCategory = categoriesPage.deleteRandomCategory();
        Assume.assumeTrue(deleteCategory != "");
        assertTrue("Failure - category wasn't deleted", categoriesPage.getAlertMessage().contains("has been successfully deleted!"));
        assertTrue("Failure - wrong category deleted", categoriesPage.getAlertMessage().contains(deleteCategory));
    }   
    
    @Test
    public void testCloseDeleteRandomCategory1() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        String deleteCategory = categoriesPage.closeDeleteRandomCategory();
        Assume.assumeTrue(deleteCategory != "");
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
 }
