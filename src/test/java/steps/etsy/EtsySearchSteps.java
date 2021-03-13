package steps.etsy;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.etsy.EtsyHomePage;
import utils.BrowserUtils;
import utils.Driver;

public class EtsySearchSteps {
WebDriver driver;
EtsyHomePage etsyHomePage;
@Before
public  void beforeScenario(){
    //it will run before each scenario
    System.out.println("Before Annotation.");
}
@Before("@tc2")
public void conditionalHook(){
    System.out.println("conditional annotation");
}
@After
public void afterScenario(Scenario scenario){
    // it will run after scenario
    System.out.println("After annotation");
    if (scenario.isFailed()){
        BrowserUtils.takeScreenshot();
    }
}
    @Given("the user navigate to the {string}")
    public void the_user_navigate_to_the(String url) {
        driver= Driver.getDriver();
        driver.get(url);

    }

    @When("the user search with {string}")
    public void the_user_search_with(String searchValue) {
        etsyHomePage=new EtsyHomePage(driver);
        etsyHomePage.sendSearchKey(searchValue);


    }

    @Then("the user should see the title {string}")
    public void the_user_should_see_the_title(String expectedTitle) {
        String actualTitle= driver.getTitle();
        Assert.assertEquals("Validation of title",expectedTitle,actualTitle);



    }
}