package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ClothesPage {
    private WebDriver driver;

    public ClothesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseSweater() {
        WebElement sweater = driver.findElement(By.cssSelector("[data-id-product='2']"));
        sweater.click();
    }

    public void checkIfDiscount() {
        WebElement regularPrice = driver.findElement(By.cssSelector("[class='regular-price']"));
        WebElement discountedPrice = driver.findElement(By.cssSelector("[itemprop='price']"));
        double priceAfterDiscount = Double.parseDouble(regularPrice.getText().substring(1, 6)) * 0.8; //przycinamy z €35.90 do 35.90
        Assert.assertEquals(String.valueOf(priceAfterDiscount), discountedPrice.getText().substring(1, 6));
    }

    public void selectSize(String size) {
        WebElement sizeList = driver.findElement(By.cssSelector("[name='group[1]']"));
        sizeList.click();
        switch (size) {
            case "S":
                WebElement sizeS = driver.findElement(By.cssSelector("[title='S']"));
                sizeS.click();
                break;
            case "M":
                WebElement sizeM = driver.findElement(By.cssSelector("[title='M']"));
                sizeM.click();
                break;
            case "L":
                WebElement sizeL = driver.findElement(By.cssSelector("[title='L']"));
                sizeL.click();
                break;
            case "XL":
                WebElement sizeXL = driver.findElement(By.cssSelector("[title='XL']"));
                sizeXL.click();
                break;
        }
    }

    public void selectQuantity(String number) throws InterruptedException {
        WebElement quantity = driver.findElement(By.cssSelector("[id='quantity_wanted']"));
        Thread.sleep(1500);
        quantity.clear();
        quantity.sendKeys(number);
    }

    public void addToCart() throws InterruptedException {
        Thread.sleep(1500);
        WebElement submitButton = driver.findElement(By.cssSelector("[class~='add-to-cart']"));
        submitButton.click();
    }

    public void proceedToCheckout() {
        WebElement goToCheckout = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        goToCheckout.click();
        WebElement goToCheckout2 = driver.findElement(By.xpath("//div[@class='text-sm-center']"));
        goToCheckout2.click();
    }
}
