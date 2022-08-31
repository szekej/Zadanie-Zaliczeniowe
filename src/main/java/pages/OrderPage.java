package pages;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void shippingMethod() {
        WebElement shippingTab = driver.findElement(By.cssSelector("[id='checkout-delivery-step']"));
        shippingTab.click();
        WebElement deliveryOption = driver.findElement(By.cssSelector("[class='custom-radio float-xs-left']"));
        deliveryOption.click();
    }

    public void paymentMethod() {
        WebElement paymentTab = driver.findElement(By.cssSelector("[id='checkout-payment-step']"));
        paymentTab.click();
        WebElement paymentOption = driver.findElement(By.cssSelector("[id='payment-option-1']"));
        WebElement confirmationCheckbox = driver.findElement(By.cssSelector("[id='conditions_to_approve[terms-and-conditions]']"));
        paymentOption.click();
        confirmationCheckbox.click();
    }

    public void orderWithObligation() {
        WebElement submitButton = driver.findElement(By.cssSelector("[class='btn btn-primary center-block']"));
        submitButton.click();
    }

    public void takeScreenshot() throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFileToDirectory(screenshotFile, new File("C://Users/Asus/OneDrive/Pulpit/javaCL/ZadanieZaliczeniowe/screenshots"));
    }

    public void checkAddress(String name, String address, String city, String postalCode, String country) {
        WebElement addressInfo = driver.findElement(By.xpath("//div[@class='address']"));
        String actualAddress = name + "\n" + address + "\n" + city + "\n" + postalCode + "\n" + country;
        Assert.assertEquals(addressInfo.getText(), actualAddress);
//        Assert.assertTrue(addressInfo.getText().contains(address));
//        Assert.assertTrue(addressInfo.getText().contains(city));
//        Assert.assertTrue(addressInfo.getText().contains(postalCode));
//        Assert.assertTrue(addressInfo.getText().contains(country));
    }

    public void checkOrderPrice() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        driver.navigate().back();
        WebElement orderReference = driver.findElement(By.xpath("//div[@class='order-confirmation-table']/table/tbody/tr[3]/td[2]"));
        String orderPrice = orderReference.getText().substring(1);
        driver.navigate().forward();
        driver.navigate().forward();

        Thread.sleep(1000);
        WebElement totalPrice = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        String totalPriceAsString = totalPrice.getText().substring(1);
        Assert.assertEquals(orderPrice,totalPriceAsString);
    }

    public void goToAccountPage() {
        WebElement goToAccount = driver.findElement(By.cssSelector("[class='account']"));
        goToAccount.click();
    }
}
