package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Issue elements")
@Owner("Anuar Zhangeldi")
@DisplayName("Check the Issue element via Web Steps Approach")

public class StepTest extends TestBase{
    final String repository = "qa-guru/qa_guru_14_10";
    final String issue = "Issue for Autotest";

    @Test
    @Story("Verification of the specific issue via Step annotation in QA GURU Github page")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Github page QA GURU", url = "https://github.com/qa-guru/qa_guru_14_10/issues")
    @DisplayName("Check that on Issues Github page there is an element " + issue + " displayed")
    public void annotationStepTest(){
    WebSteps webSteps = new WebSteps();
    webSteps.openMainPage()
        .searchRepositories(repository)
        .selectRepository()
        .selectIssuesTab()
        .checkIssueName(issue)
        .takeScreenshot();
    }

}
