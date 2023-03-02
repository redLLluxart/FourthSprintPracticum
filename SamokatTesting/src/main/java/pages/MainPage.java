package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    //Локатор кнопки с принятием Cookies
    private final By acceptCookie = By.id("rcc-confirm-button");

    //Локатор блока вопросов
    private final By questionBlock = By.className("Home_FAQ__3uVm4");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage clickAcceptCookie(){
        driver.findElement(acceptCookie).click();
        return this;
    }

    //Получение текста ответа
    public String getTextAnswer(String idQuestion) {

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id =\"accordion__panel-" + idQuestion +"\"]/p")));

        return driver.findElement(By.xpath("//*[@id =\"accordion__panel-" + idQuestion + "\"]/p")).getText();
    }

    //Клик по полю с вопросом
    public MainPage clickQuestionButton(String question){

        WebElement element = driver.findElement(questionBlock);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(By.xpath("//*[text() = '"+ question + "']")).click();

        return this;
    }


}
