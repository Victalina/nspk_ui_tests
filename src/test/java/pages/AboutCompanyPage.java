package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AboutCompanyPage {

  @Step("Проверить заголовок на странице 'Компания АО «НСПК»'")
  public AboutCompanyPage checkTitleOnAboutCompanyPage(String title) {
    $(".pages-about-company").$("h1").shouldHave(text(title));

    return this;
  }
}
