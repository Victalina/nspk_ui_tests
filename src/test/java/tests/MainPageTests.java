package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;

import java.util.stream.Stream;

@Tags({
        @Tag("all_nspk_tests"),
        @Tag("main_page_tests")
})
@DisplayName("Проверка главной страницы сайта nspk.ru")
@Owner("Victalina")
@Epic("Сайт nspk.ru")
@Story("Главная страница сайта nspk.ru")
@Feature("Главная страница сайта nspk.ru")
public class MainPageTests extends TestBase {

  MainPage mainPage = new MainPage();

  @Test
  @DisplayName("Проверка открытия главной страницы и заголовка")
  @Severity(SeverityLevel.BLOCKER)
  void openMainPageAndCheckTitleTest() {
    mainPage.openMainPage()
            .checkTitleOnMainPage("Национальная система платежных карт");
  }

  static Stream<Arguments> dataProvider() {
    return Stream.of(
            Arguments.of(
                    "index-services-456",
                    "Доступные и удобные платёжные сервисы",
                    "Для всех жителей России и для государства создаем и развиваем доступные, удобные и выгодные платежные сервисы, поддерживая суверенитет страны и формируя стандарты индустрии"),
            Arguments.of(
                    "index-security-801",
                    "Безопасные и бесперебойные операции",
                    "В задачи НСПК входят обеспечение бесперебойности операций по картам международных платежных систем на территории России, развитие российской системы платежных карт.")
    );
  }

  @MethodSource("dataProvider")
  @ParameterizedTest(name = "Проверка блока {1} на главной странице")
  @Severity(SeverityLevel.NORMAL)
  void checkBlocksOnMainPageTest(String id, String blockTitle, String blockText) {
    mainPage.openMainPage()
            .checkMainPageBlock(id, blockTitle, blockText);
  }

  @CsvFileSource(resources = "/test_data/MainPageBlocks.csv")
  @ParameterizedTest(name = "Проверка блока {1} на главной странице")
  @Severity(SeverityLevel.NORMAL)
  void checkBlocksWithLinkOnMainPageTest(String id, String blockTitle, String linkUrl, String linkText) {
    mainPage.openMainPage()
            .checkMainPageBlockWithLink(id, blockTitle, linkUrl, linkText);
  }
}

