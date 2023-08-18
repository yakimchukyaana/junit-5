package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private final SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            userNameOutput = $("#output #name"),
            userEmailOutput = $("#output #email"),
            currentAddressOutput = $("#output #currentAddress"),
            permanentAddressOutput = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("https://demoqa.com/text-box");

        return this;
    }

    public TextBoxPage seUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public void submit() {
        submitButton.click();
    }

    public void checkName(String value) {
        userNameOutput.shouldHave(text(value));
    }

    public void checkEmail(String value) {
        userEmailOutput.shouldHave(text(value));
    }

    public void checkCurrentAddress(String value) {
        currentAddressOutput.shouldHave(text(value));
    }

    public void checkPermanentAddress(String value) {
        permanentAddressOutput.shouldHave(text(value));
    }

    public void checkResult(String name, String email, String currentAddress, String permanentAddress) {
        checkName(name);
        checkEmail(email);
        checkCurrentAddress(currentAddress);
        checkPermanentAddress(permanentAddress);
    }
}
