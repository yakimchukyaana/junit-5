package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YoutubePage {

    private final SelenideElement
        searchField = $("[name=search_query]"),
        searchResult = $("#contents");

    public YoutubePage openPage(){
        open("https://www.youtube.com/");

        return this;
    }

    public YoutubePage findContent(String value){
        searchField.setValue(value).pressEnter();

        return this;
    }

    public void checkResult(String value){
        searchResult.shouldHave(Condition.text(value));
    }
}
