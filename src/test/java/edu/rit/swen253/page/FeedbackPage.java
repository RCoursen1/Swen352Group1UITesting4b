package edu.rit.swen253.page;

import org.openqa.selenium.By;

import edu.rit.swen253.utils.SeleniumUtils;

public class FeedbackPage extends AbstractPage {
        private static final By input = By.name("search");
    private static final By searchButton = By.cssSelector("button[type='submit']");

    public boolean searchInput(){
        return hasDomElement(input);
    }


    // public List<String> getSearchResults(){
    //     List<DomElement> result = findAllOnPage(By.cssSelector("ul.mw-search-results li.mw-search-result a"));
    //     return result.stream().map(DomElement::getText).collect(Collectors.toList());
    // }
    
    public void search(String str){
        findOnPage(input).sendKeys(str);
        findOnPage(searchButton).click();
    }

  public String getURL() {
    return SeleniumUtils.getInstance().getCurrentUrl();
  }


}
