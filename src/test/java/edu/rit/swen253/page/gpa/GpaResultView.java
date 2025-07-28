package edu.rit.swen253.page.gpa;

import org.openqa.selenium.By;

import edu.rit.swen253.utils.DomElement;

public class GpaResultView {

    private final DomElement termGpaField = DomElement.findBy(By.id("termGpa"));
    private final DomElement cumGpaField = DomElement.findBy(By.id("cumulativeGpa"));

    public DomElement getTermGpa() {
        return termGpaField;
    }

    public DomElement getCumGpa() {
        return cumGpaField;
    }
}