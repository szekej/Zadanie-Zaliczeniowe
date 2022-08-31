package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn(String email, String pass) throws InterruptedException {
        WebElement signInButton = driver.findElement(By.cssSelector("[title~='Log']"));
        signInButton.click();
        Thread.sleep(1000);
        WebElement emailInput = driver.findElement(By.cssSelector("[name='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[name='password']"));
        WebElement submitButton = driver.findElement(By.cssSelector("[id='submit-login']"));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(pass);
        submitButton.click();
    }

    public void goToClothesPage() {
        WebElement clothesTab = driver.findElement(By.cssSelector("[id='category-3']"));
        clothesTab.click();
    }
}
