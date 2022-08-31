package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.LandingPage;

import java.util.concurrent.TimeUnit;

public class MystoreAssressSteps {
    WebDriver driver;

    @Given("User is on {string} page")
    public void userIsOnPage(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(1000);
    }

    @When("User logs into his account with {string} and {string}")
    public void userLogsIntoHisAccountWithAnd(String email, String password) throws InterruptedException {
        LandingPage onLandingPage = new LandingPage(driver);
        onLandingPage.logIn(email, password);
    }

    @And("User clicks on address field")
    public void userClicksOnAddressField() {
        AccountPage onAccountPage = new AccountPage(driver);
        onAccountPage.goToAddresses();
    }

    @And("User clicks on {string} field")
    public void userClicksOnField(String arg0) {
        AccountPage onAccountPage = new AccountPage(driver);
        onAccountPage.createNewAddress();
    }

    @And("User fills out the form with {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillsOutTheFormWith(String alias, String address, String city, String zipCode, String country, String phone) throws InterruptedException {
        AccountPage onAccountPage = new AccountPage(driver);
        onAccountPage.fillForm(alias, address, city, zipCode, country, phone);
    }

    @And("User checks that the data in the added address is correct")
    public void userChecksThatTheDataInTheAddedAddressIsCorrect() {
        AccountPage onAccountPage = new AccountPage(driver);
        onAccountPage.checkIfDataOk();
    }

    @And("User deletes the above address by clicking on {string}")
    public void userDeletesTheAboveAddressByClickingOn(String arg0) throws InterruptedException {
        AccountPage onAccountPage = new AccountPage(driver);
        onAccountPage.deleteAddress();
    }

    @Then("Address has been removed")
    public void addressHasBeenRemoved() {
        AccountPage onAccountPage = new AccountPage(driver);
        onAccountPage.checkIfDeleted();
    }

}
