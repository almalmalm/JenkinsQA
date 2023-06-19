package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class LKTest extends BaseTest {

    @Test
    public void testJenkinsTitle(){
        getDriver().get("https://www.jenkins.io/");
        String title = getDriver().getTitle();
        String expectedTitle = "Jenkins";

        Assert.assertEquals(title, expectedTitle );
    }
    @Test
    public void testBannerContainerColor() {
        getDriver().get("https://www.jenkins.io/");
        WebElement documentationButton = getDriver().findElement(By.cssSelector("a[href=\"/doc/\"]"));
        documentationButton.click();

        String title = getDriver().getTitle();
        String expectedTitle = "Jenkins User Documentation";
        Assert.assertEquals(title, expectedTitle );
    }
}
