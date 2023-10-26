package org.example.waiters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Waiting {

    private final WebDriver myDriver;
    private final int timeout;
    private final WebDriverWait wait;

    public Waiting(WebDriver driver) {
        this.myDriver = driver;
        this.timeout = 10;
        wait = new WebDriverWait(myDriver, timeout);
    }

    public WebElement untilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement untilClicked(By locator) {
        WebElement elem = untilClickable(locator);
        elem.click();
        return elem;
    }

    public WebElement untilTextContains(String partialText, By locator) {

        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.textToBePresentInElement(elem, partialText));
        return elem;
    }

    public MyExpectedConditions conditions() {
        return new MyExpectedConditions();
    }

    public void until(ExpectedCondition condition) {
        wait.until(condition);
    }

}
