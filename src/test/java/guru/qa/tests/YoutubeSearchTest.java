package guru.qa.tests;

import guru.qa.pages.YoutubePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class YoutubeSearchTest {

    YoutubePage youtubePage = new YoutubePage();


    @ValueSource(
            strings = {"cats", "dogs", "capybaras"}
    )
    @Tags({
            @Tag("smoke"),
            @Tag("web")
    })
    @DisplayName("There is Shorts block in youtube for any search query")
    @ParameterizedTest(name = "There is Shorts block in youtube for {0} query")
    void youtubeSearchTest(String searchQuery) {
        youtubePage
                .openPage()
                .findContent(searchQuery)
                .checkResult("Shorts");
    }
}
