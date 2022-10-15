package com.github.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RepositoriesPage {

    public RepositoriesPage clickTabIssue() {
        $("#issues-tab").click();
        return this;
    }

    public void checkIssueTitle(String name) {
        $("#issue_1_link").shouldHave(text(name));
    }

}
