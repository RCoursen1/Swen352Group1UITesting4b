package edu.rit.swen253.test.gpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import edu.rit.swen253.page.gpa.GpaCalcPage;
import edu.rit.swen253.page.gpa.GpaResultView;
import edu.rit.swen253.test.AbstractWebTest;
import edu.rit.swen253.utils.BrowserWindow;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GpaCalcHappyPathTest extends AbstractWebTest {

    private BrowserWindow<GpaCalcPage> gpaWindow;

    @Test
    @Order(1)
    @DisplayName("Navigate to GPA Calculator Page")
    public void navigateToGpaPage() {
        GpaCalcPage gpaPage = navigateToPage("https://tigercenter.rit.edu/tigerCenterApp/api/gpa-calc", GpaCalcPage::new);
        assertNotNull(gpaPage, "GPA Calculator Page did not load.");
    }

    @Test
    @Order(2)
    @DisplayName("Enter valid data and calculate GPA")
    public void testCalculate() {
        GpaCalcPage page = gpaWindow.page();

        page.enterCredits(30);
        page.enterCumGpa(3.2);

        page.addCourse("SWEN-352", 3, "A", "");

        GpaResultView result = page.clickCalculate();

        double termGpa = Double.parseDouble(result.getTermGpa().getText());
        assertTrue(termGpa > 0.0, "Expected valid Term GPA");
    }
}
