package signature;

import static org.junit.Assert.*;
import org.junit.Test;
import baseTest.BaseTest;
import java.util.List;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.PortalPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesPage;

@FixMethodOrder(MethodSorters.JVM)
public class SignatureTest extends BaseTest{
    
    private By changeCategoryFilter = By.id("newsProcessorSignatureCategoryApprove");
    private By changeCategoryApprove = By.xpath("//*[@id=\"newsProcessorSignatureApproveDialog\"]/div/div/div[3]/button[2]");
    
    private SignaturesPage signaturesPage;
    
    @Test
    public void testBrzeVestiLink() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.clickOnLogoLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
    }
    
    @Test
    public void testDashboardLink() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        DashboardPage dashboardPage1 = signaturesPage.clickOnDashboardLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Dashboard", dashboardPage1.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin", dashboardPage1.getPanelTitle());
    }
    
     @Test
    public void testSignaturesLink() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/signatures", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Signatures", signaturesPage.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Signatures", signaturesPage.getPanelTitle());
    }

    
    @Test
    public void testCategoriesLink() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        CategoriesPage categoriesPage = signaturesPage.clickOnCategoriesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
    
    @Test
    public void testRegionsLink() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        RegionsPage regionsPage = signaturesPage.clickOnRegionsLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
    @Test
    public void testPortalsLink() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        PortalPage portalPage = signaturesPage.clickOnPortalLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
    
    @Test
    public void testSourcesLink() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        SourcesPage sourcesPage = signaturesPage.clickOnSourcesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/sources", driver.getCurrentUrl());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Sources", sourcesPage.getPanelTitle());
    }
    
    @Test
    public void testLogoutLink() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        DashboardPage logoutButton = signaturesPage.clickOnLogoutLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
        assertEquals("Failure: Title's doesn't match", "Brze vesti", logoutButton.getPanelTitle());
    }
    
    @Test
    public void testPortalsFilterWithNovosti() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromPortalsDropdown("Novosti");
        List<String> portalValues = signaturesPage.getPortalValuesFromResults();
        for (String portal : portalValues) {
            assertEquals("Portals doesn't match", portal, "Novosti");
        }
    }
        
    @Test
    public void testPortalsFilterWithBlic() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromPortalsDropdown("Blic");
        List<String> portalValues = signaturesPage.getPortalValuesFromResults();
        for (String portal : portalValues) {
            assertEquals("Portals doesn't match", portal, "Blic");
        }
    }
    
    //Bug report: on page: http://bvtest.school.cubes.rs/admin/signatures Web element: <option value="all">All</option> should be selected 
    @Test
    public void testSignatureStatusFilterNew() {
        SignaturesPage signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromSignaturesStatusDropdown("New");
        List<String> signatureStatusValues = signaturesPage.getSignaturesStatusValuesFromResults();
        for (String signatureStatusValue : signatureStatusValues) {
            assertEquals("Signature status doesn't match", signatureStatusValue, "N");
        }
    }
    
    @Test
    public void testSignatureStatusFilterIgnored() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromSignaturesStatusDropdown("Ignore");
        List<String> signatureStatusValues = signaturesPage.getSignaturesStatusValuesFromResults();
        for (String signatureStatusValue : signatureStatusValues) {
            assertEquals("Signature status doesn't match", signatureStatusValue, "I");
        }
    }
    
    @Test
    public void testSignatureStatusFilterApproved() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromSignaturesStatusDropdown("Approved");
        List<String> signatureStatusValues = signaturesPage.getSignaturesStatusValuesFromResults();
        for (String signatureStatusValue : signatureStatusValues) {
            assertEquals("Signature status doesn't match", signatureStatusValue, "A");
        }
    }
    
    @Test
    public void testCategoriesFilterSvet() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromCategoriesDropdown("Svet");
        assertTrue("Category doesn't match", signaturesPage.getMessage().contains("There are no signatures matching criteria"));
    }
    
    @Test
    public void testCategoriesFilterDruštvo() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromPortalsDropdown("All Portals");
        signaturesPage.selectFromSignaturesStatusDropdown("All");
        signaturesPage.selectFromCategoriesDropdown("Društvo");
        List<String> categoryStatusValues = signaturesPage.getCategoriesValuesFromResults();
        for (String categoryStatusValue : categoryStatusValues) {
            assertEquals("Category doesn't match", categoryStatusValue, "Društvo");
        }
    }
        
    @Test
    public void testPortalsAndStatusFilters() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromPortalsDropdown("Novosti");
        signaturesPage.selectFromSignaturesStatusDropdown("Approved");
        List<String> portalValues = signaturesPage.getPortalValuesFromResults();
        for (String portal : portalValues) {
            assertEquals("Portals doesn't match", portal, "Novosti");
        }
        List<String> signatureStatusValues = signaturesPage.getSignaturesStatusValuesFromResults();
        for (String signatureStatusValue : signatureStatusValues) {
            assertEquals("Signature status doesn't match", signatureStatusValue, "A");
        }
    }
    
    @Test
    public void testChangeCategoryFirstSignature() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromCategoriesDropdown("Svet");
        String categoryToBeChanged = signaturesPage.changeCategoryFirstSignature();
        Assume.assumeTrue(categoryToBeChanged != "");
        assertTrue("Failure - after category change wrong message", signaturesPage.getAlertMessage2().contains("been approved as uncategorized"));
        assertTrue("Failure - wrong category changed", signaturesPage.getAlertMessage().contains(categoryToBeChanged));
    }
    
    @Test
    public void testChangeCategoryLastSignature() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromCategoriesDropdown("Sport");
        String categoryToBeChanged = signaturesPage.changeCategoryLastSignature();
        Assume.assumeTrue(categoryToBeChanged != "");
        assertTrue("Failure - after category change wrong message", signaturesPage.getAlertMessage().contains("been approved as uncategorized"));
        assertTrue("Failure - wrong category changed", signaturesPage.getAlertMessage().contains(categoryToBeChanged));
    }
    
    @Test
    public void testChangeCategoryRandomSignature() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        String categoryToBeChanged = signaturesPage.changeCategoryRandomSignature();
        Assume.assumeTrue(categoryToBeChanged != "");
        assertTrue("Failure - after category change wrong message", signaturesPage.getAlertMessage().contains("been approved as uncategorized"));
        assertTrue("Failure - wrong category changed", signaturesPage.getAlertMessage().contains(categoryToBeChanged));
    }
       
    @Test
    public void testIgnoreFirstSignature() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromSignaturesStatusDropdown("Approved");
        String signatureToBeIgnored = signaturesPage.ignoreFirstSignature();
        Assume.assumeTrue(signatureToBeIgnored != "");
        assertTrue("Failure - after delete wrong message", signaturesPage.getAlertMessage3().contains("has been set to IGNORE"));
        assertTrue("Failure - wrong signature deleted", signaturesPage.getAlertMessage3().contains(signatureToBeIgnored));
    }
    
    @Test
    public void testIgnoreLastSignature() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromSignaturesStatusDropdown("Approved");
        String signatureToBeIgnored = signaturesPage.ignoreLastSignature();
        Assume.assumeTrue(signatureToBeIgnored != "");
        assertTrue("Failure - after delete wrong message", signaturesPage.getAlertMessage3().contains("has been set to IGNORE"));
        assertTrue("Failure - wrong signature deleted", signaturesPage.getAlertMessage3().contains(signatureToBeIgnored));
    }
    
    @Test
    public void testIgnoreRandomSignature() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromSignaturesStatusDropdown("Approved");
        String signatureToBeIgnored = signaturesPage.ignoreRandomSignature();
        Assume.assumeTrue(signatureToBeIgnored != "");
        assertTrue("Failure - after delete wrong message", signaturesPage.getAlertMessage3().contains("has been set to IGNORE"));
        assertTrue("Failure - wrong signature deleted", signaturesPage.getAlertMessage3().contains(signatureToBeIgnored));
    }
    
    @Test
    public void testDeleteFirstSignature() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromPortalsDropdown("Vice");
        String signatureToBeDeleted = signaturesPage.deleteFirstSignature();
        Assume.assumeTrue(signatureToBeDeleted != "");
        assertTrue("Failure - after delete wrong message", signaturesPage.getAlertMessage().contains("has been successfully deleted!"));
        assertTrue("Failure - wrong signature deleted", signaturesPage.getAlertMessage().contains(signatureToBeDeleted));
    }
    
    @Test
    public void testDeleteLastSignature() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        signaturesPage.selectFromPortalsDropdown("Novosti");
        String signatureToBeDeleted = signaturesPage.deleteLastSignature();
        Assume.assumeTrue(signatureToBeDeleted != "");
        assertTrue("Failure - after delete wrong message", signaturesPage.getAlertMessage().contains("has been successfully deleted!"));
        assertTrue("Failure - wrong signature deleted", signaturesPage.getAlertMessage().contains(signatureToBeDeleted));
    }
    
    @Test
    public void testDeleteRandomSignature() {
        signaturesPage = dashboardPage.clickOnSignaturesLink();
        String signatureToBeDeleted = signaturesPage.deleteRandomSignature();
        Assume.assumeTrue(signatureToBeDeleted != "");
        assertTrue("Failure - after delete wrong message", signaturesPage.getAlertMessage().contains("has been successfully deleted!"));
        assertTrue("Failure - wrong signature deleted", signaturesPage.getAlertMessage().contains(signatureToBeDeleted));
    }
    
}
