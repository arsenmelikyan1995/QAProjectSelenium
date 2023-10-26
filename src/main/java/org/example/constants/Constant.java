package org.example.constants;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    public static class GenericJSWaiting {
        private final WebDriverWait wait;

        public GenericJSWaiting(WebDriver driver, int timeout) {
            this.wait = new WebDriverWait(driver, timeout);

        }

        public static ExpectedCondition<Boolean> forJSConditionToEvaluateTo(String javascript, boolean value) {
            return new ExpectedCondition<Boolean>() {
                @NullableDecl
                @Override
                public Boolean apply(@NullableDecl WebDriver driver) {
                    try {
                        Boolean jsValue = (Boolean) ((JavascriptExecutor) driver).executeScript(
                                "return " + javascript
                        );
                        return jsValue == value;
                    } catch (JavascriptException e) {
                        throw new RuntimeException("Exception evaluating - return " + javascript, e);
                    }
                }
            };
        }
    }

}
