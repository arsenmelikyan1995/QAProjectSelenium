package org.example.waiters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitFor {
    public static WebDriverWait clickableLink(WebDriver driver) {
        return (WebDriverWait) new WebDriverWait(driver, 10)
                .pollingEvery(Duration.ofMillis(100))
                .withMessage("Could not find a clickable link.")
                .withTimeout(Duration.ofSeconds(5))
                .ignoring(NullPointerException.class);
    }
}