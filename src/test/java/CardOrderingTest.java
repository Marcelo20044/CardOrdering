import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderingTest {

    @Test
    public void shouldAcceptOrder(){
        Configuration.holdBrowserOpen =true;
        open("http://localhost:9999/");

        $(byName("name")).val("Егоров Егор");
        $(byName("phone")).val("+79544125637");
        $("[class=\"checkbox__box\"]").click();
        $("button").click();
        $("[data-test-id=\"order-success\"]").shouldHave(Condition.text(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }


}
