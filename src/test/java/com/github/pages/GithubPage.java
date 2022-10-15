package com.github.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GithubPage {

    private final SelenideElement inputSearch = $(".header-search-input");

    public GithubPage clickInputFieldSearch() {
        inputSearch.click();
        return this;
    }

    public void setInputFieldSearch(String repo) {
        inputSearch.setValue(repo).pressEnter();
    }

}
