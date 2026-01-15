package edu.rit.swen253.page.gpa;

import org.openqa.selenium.By;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.DomElement;

public class GpaCalcPage extends AbstractPage {

    private DomElement cumGpaField = findOnPage(By.id("cumulativeGpa"));
    private DomElement gradCheckBox = findOnPage(By.id("gradStudent"));
    private DomElement calculateButton = findOnPage(By.id("calculateGpaButton"));
    private DomElement resetButton = findOnPage(By.id("resetButton"));
    private DomElement creditsField = findOnPage(By.id("earnedCredits"));

    public void enterCredits(int credits) {
        creditsField.clear();
        creditsField.sendKeys(String.valueOf(credits));
    }

    public void enterCumGpa(double gpa) {
        cumGpaField.clear();
        cumGpaField.sendKeys(String.valueOf(gpa));
    }

    public void toggleGrad(boolean isGrad) {
        if (gradCheckBox.isSelected() != isGrad) {
            gradCheckBox.click();
        }
    }

    public void addCourse(String name, int credits, String grade, String pastGrade) {
        findOnPage(By.id("courseName")).sendKeys(name);
        findOnPage(By.id("courseCredits")).sendKeys(String.valueOf(credits));
        findOnPage(By.id("courseGrade")).sendKeys(grade);

        if (pastGrade != null && !pastGrade.isEmpty()) {
            findOnPage(By.id("pastGrade")).sendKeys(pastGrade);
        }
    }

    public GpaResultView clickCalculate() {
        calculateButton.click();
        return new GpaResultView();
    }

    public void clickReset() {
        resetButton.click();
    }
}
