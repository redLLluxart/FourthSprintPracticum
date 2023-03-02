import extensions.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionTest {

    private WebDriver driver;

    private final String idQuestion;
    private final String question;
    private final String expected;

    public QuestionTest(String idQuestion, String question, String expected) {
        this.idQuestion = idQuestion;
        this.question = question;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { "0","Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",},
                { "1","Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { "2","Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                { "3","Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                { "4","Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                { "5","Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                { "6","Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                { "7","Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.get();
    }

    @Test
    public void checkAnswerQuestion() {

        String actualAnswer = new MainPage(driver)
                .clickAcceptCookie()
                .clickQuestionButton(question)
                .getTextAnswer(idQuestion);

        assertEquals("Текст не появился или появился не правильный!",expected,actualAnswer);

    }
    
    @After

    public void teardown() {

        driver.quit();

    }
}
