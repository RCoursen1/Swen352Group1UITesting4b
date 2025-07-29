package edu.rit.swen253.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import edu.rit.swen253.page.HoursAndLocationsPage;
import edu.rit.swen253.page.SimplePage;
import edu.rit.swen253.page.resultsPage;
import edu.rit.swen253.page.tiger.TigerCenterHomePage;
import edu.rit.swen253.utils.BrowserWindow;
import edu.rit.swen253.utils.HtmlUtils; 
import static edu.rit.swen253.utils.BrowserType.*;
import static edu.rit.swen253.utils.TimingUtils.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class unknownDiningServiceScenarioTest extends AbstractWebTest{
    private TigerCenterHomePage homePage;
    private BrowserWindow<TigerCenterHomePage> homeWindow;
    private HoursAndLocationsPage Page;

    
    @Test
    @Order(1)
    @DisplayName("First, navigate to the Tiger Center Home page.")
    void navigateToHomePage() {
        homePage = navigateToPage("https://tigercenter.rit.edu", TigerCenterHomePage::new);
        assertNotNull(homePage);
        homeWindow = getCurrentWindow();
    }

    @Test
    @Order(2)
    @DisplayName("Second, click on the Hours and Locations at RIT button and validate navigation.")
    void navigateToHoursAndLocations() {
    homePage.selectHoursAndLocations();
    final HoursAndLocationsPage locationsPage = assertNewPage(HoursAndLocationsPage::new);
    // there's a timing issue with Firefox (give it a second to render)
    if (onBrowser(FIREFOX)) {
      sleep(1);
    }
    assertEquals("https://tigercenter.rit.edu/tigerCenterApp/api/hours-and-locations", locationsPage.getURL());
    Page = locationsPage;
  }
  @Test
  @Order(3)
  @DisplayName("Third, get the first store thats open or alphabetically first")
  void sortByOpenNow() {
    Page.sortByOpenNow();
    Page.clickFirstResult();
    assertEquals(Page.getHours(),"7:30AM - 2:30PM" );
  }
}
