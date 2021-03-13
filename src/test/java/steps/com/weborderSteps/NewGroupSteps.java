package steps.com.weborderSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.weborderPages.GroupOrderPage;
import pages.weborderPages.HomePage;
import pages.weborderPages.LoginPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;

public class NewGroupSteps {
    WebDriver driver;
    LoginPage loginPage;
    GroupOrderPage groupOrderPage;
    HomePage homePage;

    @Given("the user is on the weborder home page")
    public void the_user_is_on_the_weborder_home_page() {
        driver= Driver.getDriver();
        driver.navigate().to(ConfigReader.getProperty("webOrderUrl"));
        loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.getProperty("webOrderUsername"),ConfigReader.getProperty("webOrderPassword"));


    }
    @Then("the user select {string} options")
    public void the_user_select_options(String text) {
        homePage=new HomePage(driver);
        BrowserUtils.selectByText(homePage.deliveryOptions,text);



    }
    @Then("the user is on the group order page")
    public void the_user_is_on_the_group_order_page() {
        homePage.groupOrder.click();
        homePage.nextButton.click();

    }
    @Then("the user send invitees note {string}")
    public void the_user_send_invitees_note(String note) {
        groupOrderPage=new GroupOrderPage(driver);
        groupOrderPage.sendInviteeNote(note);

    }
    @Then("the user send invite list {string} and {string}")
    public void the_user_send_invite_list_and(String person1, String person2) {
        groupOrderPage.sendInviteList(person1+" ,"+person2);
        groupOrderPage.clickCreateGroup();

    }
    @Then("the user validate {string} text")
    public void the_user_validate_text(String expectedText) throws InterruptedException {
        Thread.sleep(2000);
        String actualText=groupOrderPage.viewGroupOrderHeader.getText();
        Assert.assertEquals(expectedText,actualText);


    }
    @Then("the user validate total participant is {int}")
    public void the_user_validate_total_participant_is(Integer int1) {
        Integer participantNumber=groupOrderPage.getParticipantNumber();
        Assert.assertEquals(int1,participantNumber);

    }
    @Then("the user send invite list")
    public void the_user_send_invite_list(List<String> emails) {
        groupOrderPage.sendInvitees(emails);
        groupOrderPage.clickCreateGroup();


    }



}
