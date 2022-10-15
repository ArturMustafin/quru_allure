package com.github.test;

import com.github.WebSteps;
import com.github.pages.RepositoriesPage;
import com.github.pages.GithubPage;
import com.github.pages.SearchPage;
import com.github.BaseTest;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Severity;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Owner;
import io.qameta.allure.Link;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static io.qameta.allure.Allure.step;

public class GithubTest extends BaseTest {

    WebSteps webSteps = new WebSteps();
    private static final String ISSUE_NAME = "Test_allure";
    private static final String REPO_LINK = "ArturMustafin/quru_allure";

    @Test
    @Feature("Check Repository")
    @Story("Check Issues")
    @Owner("Artur")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Testing", url = "https://github.com/")
    @DisplayName("Search issue With Listener")
    void searchIssueWithListenerTest() {
        open("/", GithubPage.class)
                .clickInputFieldSearch()
                .setInputFieldSearch(REPO_LINK);

        page(SearchPage.class).repoLinkClick(REPO_LINK);
        page(RepositoriesPage.class)
                .clickTabIssue()
                .checkIssueTitle(ISSUE_NAME);
    }

    @Test
    void searchIssueWithLambdaTest() {
        step("Открываем главную страницу", () -> {
            open("/", GithubPage.class);
        });
        step("Ищем в поиске репозиторий " + REPO_LINK, () -> {
            page(GithubPage.class).clickInputFieldSearch().setInputFieldSearch(REPO_LINK);
        });

        step("В результатах поиска кликаем по ссылке репозитория " + REPO_LINK, () -> {
            page(SearchPage.class).repoLinkClick(REPO_LINK);
        });

        step("Нажимаем на таб Issues", () -> {
            page(RepositoriesPage.class).clickTabIssue();
        });

        step("Проверяем название issue " + ISSUE_NAME, () -> {
            page(RepositoriesPage.class).checkIssueTitle(ISSUE_NAME);
        });
    }

    @Test
    void searchIssueWithAnnotationTest() {
        webSteps.openMainPage();
        webSteps.searchRepo(REPO_LINK);
        webSteps.clickOnLinkRepo(REPO_LINK);
        webSteps.clickIssueTab();
        webSteps.checkIssueTitle(ISSUE_NAME);
    }
}

