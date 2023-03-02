import extensions.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

public class QuestionTest {

    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.get();
    }

    @Test
    public void checkAnswerFirstQuestion() {

        String actualAnswer = new MainPage(driver)
                .clickAcceptCookie()
                .scrollQuestionBlock()
                .clickFirstQuestionButton()
                .getTextFirstAnswer();

        assertEquals("Текст не появился или появился не правильный!","Сутки — 400 рублей. Оплата курьеру — наличными или картой.",actualAnswer);

    }

    @Test
    public void checkAnswerLastQuestion() {

        String actualAnswer = new MainPage(driver)

                .clickLastQuestionButton()

                .getTextLastAnswer();

        assertEquals("Текст не появился или появился не правильный!","Да, обязательно. Всем самокатов! И Москве, и Московской области.",actualAnswer);

    }


    @After

    public void teardown() {

        driver.quit();

    }
}
