package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.ClothesPage;
import pages.LandingPage;
import pages.OrderPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ProductOrderingSteps {
    WebDriver driver;

    @Given("User is on the {string} page")
    public void userIsOnThePage(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(1000);
    }

    @When("User logs into his account with {string} and  {string}")
    public void userLogsIntoHisAccountWithAnd(String email, String password) throws InterruptedException {
        LandingPage onLandingPage = new LandingPage(driver);
        onLandingPage.logIn(email, password);
    }

    @And("User selects the product {string}")
    public void userSelectsTheProduct(String arg0) {
        AccountPage onAccountPage = new AccountPage(driver);
        LandingPage onLandingPage = new LandingPage(driver);
        ClothesPage onClothesPage = new ClothesPage(driver);
        onAccountPage.goToLandingPage();
        onLandingPage.goToClothesPage();
        onClothesPage.chooseSweater();
    }

    @And("User checks if the discount is {int}%")
    public void userChecksIfTheDiscountIs(int arg0) {
        ClothesPage onClothesPage = new ClothesPage(driver);
        onClothesPage.checkIfDiscount();
    }

    @And("User selects the {string}")
    public void userSelectsThe(String size) {
        ClothesPage onClothesPage = new ClothesPage(driver);
        onClothesPage.selectSize(size);
    }

    @And("User selects the {string} of pieces")
    public void userSelectsTheOfPieces(String quantity) throws InterruptedException {
        ClothesPage onClothesPage = new ClothesPage(driver);
        onClothesPage.selectQuantity(quantity);
    }

    @And("User adds products to the cart")
    public void userAddsProductsToTheCart() throws InterruptedException {
        ClothesPage onClothesPage = new ClothesPage(driver);
        onClothesPage.addToCart();
    }

    @And("User proceeds to checkout option")
    public void userProceedsToCheckoutOption() {
        ClothesPage onClothesPage = new ClothesPage(driver);
        onClothesPage.proceedToCheckout();
    }

    @And("User confirms address \\({string}, {string}, {string}, {string}, {string})")
    public void userConfirmsAddress(String name, String address, String city, String postalCode, String country) {
        OrderPage onOrderPage = new OrderPage(driver);
        onOrderPage.checkAddress(name,address,city,postalCode,country);
    }

    @And("User selects the shipping method")
    public void userSelectsTheShippingMethod() {
        OrderPage onOrderPage = new OrderPage(driver);
        onOrderPage.shippingMethod();
    }

    @And("User selects the payment method")
    public void userSelectsThePaymentMethod() {
        OrderPage onOrderPage = new OrderPage(driver);
        onOrderPage.paymentMethod();
    }

    @And("User clicks on {string}")
    public void userClicksOn(String arg0) {
        OrderPage onOrderPage = new OrderPage(driver);
        onOrderPage.orderWithObligation();
    }

    @And("User takes a screenshot of the order confirmation and the amount.")
    public void userTakesAScreenshotOfTheOrderConfirmationAndTheAmount() throws IOException {
        OrderPage onOrderPage = new OrderPage(driver);
        onOrderPage.takeScreenshot();

    }

    @And("User enters order history and details")
    public void userEntersOrderHistoryAndDetails() throws InterruptedException {
        OrderPage onOrderPage = new OrderPage(driver);
        AccountPage onAccountPage = new AccountPage(driver);
        onOrderPage.goToAccountPage();
        onAccountPage.goToOrderHistoryAndDetails();
    }

    @Then("User checks if the order is listed with the status {string} and the same amount as on the order two steps earlier")
    public void userChecksIfTheOrderIsListedWithTheStatusAndTheSameAmountAsOnTheOrderTwoStepsEarlier(String price) throws InterruptedException {
        AccountPage onAccountPage = new AccountPage(driver);
        OrderPage onOrderPage = new OrderPage(driver);
        onAccountPage.checkStatus();
        onOrderPage.checkOrderPrice();
    }

}
