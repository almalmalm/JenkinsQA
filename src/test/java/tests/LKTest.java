package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

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
    public void testSeleniumJava() throws InterruptedException {
        getDriver().get("https://www.selenium.dev/");
        WebElement searchButton = getDriver().findElement(By.className("DocSearch-Button-Placeholder"));
        searchButton.click();
        WebElement search = getDriver().findElement(By.id("docsearch-input"));
        search.sendKeys("Java");
        Thread.sleep(1000);

        WebElement item = getDriver().findElement(By.id("docsearch-item-1"));
        item.click();

        WebElement java = getDriver().findElement(By.xpath("//*[@id=\"java\"]"));
        assertEquals(java.getText(), "Java");
    }
}
