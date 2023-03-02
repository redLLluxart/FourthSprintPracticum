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

    //Локатор кнопки с закрытием кук куками
    private final By acceptCookie = By.id("rcc-confirm-button");

    //Локатор блока вопросов

    private final By questionBlock = By.className("Home_FAQ__3uVm4");

    //Локатор поля с первым вопросом
    private final By firstQuestionButton = By.xpath("//*[@id =\"accordion__heading-0\"]");

    //Локатор ответа на первый вопрос
    private final By firstAnswerText = By.xpath("//*[@id =\"accordion__panel-0\"]/p");

    //Локатор поля с последним вопросом
    private final By lastQuestionButton = By.id("accordion__heading-7");

    //Локатор ответа на последний вопрос
    private final By lastAnswerText = By.xpath("//div[@id ='accordion__panel-7']/p");

    //Локатор кнопки все

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage clickAcceptCookie(){
        driver.findElement(acceptCookie).click();
        return this;
    }

    public MainPage scrollQuestionBlock(){

        WebElement element = driver.findElement(questionBlock);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        return this;
    }

    public MainPage clickFirstQuestionButton(){

        driver.findElement(firstQuestionButton).click();

        return this;
    }

    public String getTextFirstAnswer() {

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(firstAnswerText));

        return driver.findElement(firstAnswerText).getText();
    }

    public MainPage clickLastQuestionButton(){

        driver.findElement(lastQuestionButton).click();

        return this;
    }

    public String getTextLastAnswer() {

        return driver.findElement(lastAnswerText).getText();

    }

}
