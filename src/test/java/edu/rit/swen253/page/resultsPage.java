package edu.rit.swen253.page;

import org.openqa.selenium.By;

import edu.rit.swen253.utils.DomElement;

public class resultsPage extends AbstractAngularPage{

    protected resultsPage(String angularViewName) {
        super(angularViewName);
        //TODO Auto-generated constructor stub
    }


    private DomElement firstResultDiv = findOnPage(By.className("col-xs-12 col-sm-7 col-md-7 col-lg-7"));
    

    public void clickFirstResultDiv() {
        firstResultDiv.click();
    }


    public String getFirstDescription() {
        return firstResultDiv.findChildBy(By.className("span")).getText();
    }


}
