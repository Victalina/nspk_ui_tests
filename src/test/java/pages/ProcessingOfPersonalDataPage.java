package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProcessingOfPersonalDataPage {

  @Step("Проверить заголовок на странице 'Обработка персональных данных'")
  public ProcessingOfPersonalDataPage checkTitleProcessingOfPersonalDataPage(String title) {
    $(".pages-about-processing-of-personal-data").$("h1").shouldHave(text(title));

    return this;
  }
}
