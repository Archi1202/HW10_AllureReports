package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Open the Github main page.")
    public WebSteps openMainPage() {
        open("/");
        return this;
    }
    @Step("Insert into the Search field required data and click Enter")
    public WebSteps searchRepositories(String dataForSearch) {
        $(".search-input").click();
        $("#query-builder-test").setValue(dataForSearch).pressEnter();
        return this;
    }
    @Step("Search for relevant result and click on it")
    public WebSteps selectRepository() {
        $("[data-testid='results-list'] a[href='/qa-guru/qa_guru_14_10']").click();
        return this;
    }
    @Step("Click on the 'Issues' tab.")
    public WebSteps selectIssuesTab() {
        $("a#issues-tab").click();
        return this;
    }
    @Step("Check that relevant issue displays in the list")
    public WebSteps checkIssueName(String issueName) {
        $("div.js-navigation-container").shouldHave(text(issueName));
        return this;
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}