package regions;

import Framework.Helper;
import static org.junit.Assert.*;
import org.junit.Test;
import baseTest.BaseTest;
import java.io.IOException;
import org.junit.Assume;
import org.junit.FixMethodOrder;
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
public class RegionsTest extends BaseTest{
    
    private By disableSpan = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[4]/span");
    
    @Test
    public void testBrzeVestiLink() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        regionsPage.clickOnLogoLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
    }
    
    @Test
    public void testDashboardLink() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        DashboardPage dashboardPage1 = regionsPage.clickOnDashboardLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Dashboard", dashboardPage1.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin", dashboardPage1.getPanelTitle());
    }
    
    @Test
    public void testSignaturesLink() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        SignaturesPage signaturesPage = regionsPage.clickOnSignaturesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/signatures", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Signatures", signaturesPage.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Signatures", signaturesPage.getPanelTitle());
    }
    
    @Test
    public void testCategoriesLink() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        CategoriesPage categoriesPage = regionsPage.clickOnCategoriesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
    
     @Test
    public void testRegionsLink() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        regionsPage.clickOnRegionsLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
    @Test
    public void testPortalsLink() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        PortalPage portalPage = regionsPage.clickOnPortalLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
    
    @Test
    public void testSourcesLink() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        SourcesPage sourcesPage = regionsPage.clickOnSourcesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/sources", driver.getCurrentUrl());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Sources", sourcesPage.getPanelTitle());
    }
    
    @Test
    public void testLogoutLink() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        DashboardPage logoutButton = regionsPage.clickOnLogoutLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
        assertEquals("Failure: Title's doesn't match", "Brze vesti", logoutButton.getPanelTitle());
    }
    
    @Test
    public void testAddNewRegion() throws IOException {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[1]/a")).click();
        String newRegionTitle = Helper.getRandomText();
        driver.findElement(By.id("title")).sendKeys(newRegionTitle);
        driver.findElement(By.id("save-region-button")).click();
        WebElement message = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[2]/div"));
        assertEquals("Titles doesn't match", "Region \"" + newRegionTitle + "\" has been successfully saved!", message.getText());
    }
    
    @Test
    public void testReorderFirstRegion() throws InterruptedException {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String reorderRegion = regionsPage.reorderFirstRegionRow();
        Assume.assumeTrue(reorderRegion != "");
        assertTrue("Failure - region wasn't reordered", regionsPage.getAlertMessage().contains("has been reordered"));
        assertTrue("Failure - wrong region reordered", regionsPage.getAlertMessage().contains(reorderRegion));
    }
    
    @Test
    public void testReorderRandomRegion() throws InterruptedException {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String reorderRegion = regionsPage.reorderRandomRegionRow();
        Assume.assumeTrue(reorderRegion != "");
        assertTrue("Failure - category wasn't reordered", regionsPage.getAlertMessage().contains("has been reordered"));
        assertTrue("Failure - wrong category reordered", regionsPage.getAlertMessage().contains(reorderRegion));
    }
    
    @Test
    public void testEditFirstRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String editRegion = regionsPage.editFirstRegion();
        Assume.assumeTrue(editRegion != "");
        assertTrue("Failure - category wasn't edited", regionsPage.getAlertMessage().contains("has been successfully saved!"));
    }
    
    @Test
    public void testEditBTRFirstRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String editRegion = regionsPage.editBTRFirstRegion();
        Assume.assumeTrue(editRegion != "");
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
    @Test
    public void testEditRandomRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String editRegion = regionsPage.editRandomRegion();
        Assume.assumeTrue(editRegion != "");
        assertTrue("Failure - category wasn't edited", regionsPage.getAlertMessage().contains("has been successfully saved!"));
    }
    
    @Test
    public void testEditBTRRandomRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String editRegion = regionsPage.editBTRRandomRegion();
        Assume.assumeTrue(editRegion != "");
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
    @Test
    public void testEnableFirstRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String enableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("D".equals(enableStatus));
        String enableRegion = regionsPage.enableFirstRegion();
        assertTrue("Failure - region wasn't enabled", regionsPage.getAlertMessage().contains("has been enabled"));
    }
    
    @Test
    public void testCloseEnableFirstRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String enableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("D".equals(enableStatus));
        String editCategory = regionsPage.closeEnableFirstRegion();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
    @Test
    public void testEnableRandomRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String enableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("D".equals(enableStatus));
        String enableRegion = regionsPage.enableRandomRegions();
        assertTrue("Failure - region wasn't enabled", regionsPage.getAlertMessage().contains("has been enabled"));
    }
    
    @Test
    public void testCloseEnableRandomRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String enableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("D".equals(enableStatus));
        String editCategory = regionsPage.closeEnableRandomRegions();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
    @Test
    public void testDisableFirstRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String disableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("E".equals(disableStatus));
        String disableRegion = regionsPage.disableFirstRegion();
        assertTrue("Failure - region wasn't disabled", regionsPage.getAlertMessage().contains("has been disabled"));
    }
    
    @Test
    public void testCloseDisableFirstRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String disableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("E".equals(disableStatus));
        String disableRegion = regionsPage.closeDisableFirstRegion();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
    @Test
    public void testDisableRandomRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String disableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("E".equals(disableStatus));
        String disableRegion = regionsPage.disableRandomRegion();
        assertTrue("Failure - region wasn't disabled", regionsPage.getAlertMessage().contains("has been disabled"));
    }
    
    @Test
    public void testCloseDisableRandomRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String disableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("E".equals(disableStatus));
        String disableRegion = regionsPage.closeDisableRandomRegion();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
    @Test
    public void testDeleteFirstRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String deleteRegion = regionsPage.deleteFirstRegion();
        Assume.assumeTrue(deleteRegion != "");
        assertTrue("Failure - region wasn't deleted", regionsPage.getAlertMessage().contains("has been successfully deleted!"));
        assertTrue("Failure - wrong region deleted", regionsPage.getAlertMessage().contains(deleteRegion));
    }
    
    @Test
    public void testCloseDeleteFirstRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String deleteRegion = regionsPage.closeDeleteFirstRegion();
        Assume.assumeTrue(deleteRegion != "");
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
    @Test
    public void testDeleteRandomRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String deleteRegion = regionsPage.deleteRandomRegion();
        Assume.assumeTrue(deleteRegion != "");
        assertTrue("Failure - region wasn't deleted", regionsPage.getAlertMessage().contains("has been successfully deleted!"));
        assertTrue("Failure - wrong region deleted", regionsPage.getAlertMessage().contains(deleteRegion));
    }   
    
    @Test
    public void testCloseDeleteRandomRegion() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        String deleteRegion = regionsPage.closeDeleteRandomRegion();
        Assume.assumeTrue(deleteRegion != "");
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
 }


