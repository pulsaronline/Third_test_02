import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Third_test_02 {

    @BeforeAll
    public static void setup() {
        //use fullscreen
        Configuration.startMaximized = true;
    }

    @Test
    void dragAndDropSelenideTest() {
        //- Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //- Перенесите прямоугольник А на место В
        //- Метод "По старинке". Забагован, координаты #column-b перехватываются указателем мыши!
        //  Если указатель мыши подвести во время теста к прямоугольнику 'B' то тест сработает.
        //Selenide.actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        //- Рабочий метод
        $("#column-a").dragAndDropTo($("#column-b"));
        //- Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
