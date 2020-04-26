package dashboard;

import static org.junit.Assert.*;
import org.junit.Test;
import baseTest.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pages.BrzeVestiPage;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.PortalPage;
import pages.RegionsPage;
import pages.SignaturesPage;
import pages.SourcesPage;

@FixMethodOrder(MethodSorters.JVM)
public class DashboardTest extends BaseTest{

    @Test
    public void testBrzeVestiLink() {
        BrzeVestiPage brzeVestiPage = dashboardPage.clickOnLogoLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
    }
    
    @Test
    public void testDashboardLink() {
        dashboardPage.clickOnDashboardLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Dashboard", dashboardPage.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin", dashboardPage.getPanelTitle());
    }
    
    @Test
    public void testSignaturesLink() {
        SignaturesPage signaturesPage = dashboardPage.clickOnSignaturesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/signatures", driver.getCurrentUrl());
        assertEquals("Failure: Headings doesn't match", "Signatures", signaturesPage.getPanelHeading());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Signatures", signaturesPage.getPanelTitle());
    }
    
    @Test
    public void testCategoriesLink() {
        CategoriesPage categoriesPage = dashboardPage.clickOnCategoriesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/categories", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", categoriesPage.getPanelHeading().contains("egori"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Categories", categoriesPage.getPanelTitle());
    }
    
    @Test
    public void testRegionsLink() {
        RegionsPage regionsPage = dashboardPage.clickOnRegionsLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/regions", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", regionsPage.getPanelHeading().contains("egion"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Regions", regionsPage.getPanelTitle());
    }
    
    @Test
    public void testPortalsLink() {
        PortalPage portalPage = dashboardPage.clickOnPortalLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/portals", driver.getCurrentUrl());
        assertTrue("Failure: Headings doesn't match", portalPage.getPanelHeading().contains("ortal"));
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Portals", portalPage.getPanelTitle());
    }
    
    @Test
    public void testSourcesLink() {
        SourcesPage sourcesPage = dashboardPage.clickOnSourcesLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/admin/sources", driver.getCurrentUrl());
        assertEquals("Failure: Title's doesn't match", "Brze vesti admin | Sources", sourcesPage.getPanelTitle());
    }
    
    @Test
    public void testLogoutLink() {
        DashboardPage brzeVestiPage = dashboardPage.clickOnLogoutLink();
        assertEquals("Failure: URL's doesn't match", "http://bvtest.school.cubes.rs/", driver.getCurrentUrl());
        assertEquals("Failure: Title's doesn't match", "Brze vesti", brzeVestiPage.getPanelTitle());
    }


}
