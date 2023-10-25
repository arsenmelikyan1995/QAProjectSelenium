package org.example.constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Constant {
    public static class TimeoutVariable {
        public static final int IMPLICIT_WAIT = 4;
        public static final int EXPLICIT_WAIT = 10;

    }

    public static class Urls {
        public static final String REALT_HOME_PAGE = "https://realt.by/";
    }

    public static class Numbers {

        public static final int EXPECTED_CARD_COUNT = 30;
    }

    public static class WaitFor {
        public static WebDriverWait clickableLink(WebDriver driver) {
            return (WebDriverWait) new WebDriverWait(driver, 10)
                    .pollingEvery(Duration.ofMillis(100))
                    .withMessage("Could not find a clickable link.")
                    .withTimeout(Duration.ofSeconds(5))
                    .ignoring(NullPointerException.class);
        }
    }

}
