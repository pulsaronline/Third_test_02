import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Third_test_02 {

    @BeforeAll
    public static void setup() {
        //use Chrome browser, fullscreen

        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    void DragAndDropSelenideTest() {
        //- Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //- Перенесите прямоугольник А на место В
        //- Метод "По старинке". Забагован, координаты #column-b перехватываются указателем мыши!
        //Selenide.actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        sleep(1800);
        //- Рабочий метод
        $("#column-a").dragAndDropTo($("#column-b"));
        sleep(1800);
        //- Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

        //- Закрываем https://the-internet.herokuapp.com/drag_and_drop
        Selenide.closeWebDriver();
    }
}
