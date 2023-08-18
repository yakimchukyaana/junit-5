package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IMDBPage {

    private final SelenideElement
    searchField = $(".imdb-header-search__input"),
    searchResult = $("[data-testid=find-results-section-title]");

    public IMDBPage openPage(){
        open("https://www.imdb.com/");

        return this;
    }

    public IMDBPage findMovie(String value){
        searchField.setValue(value).pressEnter();

        return this;
    }

    public void checkResult(String value){
        searchResult.shouldHave(Condition.text(value));
    }
}
