package ui.steps;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestStep {
    Logger LOGGER = LoggerFactory.getLogger(TestStep.class);
    @Given("an open browser with google.com")
    public void openGoogleSearch() {
        open("https://google.com/ncr");
//        sleep(500);
        if ($(byText("Accept all")).isDisplayed()) {
            $(byText("Accept all")).shouldBe(visible).click();
            $(byText("Accept all")).should(disappear);
        }
    }

    @When("a keyword {string} is entered in input field")
    public void enterKeyword(String keyword) {
        $(By.name("q")).val(keyword).pressEnter();
    }

    @Then("at least top {int} matches should be shown")
    public void topTenMatchesShouldBeShown(int resultsCount) {
        $$("#res .g").shouldHave(sizeGreaterThanOrEqual(resultsCount));
    }

    @Then("the first one should contain {string}")
    public void theFirstOneShouldContainKeyword(String expectedText) {
        $("#res .g").shouldHave(text(expectedText));
    }
}
