package sources;

import static org.junit.Assert.*;
import org.junit.Test;
import baseTest.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.PortalPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesPage;

@FixMethodOrder(MethodSorters.JVM)
public class SourcesTest extends BaseTest{
    
    @Test
    public void testBrzeVestiLink() {
        SourcesPage sourcesPage = dashboardPage.clickOnSourcesLink();
        sourcesPage.clickOnLogoLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
    }
    
    @Test
    public void testDashboardLink() {
        SourcesPage sourcesPage = dashboardPage.clickOnSourcesLink();
        DashboardPage dashboardPage1 = sourcesPage.clickOnDashboardLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Dashboard", dashboardPage1.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin", dashboardPage1.getPanelTitle());
    }
    
    @Test
    public void testSignaturesLink() {
        SourcesPage sourcesPage = dashboardPage.clickOnSourcesLink();
        SignaturesPage signaturesPage = sourcesPage.clickOnSignaturesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/signatures", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Signatures", signaturesPage.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Signatures", signaturesPage.getPanelTitle());
    }
    
    @Test
    public void testCategoriesLink() {
        SourcesPage sourcesPage = dashboardPage.clickOnSourcesLink();
        CategoriesPage categoriesPage = sourcesPage.clickOnCategoriesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("Categories"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
    
     @Test
    public void testRegionsLink() {
        SourcesPage sourcesPage = dashboardPage.clickOnSourcesLink();
        RegionsPage regionsPage = sourcesPage.clickOnRegionsLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("Regions"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
    @Test
    public void testPortalsLink() {
        SourcesPage sourcesPage = dashboardPage.clickOnSourcesLink();
        PortalPage portalPage = sourcesPage.clickOnPortalLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("Portals"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
    
    @Test
    public void testSourcesLink() {
        SourcesPage sourcesPage = dashboardPage.clickOnSourcesLink();
        sourcesPage.clickOnSourcesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/sources", driver.getCurrentUrl());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Sources", sourcesPage.getPanelTitle());
    }
    
    @Test
    public void testLogoutLink() {
        SourcesPage sourcesPage = dashboardPage.clickOnSourcesLink();
        DashboardPage logoutButton = sourcesPage.clickOnLogoutLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
        assertEquals("Failure: Title's doesn't match", "Brze vesti", logoutButton.getPanelTitle());
    }
    
    
}
    

