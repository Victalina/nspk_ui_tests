package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

  @BeforeAll
  static void setupConfig() {
    Configuration.baseUrl = System.getProperty("baseUrl", "https://www.nspk.ru/");
    Configuration.browser = System.getProperty("browser", "chrome");
    Configuration.browserSize = System.getProperty("windowSize", "1920x1080");
    Configuration.browserVersion = System.getProperty("version", "128");
    if (System.getProperty("env").equals("remote")) {
      Configuration.remote = System.getProperty("remoteBrowser", "http://localhost:4444");
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("selenoid:options", Map.<String, Object>of(
              "enableVNC", true,
              "enableVideo", true
      ));
      Configuration.browserCapabilities = capabilities;
    }
  }

  @BeforeEach
  void addListener() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }

  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    if (System.getProperty("env").equals("remote")) {
      Attach.addVideo();
    }
    closeWebDriver();
  }
}

