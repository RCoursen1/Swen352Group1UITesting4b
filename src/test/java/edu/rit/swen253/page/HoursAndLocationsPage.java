package edu.rit.swen253.page;

import java.util.List;

import org.openqa.selenium.By;

import edu.rit.swen253.utils.DomElement;
import edu.rit.swen253.utils.SeleniumUtils;

public class HoursAndLocationsPage extends AbstractPage{
    
    private DomElement sortButton = findOnPage(By.className("diningTabSortOpenButton"));
    
    public String getURL() {
        return SeleniumUtils.getInstance().getCurrentUrl();
    }
    
    public void sortByOpenNow() {
        sortButton.click();
    }

    public void clickFirstResult() {
        List<DomElement> results = findAllOnPage(By.className("diningTabEateryName"));
        results.get(0).click();
    }

    public String getHours() {
        return findOnPage(By.className("redText")).getText();
    }

    public void search(String locationName) {
        findOnPage(By.id("mat-input-0")).sendKeys(locationName);
    }

    
}
