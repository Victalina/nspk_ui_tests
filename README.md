
# Проект по автоматизации тестирования для компании [Национальная система платежных карт](https://www.nspk.ru/)

<p align="center">  
<a href="https://www.nspk.ru/"><img title="Национальная система платежных карт" src="images/logo/nspk-logo.svg" width="600" alt="NSPK logo"/>  
</a></p>

> НСПК обеспечивает обработку операций по картам «Мир» и картам международных платежных систем, развитие продуктов и сервисов ПС «Мир», совместно с Банком России развивает Систему быстрых платежей, а также обеспечивает удобные и безопасные платежи по универсальному QR-коду и с помощью биоэквайринга.

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Тестовое покрытие</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testOps">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
____
<a id="tools"></a>
## **Технологии и инструменты:**

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/intellij-idea.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/logo/selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/allure.svg" width="50" height="50"  alt="Allure"/></a>  
<a href="https://qameta.io/"><img src="images/logo/allure-testOps.svg" width="50" height="50"  alt="TestOps"/></a> 
<a href="https://www.jenkins.io/"><img src="images/logo/jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> 
<a href="https://www.atlassian.com/software/jira"><img src="images/logo/jira.svg" width="50" height="50"  alt="Jira"/></a>  
<a href="https://telegram.org/"><img src="images/logo/telegram.svg" width="50" height="50"  alt="Telegram"/></a>
</p>

Автотесты разработаны на языке программирования `Java` с использованием фреймворка `Selenide`. При проектировании тестов применён паттерн `PageObject`. 

В качестве фреймворка для запуска тестов используется `Junit5`, в качестве сборщика проекта - `Gradle`.

Произведена настройка CI системы `Jenkins`, при запуске автотестов из которой выполнение тестов осуществляется в удалённом браузере в `Selenoid`. По результатам каждого запуска автотестов создаётся `Allure` отчёт для визуализации результатов прогона.

Реализована интеграция с `Allure TestOps` – системой тест-менеджмента для управления процессом тестирования, которая, в свою очередь, интегрирована с таск-трекером `Jira`.

После выполнения автотестов `Telegram` бот присылает сообщение с информацией о результатах запуска.

____
<a id="cases"></a>
## **Тестовое покрытие:**
____
#### Проверка главной страницы сайта

- [x] Проверка открытия главной страницы и заголовка
- [x] Проверка блоков на главной странице (параметризованные тесты)

#### Проверка пунктов меню на главной странице

- [x] Проверка пунктов основного меню на главной странице
- [x] Проверка подпунктов меню пункта 'О компании' на главной странице
- [x] Переход на страницу 'О компании АО «НСПК»' с главной страницы через меню
- [x] Переход на страницу 'Обработка персональных данных' с главной страницы через меню
- [x] Переход на страницу 'Вакансии' с главной страницы через меню
____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="images/logo/jenkins.svg" width="25"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/C34-Vicktalina-unit23-1/)
____
<p align="center">  
<img src="images/screenshot/jenkins_build.png" alt="Jenkins" width="950"/>
</p>

### **Параметры сборки в Jenkins:**

- `TASK` (набор автотестов с соответствующими тегами: `all_nspk_tests` - все тесты, `main_page_tests` - тесты на главную страницу, `header_menu_tests` - тесты на основное меню)
- `BROWSER` (браузер, по умолчанию chrome)
- `VERSION` (версия браузера, по умолчанию 128.0)
- `WINDOW_SIZE` (размер окна браузера, по умолчанию 1920x1080)
- `BASE_URL` (адрес тестируемого веб-сайта)
- `REMOTE_BROWSER` (адрес удаленного сервера Selenoid)

<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean all_nspk_tests -Denv=local
```

***Удалённый запуск через Jenkins:***
```bash  
clean ${TASK} -Denv=remote
"-Dbrowser=${BROWSER}"
"-Dversion=${VERSION}"
"-DwindowSize=${WINDOW_SIZE}"
"-DbaseUrl=${BASE_URL}"
"-DremoteBrowser=https://user1:1234@${REMOTE_BROWSER}/wd/hub"
```
___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/allure.svg" width="25"/> Allure [отчет](https://jenkins.autotests.cloud/job/C34-Vicktalina-unit23-1/7/allure/)
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screenshot/allure_report.png" width="850"/>  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/screenshot/allure_report_test.png" width="850"/>  
</p>

### *Графики*

<p align="center">  
<img title="Allure Graphics" src="images/screenshot/allure_report_graphs.png" width="850"/>
</p>

____

<a id="allure-testOps"></a>
## <img alt="TestOps" height="25" src="images/logo/allure-testOps.svg" width="25"/> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4817/dashboards)

### Основная страница Allure TestOps

<p align="center">  
<img title="Allure TestOps main" src="images/screenshot/allure_testops.png" width="850"/>
</p>

### Авто и Ручные тест-кейсы

<p align="center">  
<img title="Allure TestOps test" src="images/screenshot/allure_testops_test.png" width="850"/>
</p>

___

<a id="jira"></a>
## <img alt="Jira" height="25" src="images/logo/jira.svg" width="25"/> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1470)

<p align="center">  
<img title="Jira" src="images/screenshot/jira.png" width="850"/>
</p>

___

<a id="telegram"></a>
## <img alt="Allure" height="25" src="images/logo/telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screenshot/telegram_alert.png" width="550"/>  
</p>

____
<a id="video"></a>
## <img alt="Selenoid" height="25" src="images/logo/selenoid.svg" width="25"/> Примеры видео выполнения тестов на Selenoid
____
<p align="center">
<img title="Selenoid Video" src="images/video/video.gif" width="550"  alt="video"/>   
<img title="Selenoid Video" src="images/video/video1.gif" width="550"  alt="video"/> 
</p>

