package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {

    private final WebDriver driver;
    //Локатор поля с первым вопросом
    private final By FirstQuestionButton = By.id("accordion__heading-0");

    //Локатор ответа на первый вопрос
    private final By FirstAnswerText = By.xpath("//div[@id ='accordion__panel-0']/p");

    //Локатор поля с последним вопросом
    private final By LastQuestionButton = By.id("accordion__heading-7");

    //Локатор ответа на последний вопрос
    private final By LastAnswerText = By.xpath("//div[@id ='accordion__panel-7']/p");

    //Локатор кнопки все

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public MainPage clickFirstQuestionButton(){

        WebElement element = driver.findElement(FirstQuestionButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(FirstQuestionButton).click();

        return this;
    }

    public String getTextFirstAnswer() {

        return driver.findElement(FirstAnswerText).getText();

    }

    public MainPage clickLastQuestionButton(){

        WebElement element = driver.findElement(LastQuestionButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(LastQuestionButton).click();

        return this;
    }

    public String getTextLastAnswer() {

        return driver.findElement(LastAnswerText).getText();

    }

}
