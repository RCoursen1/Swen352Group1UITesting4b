package edu.rit.swen253.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import edu.rit.swen253.page.FeedbackPage;
import edu.rit.swen253.utils.DomElement;

public class NavTests extends AbstractWebTest {



    @Test
    void testGetFeedback(){
        FeedbackPage homePage = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/landing", FeedbackPage::new);
        homePage.findOnPage(By.xpath("/html/body/div[1]/app-root/div[2]/mat-sidenav-container[1]/mat-sidenav-content/headers/div/div[3]/a[1]")).click();
        FeedbackPage fbPage = assertNewPage(FeedbackPage::new);
       
        assertTrue(fbPage.getURL().equals("https://shibboleth.main.ad.rit.edu/idp/profile/SAML2/Redirect/SSO?execution=e1s1"));//feedback page requires user to login
    }


    @Test
    void testHrAndLocation(){
        FeedbackPage homePage = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/landing", FeedbackPage::new);
        homePage.findOnPage(By.xpath("/html/body/div[1]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[5]/a[1]/div")).click();
        FeedbackPage hrPage = assertNewPage(FeedbackPage::new);
        assertTrue(hrPage.getURL().equals("https://tigercenter.rit.edu/tigerCenterApp/api/hours-and-locations"));
    }


    @Test
    void testGetSidebar(){
        FeedbackPage homePage = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/landing", FeedbackPage::new);
        homePage.findOnPage(By.xpath("/html/body/div[1]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[5]/a[1]/div")).click();
        FeedbackPage hrPage = assertNewPage(FeedbackPage::new);

        DomElement side = hrPage.findOnPage(By.cssSelector("button.mat-focus-indicator:nth-child(2) > span:nth-child(1) > img:nth-child(1)"));
        side.click();
        DomElement bar = hrPage.findOnPage(By.cssSelector(".mat-nav-list"));
        assertTrue(bar.isDisplayed());

    }
  }
        

