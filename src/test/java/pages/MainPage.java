package pages;

import io.qameta.allure.Step;
import pages.components.HeaderMenuComponents;
import pages.components.SubMenuComponents;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
  HeaderMenuComponents headerMenuComponents = new HeaderMenuComponents();
  SubMenuComponents subMenuComponents = new SubMenuComponents();

  @Step("Открыть главную страницу")
  public MainPage openMainPage() {
    open(baseUrl);

    return this;
  }

  @Step("Проверить заголовок главной страницы")
  public MainPage checkTitleOnMainPage(String title) {
    $(".ctr-index-head__title").$("h1").shouldHave(text(title));

    return this;
  }

  @Step("Проверить пункты меню на главной странице")
  public MainPage checkHeaderMenuItems(String[] headerMenuItems) {
    headerMenuComponents.checkItemsOfHeaderMenu(headerMenuItems);

    return this;
  }

  @Step("Проверить пункты подменю для пункта меню {headerMenuItem}")
  public MainPage checkSubMenuItems(String headerMenuItem, String[] subMenuItems) {

    subMenuComponents.checkSubMenuItems(headerMenuItem, subMenuItems);

    return this;
  }

  @Step("Перейти на страницу {headerMenuItem}")
  public MainPage clickOnHeaderMenuItem(String headerMenuItem) {
    headerMenuComponents.clickOnHeaderMenuItem(headerMenuItem);

    return this;
  }

  @Step("Перейти на страницу {headerMenuItem} -> {subMenuItem}")
  public MainPage clickOnSubMenuItem(String headerMenuItem, String subMenuItem) {
    subMenuComponents.clickOnSubMenuItem(headerMenuItem, subMenuItem);

    return this;
  }

  @Step("Проверка блока {blockTitle}")
  public MainPage checkMainPageBlock(String id, String blockTitle, String blockText) {

    $("#" + id).scrollTo();
    $("#" + id).$("h2").shouldHave(text(blockTitle));
    $("#" + id).$("span").shouldHave(text(blockText));

    return this;
  }

  @Step("Проверка блока {blockTitle}")
  public MainPage checkMainPageBlockWithLink(String id, String blockTitle, String linkUrl, String linkText) {

    $("#" + id).scrollTo();
    $("#" + id).$(".ctr-index-sbp-mir__title h2").shouldHave(text(blockTitle));
    $("#" + id).$("a")
            .shouldHave(attribute("href", linkUrl));
    $("#" + id).$("a").$("span").shouldHave(text(linkText));

    return this;
  }
}
