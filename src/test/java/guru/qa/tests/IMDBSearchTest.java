package guru.qa.tests;

import guru.qa.pages.IMDBPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class IMDBSearchTest extends TestBase {

    IMDBPage imdbPage = new IMDBPage();

    @CsvFileSource(resources = "/IMDBTestData.csv",
            delimiter = '|')
    @Tags({
            @Tag("smoke"),
            @Tag("web")
    })
    @DisplayName("IMDB search result shows the main actor")
    @ParameterizedTest(name = "IMDB search result for {0} shows the main actor")
    void imdbSearchTest(String movieTitle, String mainActor) {
        imdbPage
                .openPage()
                .findMovie(movieTitle)
                .checkResult(mainActor);
    }
}
