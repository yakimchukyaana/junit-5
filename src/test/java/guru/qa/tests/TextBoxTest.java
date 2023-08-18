package guru.qa.tests;

import guru.qa.pages.TextBoxPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @CsvSource(value = {
            "Mary Watson     | marywatson@gmail.com     | 40 Lipton Court   | 43 Mill Lane",
            "Sherlock Holmes | sherlockholmes@gmail.com | 221B Baker Street | 9723 Manchester Road",
            "John Watson     | johnwatson@gmail.com     | 31 Stanley Road   | 76 Church Road"
    },
            delimiter = '|')
    @Tags({
            @Tag("smoke"),
            @Tag("web")
    })
    @DisplayName("Text box page shows user info")
    @ParameterizedTest(name = "Text box page shows user info: name {0}, email {1}, current address {2}, permanent address {3}")
    void fillFormTest(String fullName, String email, String currentAddress, String permanentAddress) {
        textBoxPage
                .openPage()
                .seUserName(fullName)
                .setUserEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit();
        textBoxPage
                .checkResult(
                        fullName,
                        email,
                        currentAddress,
                        permanentAddress);
    }
}
