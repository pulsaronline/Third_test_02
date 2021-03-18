import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Third_test_02 {

    @BeforeAll
    public static void setup() {
        //use Chrome browser, fullscreen

        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    void selenideSearchTest() {
        //- Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //- Перенесите прямоугольник А на место В
        Selenide.actions("#column-a").clickAndHold().moveToElement($("#column-b")).perform();
        //Selenide.actions(clickAndHold($("#column-a")).moveByOffset(300,0).release().perform();
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        //- Проверьте, что прямоугольники действительно поменялись

        //P.S. В Selenide есть команда $(element).dragAndDrop($(to-element)),
        // проверьте работает ли тест, если использовать её вместо actions()

    }
}
