import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class QaGuruPage {

    SelenideElement schoolDescription = $x("//div[@class='branding']/h5");
    SelenideElement openSchedule = $("#myBtn");
    SelenideElement scheduleName = $x("//div[@class='modal-content']/h3");
    SelenideElement closeSchedule = $(".close");
    SelenideElement loginButton = $x("//a[@class='btn min']");
    SelenideElement emailField = $(byName("email"));
    SelenideElement passwordField = $(byName("password"));
    SelenideElement doLogin = $x("(//button[@class='xdget-block xdget-button btn btn-success'])[1]");
    SelenideElement errorMsg = $x("//button[@class='xdget-block xdget-button btn btn-success btn-error']");
    SelenideElement vkIcon = $x("//a[@href='https://vk.com/qa.guru']");
    SelenideElement personalPageTitle = $x("(//span[@class='stream-title'])[1]");
    SelenideElement personalPageIcon = $x("//ul[@class='gc-account-user-menu']/*[1]");
    SelenideElement logoutButton = $(byText("Выйти"));
}
