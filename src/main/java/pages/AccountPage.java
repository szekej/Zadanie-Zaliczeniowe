package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAddresses() {
        WebElement addressesTab = driver.findElement(By.cssSelector("[id='addresses-link']"));
        addressesTab.click();
    }

    public void createNewAddress() {
        WebElement newAddress = driver.findElement(By.cssSelector("[data-link-action='add-address']"));
        newAddress.click();
    }

    public void fillForm(String alias, String address, String city, String zipCode, String country, String phone) throws InterruptedException {
        WebElement aliasInput = driver.findElement(By.cssSelector("[name='alias']"));
        WebElement addressInput = driver.findElement(By.cssSelector("[name='address1']"));
        WebElement cityInput = driver.findElement(By.cssSelector("[name='city']"));
        WebElement zipCodeInput = driver.findElement(By.cssSelector("[name='postcode']"));
        WebElement countryList = driver.findElement(By.cssSelector("[class~='js-country']"));
        WebElement phoneInput = driver.findElement(By.cssSelector("[name='phone']"));
        WebElement saveButton = driver.findElement(By.cssSelector("[name='submitAddress']"));

        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        zipCodeInput.sendKeys(zipCode);
        countryList.click();
        WebElement countrySelect = driver.findElement(By.cssSelector("[value='17']"));
        countrySelect.click();
        phoneInput.sendKeys(phone);
        Thread.sleep(1000);
        saveButton.submit();
    }

    public void checkIfDataOk() {
        WebElement alert = driver.findElement(By.cssSelector("[role='alert']"));
        Assert.assertEquals(alert.getAttribute("data-alert"), "success");
        Assert.assertTrue(alert.getText().contains("added"));
    }

    public void deleteAddress() throws InterruptedException {
        Thread.sleep(1000);
        WebElement deleteButton = driver.findElement(By.xpath("//section[@id='content']/div[2]/article/div[2]/a[2]"));
        deleteButton.click();
    }

    public void checkIfDeleted() {
        WebElement alert = driver.findElement(By.cssSelector("[role='alert']"));
        Assert.assertEquals(alert.getAttribute("data-alert"), "success");
        Assert.assertTrue(alert.getText().contains("deleted"));
    }

    public void goToLandingPage() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    public void goToOrderHistoryAndDetails() {
        WebElement orderHistoryEtc = driver.findElement(By.cssSelector("[id='history-link']"));
        orderHistoryEtc.click();
    }

    public void checkStatus() {
        WebElement status = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/span"));
        Assert.assertEquals(status.getText(), "Awaiting check payment");
    }
}
