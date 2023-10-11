package tests.search_apartment;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.example.constants.Constant.Urls.REALT_HOME_PAGE;

public class SearchApartmentTest extends BaseTest {

    @Test
    public void checkIsRedirectToListing() {
        basePage.open(REALT_HOME_PAGE);
        realtHomePage
                .enterCountRooms()
                .clickToFind();

        realtListingPage.checkCountCards();
    }

}
