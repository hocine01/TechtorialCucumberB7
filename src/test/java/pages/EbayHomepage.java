package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHomepage {

    public EbayHomepage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }


    @FindBy(id = "gh-ac")
    public WebElement searchBox;
    @FindBy(id = "gh-btn")
    public WebElement searchButton;
}
