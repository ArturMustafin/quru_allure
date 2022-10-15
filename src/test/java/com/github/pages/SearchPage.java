package com.github.pages;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class SearchPage {

    public void repoLinkClick(String repo) {
        $(linkText(repo)).click();
    }

}
