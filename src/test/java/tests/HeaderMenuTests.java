package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.AboutCompanyPage;
import pages.MainPage;
import pages.ProcessingOfPersonalDataPage;
import pages.VacanciesPage;

@Tags({
        @Tag("all_nspk_tests"),
        @Tag("header_menu_tests")
})
@DisplayName("Проверка пунктов меню на главной странице сайта nspk.ru")
@Epic("Сайт nspk.ru")
@Story("Меню на главной странице сайта nspk.ru")
@Feature("Меню на главной странице сайта nspk.ru")
public class HeaderMenuTests extends TestBase {

  MainPage mainPage = new MainPage();
  AboutCompanyPage aboutCompanyPage = new AboutCompanyPage();
  ProcessingOfPersonalDataPage processingOfPersonalDataPage = new ProcessingOfPersonalDataPage();
  VacanciesPage vacanciesPage = new VacanciesPage();

  @Test
  @DisplayName("Проверка пунктов основного меню на главной странице")
  @Owner("Victalina")
  @Severity(SeverityLevel.CRITICAL)
  void checkHeaderMenuOnMainPageTest() {
    String[] headerMenuItems = new String[]{"О компании", "Платежная система «Мир»", "Банкам", "Центр знаний",
            "Вакансии", "Пресс-центр", "Контакты"};
    mainPage.openMainPage()
            .checkHeaderMenuItems(headerMenuItems);
  }

  @Test
  @DisplayName("Проверка подпунктов меню пункта 'О компании' на главной странице")
  @Owner("Victalina")
  @Severity(SeverityLevel.CRITICAL)
  void checkSubmenuItemsOfAboutItemMenuOnMainPageTest() {
    String headerMenuItem = "О компании";
    String[] subMenuItems = new String[]{"Компания АО «НСПК»", "Обработка персональных данных",
            "Оценка условий труда на рабочих местах", "Официальные сайты", "Акционерам и инвесторам",
            "Устойчивое развитие", "Противодействие коррупции", "Соответствие PCI DSS",
            "Деятельность в области информационных технологий", "Реквизиты"};
    mainPage.openMainPage()
            .checkSubMenuItems(headerMenuItem, subMenuItems);
  }

  @Test
  @DisplayName("Переход на страницу 'О компании АО «НСПК»' c главной страницы через меню")
  @Owner("Victalina")
  @Severity(SeverityLevel.NORMAL)
  void openPageAboutCompanyFromMenuOnMainPageTest() {
    mainPage.openMainPage()
            .clickOnSubMenuItem("О компании", "Компания АО «НСПК»");
    aboutCompanyPage.checkTitleOnAboutCompanyPage("О компании АО «НСПК»");
  }

  @Test
  @DisplayName("Переход на страницу 'Обработка персональных данных' c главной страницы через меню")
  @Owner("Victalina")
  @Severity(SeverityLevel.NORMAL)
  void openPageProcessingOfPersonalDataFromMenuOnMainPageTest() {
    mainPage.openMainPage()
            .clickOnSubMenuItem("О компании", "Обработка персональных данных");
    processingOfPersonalDataPage.checkTitleProcessingOfPersonalDataPage("Обработка персональных данных");
  }

  @Test
  @DisplayName("Переход на страницу 'Карьера и вакансии' c главной страницы через меню")
  @Owner("Victalina")
  @Severity(SeverityLevel.NORMAL)
  void openPageVacanciesFromMenuOnMainPageTest() {
    mainPage.openMainPage()
            .clickOnHeaderMenuItem("Вакансии");
    vacanciesPage.checkTitleVacancies("Карьера и вакансии");
  }
}

