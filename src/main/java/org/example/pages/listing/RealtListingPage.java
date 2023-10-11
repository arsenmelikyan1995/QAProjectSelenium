package org.example.pages.listing;

import org.example.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.example.constants.Constant.Numbers.EXPECTED_CARD_COUNT;

public class RealtListingPage extends BasePage {
    public RealtListingPage(WebDriver driver) {
        super(driver);
    }

    private final By card = By.xpath("//div[@class='cursor-pointer w-full h-full']");

    public RealtListingPage checkCountCards() {
        int countCard = driver.findElements(card).size();
        Assert.assertEquals(countCard, EXPECTED_CARD_COUNT);

        return this;
    }

}
