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
        step("Проверяем открытие страницы", () -> {
            qaGuruPage.schoolDescription.shouldHave(Condition.text("Школа инженеров по автоматизации тестирования"));
        });
    }

    @Test
    @AllureId("10806")
    @DisplayName("Тест на открытие программы обучения")
    @Tag("testProgram")
    void scheduleHasBeenOpened() {
        step("Открываем программу обучения", () -> {
            qaGuruPage.openSchedule.click();
        });
        step("Открывается модальное окно", () -> {
            switchTo().window(0);
        });
        step("Проверяем название программы", () -> {
            qaGuruPage.scheduleName.shouldHave(Condition.text("Программа"));
        });
        step("Закрываем программу обучения", () -> {
            qaGuruPage.closeSchedule.click();
        });
    }

    @Test
    @AllureId("10818")
    @DisplayName("Тест на проверку перехода в ВК")
    @Tag("vk")
    void vkTest() {
        step("Кликаем по иконке социальной сети ВК", () -> {
            qaGuruPage.vkIcon.scrollIntoView(true).click();
        });
        step("Переходим на страницу в ВК", () -> {
            switchTo().window(1);
        });
        step("Проверяем, что находимся на нужной странице в ВК", () -> {
            webdriver().shouldHave(url("https://vk.com/qa.guru"));
        });
        step("Возвращаемся на исходную страницу", () -> {
            switchTo().window(0);
        });

    }

    @Test
    @AllureId("10819")
    @DisplayName("Тест на авторизацию с невалидными кредами")
    @Tag("wrongCreds")
    void authWithWrongCredentials() {
        step("Открываем страницу авторизации", () -> {
            qaGuruPage.loginButton.click();
        });
        step("Заполняем форму", () -> {
            qaGuruPage.emailField.setValue("test");
            qaGuruPage.passwordField.setValue("test");
        });
        step("Осуществляем вход в систему", () -> {
            qaGuruPage.doLogin.click();
        });
        step("Проверяем, что авторизация прошла неуспешно", () -> {
            qaGuruPage.errorMsg.shouldHave(Condition.text("Неверный формат e-mail"));
            switchTo().window(0);
        });

    }

    @Test
    @AllureId("10820")
    @DisplayName("Тест на авторизацию с валидными кредами")
    @Tag("correctCreds")
        //специально сделано, чтобы тест упал (не добавлены верные креды)
    void authWithCorrectCredentials() {
        step("Открываем страницу авторизации", () -> {
            qaGuruPage.loginButton.click();
        });
        step("Заполняем форму", () -> {
            qaGuruPage.emailField.setValue(config.email());
            qaGuruPage.passwordField.setValue(config.QaGuruPassword());
        });
        step("Осуществляем вход в систему", () -> {
            qaGuruPage.doLogin.click();
        });
        step("Проверяем, что авторизация прошла успешно", () -> {
            qaGuruPage.personalPageTitle.shouldHave(Condition.text("QA.GURU | Автоматизация тестирования 12 поток"));
        });
        step("Выходим из системы", () -> {
            qaGuruPage.personalPageIcon.doubleClick();
            qaGuruPage.logoutButton.click();
        });
    }
}

