package pages.components;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class SubMenuComponents {

  public void checkSubMenuItems(String headerMenuItem, String[] subMenuItems) {
    $$(".layout-menu__item").findBy(text(headerMenuItem)).hover();
    $$(".layout-submenu__item").shouldHave(texts(subMenuItems));
  }

  public void clickOnSubMenuItem(String headerMenuItem, String subMenuItem) {
    $$(".layout-menu__item").findBy(text(headerMenuItem)).hover();
    $$(".layout-submenu__item").findBy(text(subMenuItem)).click();
  }
}
