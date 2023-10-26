package org.example.waiters;


import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericJSWaiting {
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
