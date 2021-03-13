package steps.com.ebaySteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EbayHomepage;
import pages.EbaySearchResultPage;
import utils.ConfigReader;
import utils.Driver;

import static utils.Driver.getDriver;

public class EbaySearchSteps {
    WebDriver driver;
    EbayHomepage ebayHomepage;
    EbaySearchResultPage ebaySearchResultPage;
    @Given("user is on ebay home page")
    public void user_is_on_ebay_home_page() {
        driver= Driver.getDriver();
        getDriver().get("https://ebay.com");

    }
    @When("user searches for iMac 2020")
    public void user_searches_for_i_mac() {
        ebayHomepage=new EbayHomepage(driver);
        ebayHomepage.searchBox.sendKeys(ConfigReader.getProperty("searchValue"));
        ebayHomepage.searchButton.click();

    }
    @Then("user sees results abouts iMac only")
    public void user_sees_results_abouts_i_mac_only() {
        ebaySearchResultPage=new EbaySearchResultPage(driver);
        for (WebElement link :ebaySearchResultPage.listOfLinks){
            System.out.println(link.getText());
        }


    }
    @And("there are more than 3 pages of results")
    public void there_are_more_than_pages_of_results() {
        ebaySearchResultPage=new EbaySearchResultPage(driver);
       int actualPageNumber= ebaySearchResultPage.pages.size();
        Assert.assertTrue(actualPageNumber>3);



    }
    }
