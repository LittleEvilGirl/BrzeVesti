package portal;

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
import org.openqa.selenium.support.ui.Select;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.PortalPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesPage;

@FixMethodOrder(MethodSorters.JVM)
public class PortalTest extends BaseTest{
    
    private By disableSpan = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[1]/td[4]/span");
    
    @Test
    public void testBrzeVestiLink() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        portalPage.clickOnLogoLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
    }
    
    @Test
    public void testDashboardLink() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        DashboardPage dashboardPage1 = portalPage.clickOnDashboardLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Dashboard", dashboardPage1.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin", dashboardPage1.getPanelTitle());
    }
    
    @Test
    public void testSignaturesLink() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        SignaturesPage signaturesPage = portalPage.clickOnSignaturesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/signatures", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Signatures", signaturesPage.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Signatures", signaturesPage.getPanelTitle());

    }
    
    @Test
    public void testCategoriesLink() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        CategoriesPage categoriesPage = portalPage.clickOnCategoriesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
    
    @Test
    public void testRegionsLink() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        RegionsPage regionsPage = portalPage.clickOnRegionsLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
     @Test
    public void testPortalsLink() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        portalPage.clickOnPortalLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
            }
    
    @Test
    public void testSourcesLink() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        SourcesPage sourcesPage = portalPage.clickOnSourcesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/sources", driver.getCurrentUrl());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Sources", sourcesPage.getPanelTitle());
    }
    
    @Test
    public void testLogoutLink() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        DashboardPage logoutButton = portalPage.clickOnLogoutLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
        assertEquals("Failure: Title's doesn't match", "Brze vesti", logoutButton.getPanelTitle());
    }
    
    @Test
    public void testAddNewPortal() throws IOException {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[1]/a/span")).click();
        String newPortalTitle = Helper.getRandomText();
        driver.findElement(By.id("title")).sendKeys(newPortalTitle);
        driver.findElement(By.id("url")).click();
        String newPortalUrl = "https://www.danas.rs";
        driver.findElement(By.id("url")).clear();
        driver.findElement(By.id("url")).sendKeys(newPortalUrl);
        Select regionDropdown = new Select(driver.findElement(By.name("region_id")));
        regionDropdown.selectByIndex(1);
        driver.findElement(By.id("save-portal-button")).click();
        WebElement message = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[2]/div"));
        assertEquals("Titles doesn't match", "Portal \"" + newPortalTitle + "\" has been successfully saved!", message.getText());
    }
    
    @Test
    public void testReorderFirstPortal() throws InterruptedException {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String reorderPortal = portalPage.reorderFirstPortalRow();
        Assume.assumeTrue(reorderPortal != "");
        assertTrue("Failure - portal wasn't reordered", portalPage.getAlertMessage().contains("has been reordered"));
        assertTrue("Failure - wrong portal reordered", portalPage.getAlertMessage().contains(reorderPortal));
    }
    
    @Test
    public void testReorderRandomPortal() throws InterruptedException {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String reorderPortal = portalPage.reorderRandomPortalRow();
        Assume.assumeTrue(reorderPortal != "");
        assertTrue("Failure - portal wasn't reordered", portalPage.getAlertMessage().contains("has been reordered"));
        assertTrue("Failure - wrong portal reordered", portalPage.getAlertMessage().contains(reorderPortal));
    }
    
    @Test
    public void testEditFirstPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String editPortal = portalPage.editFirstPortal();
        Assume.assumeTrue(editPortal != "");
        assertTrue("Failure - portal wasn't edited", portalPage.getAlertMessage().contains("has been successfully saved!"));
    }
    
    @Test
    public void testEditBTPFirstPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String editPortal = portalPage.editBTPFirstPortal();
        Assume.assumeTrue(editPortal != "");
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
    
    @Test
    public void testEditRandomPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String editPortal = portalPage.editRandomPortal();
        Assume.assumeTrue(editPortal != "");
        assertTrue("Failure - portal wasn't edited", portalPage.getAlertMessage().contains("has been successfully saved!"));
    }
    
    @Test
    public void testEditBTRRandomRegion() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String editPortal = portalPage.editBTPRandomPortal();
        Assume.assumeTrue(editPortal != "");
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
    
    @Test
    public void testEnableFirstPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String enableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("D".equals(enableStatus));
        String enablePortal = portalPage.enableFirstPortal();
        assertTrue("Failure - portal wasn't enabled", portalPage.getAlertMessage().contains("has been enabled"));
    }
    
    @Test
    public void testCloseEnableFirstPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String enableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("D".equals(enableStatus));
        String editPortal = portalPage.closeEnableFirstPortal();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
    
    @Test
    public void testEnableRandomPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String enableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("D".equals(enableStatus));
        String enablePortal = portalPage.enableRandomPortal();
        assertTrue("Failure - portal wasn't enabled", portalPage.getAlertMessage().contains("has been enabled"));
    }
    
    @Test
    public void testCloseEnableRandomPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String enableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("D".equals(enableStatus));
        String editPortal = portalPage.closeEnableRandomPortal();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
    
    @Test
    public void testDisableFirstPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String disableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("E".equals(disableStatus));
        String disablePortal = portalPage.disableFirstPortal();
        assertTrue("Failure - portal wasn't disabled", portalPage.getAlertMessage().contains("has been disabled"));
    }
    
    @Test
    public void testCloseDisableFirstPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String disableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("E".equals(disableStatus));
        String disablePortal = portalPage.closeDisableFirstPortal();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
    
    @Test
    public void testDisableRandomPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String disableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("E".equals(disableStatus));
        String disablePortal = portalPage.disableRandomPortal();
        assertTrue("Failure - portal wasn't disabled", portalPage.getAlertMessage().contains("has been disabled"));
    }
    
    @Test
    public void testCloseDisableRandomPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String disableStatus = driver.findElement(disableSpan).getText();
        Assume.assumeTrue("E".equals(disableStatus));
        String disablePortal = portalPage.closeDisableRandomPortal();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
    
    @Test
    public void testDeleteFirstPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String deletePortal = portalPage.deleteFirstPortal();
        Assume.assumeTrue(deletePortal != "");
        assertTrue("Failure - portal wasn't deleted", portalPage.getAlertMessage().contains("has been successfully deleted!"));
        assertTrue("Failure - wrong portal deleted", portalPage.getAlertMessage().contains(deletePortal));
    }
    
    @Test
    public void testCloseDeleteFirstPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String deletePortal = portalPage.closeDeleteFirstPortal();
        Assume.assumeTrue(deletePortal != "");
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
    
    @Test
    public void testDeleteRandomPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String deletePortal = portalPage.deleteRandomPortal();
        Assume.assumeTrue(deletePortal != "");
        assertTrue("Failure - portal wasn't deleted", portalPage.getAlertMessage().contains("has been successfully deleted!"));
        assertTrue("Failure - wrong portal deleted", portalPage.getAlertMessage().contains(deletePortal));
    }   
    
    @Test
    public void testCloseDeleteRandomPortal() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        String deletePortal = portalPage.closeDeleteRandomPortal();
        Assume.assumeTrue(deletePortal != "");
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
 }
