package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class VacanciesPage {

  @Step("Проверить заголовок на странице 'Карьера и вакансии'")
  public VacanciesPage checkTitleVacancies(String title) {
    $(".ctr-vacancies-referral-head__title").$("h1").shouldHave(text(title));

    return this;
  }
}
