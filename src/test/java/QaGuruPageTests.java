import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

public class QaGuruPageTests extends TestBase {
    QaGuruPage qaGuruPage = new QaGuruPage();

    @Test
    @AllureId("10817")
    @DisplayName("Тест на открытие главной страницы сайта qa.guru")
    @Tag("mainPage")
    void mainPageHasBeenOpened() {
        step("Проверяем открытие страницы");
    }

    @Test
    @AllureId("10806")
    @DisplayName("Тест на открытие программы обучения")
    @Tag("testProgram")
    void scheduleHasBeenOpened() {
        step("Открываем программу обучения");
        step("Открывается модальное окно");
        step("Проверяем название программы");
        step("Закрываем программу обучения");
    }

    @Test
    @AllureId("10818")
    @DisplayName("Тест на проверку перехода в ВК")
    @Tag("vk")
    void vkTest() {
        step("Кликаем по иконке социальной сети ВК");
        step("Переходим на страницу в ВК");
        step("Проверяем, что находимся на нужной странице в ВК");
        step("Возвращаемся на исходную страницу");
    }

    @Test
    @AllureId("10819")
    @DisplayName("Тест на авторизацию с невалидными кредами")
    @Tag("wrongCreds")
    void authWithWrongCredentials() {
        step("Открываем страницу авторизации");
        step("Заполняем форму");
        step("Осуществляем вход в систему");
        step("Проверяем, что авторизация прошла неуспешно");
    }

    @Test
    @AllureId("10820")
    @DisplayName("Тест на авторизацию с валидными кредами")
    @Tag("correctCreds")
        //специально сделано, чтобы тест упал (не добавлены верные креды)
    void authWithCorrectCredentials() {
        step("Открываем страницу авторизации");
        step("Заполняем форму");
        step("Осуществляем вход в систему");
        step("Проверяем, что авторизация прошла успешно");
        step("Выходим из системы");
    }
}

