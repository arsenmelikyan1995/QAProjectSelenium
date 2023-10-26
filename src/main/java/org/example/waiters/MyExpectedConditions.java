package org.example.waiters;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class MyExpectedConditions {

    public ExpectedCondition<Boolean> elementHasExpandedFully(final By expandingElement) {
        return new ExpectedCondition<Boolean>() {
            private int lastHeight;

            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                int newHeight = driver.findElement(expandingElement).getSize().height;

                if (newHeight > lastHeight) {
                    lastHeight = newHeight;
                    return false;
                } else {
                    return true;
                }
            }
        };
    }
}
