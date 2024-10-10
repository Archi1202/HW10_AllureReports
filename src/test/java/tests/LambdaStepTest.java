package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Issue elements")
@Owner("Anuar Zhangeldi")
@DisplayName("Check the Issue element via Lambda test approach")

public class LambdaStepTest extends TestBase{

    private static final String repository = "qa-guru/qa_guru_14_10";
    private static final String issueText = "Issue for Autotest";

    @Test
    @Story("Verification of the specific issue via Lambda-expression in QA GURU Github page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Github page QA GURU", url = "https://github.com/qa-guru/qa_guru_14_10/issues")
    @DisplayName("Check via Lambda-expression that on Issues Github page there is an element " + issueText +" displayed")
    void verifyIssueViaLambdaTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open the main Github page", () -> {
            open("/");
        });
        step("Search the Repository " + repository, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").setValue(repository).pressEnter();
        });
        step("Click on the title of Repository " + repository, () -> {
            $("[data-testid='results-list'] a[href='/qa-guru/qa_guru_14_10']").click();
        });
        step("Open the Issues tab", () -> {
            $("#issues-tab").click();
        });
        step("Verify that there is an issue with title: " + issueText, () -> {
            $("div#js-navigation-container").shouldHave(text(issueText));
        });
    }
}