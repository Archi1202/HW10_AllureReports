package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Feature("Issue elements")
@Owner("Anuar Zhangeldi")
@DisplayName("Check the Issue element via Selenide approach")

public class SelenideTest extends TestBase {

    private static final String repository = "qa-guru/qa_guru_14_10";
    private static final String issueText = "Issue for Autotest";

    @Test
    @Story("Verification of the specific issue via Selenide in QA GURU Github page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Github page QA GURU", url = "https://github.com/qa-guru/qa_guru_14_10/issues")
    @DisplayName("Check that on Issues Github page there is an element " + issueText + " displayed")
    void issueSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/");
        $(".search-input-container").click();
        $("#query-builder-test").setValue(repository).pressEnter();
        $("[data-testid='results-list'] a[href='/qa-guru/qa_guru_14_10']").click();
        ;
        $("#issues-tab").click();
        $("div#js-navigation-container").shouldHave(text(issueText));
    }
}