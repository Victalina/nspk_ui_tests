package pages.components;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;


public class HeaderMenuComponents {
  public void checkItemsOfHeaderMenu(String[] headerMenuItems) {
    $$(".layout-menu__item").shouldHave(texts(headerMenuItems));
  }

  public void clickOnHeaderMenuItem(String headerMenuItem) {
    $$(".layout-menu__item").findBy(text(headerMenuItem)).click();
  }
}
