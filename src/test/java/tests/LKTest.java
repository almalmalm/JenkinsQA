package tests;

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
}
