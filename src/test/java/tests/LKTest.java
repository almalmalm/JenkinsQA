package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import static org.openqa.selenium.By.className;
import static org.testng.Assert.assertEquals;

public class LKTest extends BaseTest {

    @Test
    public void testJenkinsTitle(){
        getDriver().get("https://www.jenkins.io/");
        String title = getDriver().getTitle();
        String expectedTitle = "Jenkins";

        Assert.assertEquals(title, expectedTitle );
    }

    @Test
    public void testDocumentationButton() {
        getDriver().get("https://www.jenkins.io/");
        WebElement documentationButton = getDriver().findElement(By.cssSelector("a[href=\"/doc/\"]"));
        documentationButton.click();

        String title = getDriver().getTitle();
        String expectedTitle = "Jenkins User Documentation";
        Assert.assertEquals(title, expectedTitle );
    }

    @Test
    public void testSeleniumJava() {

        getDriver().get("https://www.selenium.dev/");
        WebElement searchButton = getDriver().findElement(className("DocSearch-Button-Placeholder"));
        searchButton.click();
        WebElement search = getDriver().findElement(By.id("docsearch-input"));
        search.sendKeys("Java");

        WebElement item = getWait2().until(ExpectedConditions.visibilityOfElementLocated(By.id("docsearch-item-1")));
        item.click();

        WebElement java = getDriver().findElement(By.xpath("//*[@id=\"java\"]"));
        assertEquals(java.getText(), "Java");
    }

    @Test
    public void testJenkinsButtonHovering() {

        Actions action = new Actions(getDriver());

                getDriver().get("https://www.selenium.dev/");
        WebElement element = getDriver().findElement(By.cssSelector(".lead.mt-3.mb-0"));

        System.out.println(element.getText());

//        getDriver().get("https://www.selenium.dev/");
//        action.moveToElement(getDriver().findElement(By.className("DocSearch DocSearch-Button")))
//                .perform();
    }
}
