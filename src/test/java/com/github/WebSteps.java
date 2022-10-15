package com.github;

import com.codeborne.selenide.WebDriverRunner;
import com.github.pages.GithubPage;
import com.github.pages.RepositoriesPage;
import com.github.pages.SearchPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("/",GithubPage .class);
    }

    @Step("Ищем в поиске репозиторий")
    public void searchRepo(String repo) {
        page(GithubPage.class).clickInputFieldSearch().setInputFieldSearch(repo);
    }

    @Step("В результатах поиска кликаем по ссылке репозитория")
    public void clickOnLinkRepo(String repo) {
        page(SearchPage .class).repoLinkClick(repo);
    }

    @Step("Нажимаем на таб Issues")
    public void clickIssueTab() {
        page(RepositoriesPage .class).clickTabIssue();
    }

    @Step("Проверяем название issue")
    public void checkIssueTitle(String issue) {
        page(RepositoriesPage .class).checkIssueTitle(issue);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
