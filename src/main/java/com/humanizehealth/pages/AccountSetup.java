package com.humanizehealth.pages;

import com.humanizehealth.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

import java.time.Duration;

public class AccountSetup extends Base {

    @iOSXCUITFindBy(accessibility = "displayNameEditText")
    @AndroidFindBy(accessibility = "displayNameEditText")
    public MobileElement displayNameEditText;

    @iOSXCUITFindBy(accessibility = "firstNameEditText")
    @AndroidFindBy(accessibility = "firstNameEditText")
    public MobileElement firstNameEditText;

    @iOSXCUITFindBy(accessibility = "lastNameEditText")
    @AndroidFindBy(accessibility = "lastNameEditText")
    public MobileElement lastNameEditText;

    @iOSXCUITFindBy(accessibility = "dateOfBirthSelector")
    @AndroidFindBy(accessibility = "dateOfBirthSelector")
    public MobileElement dateOfBirthSelector;

    @iOSXCUITFindBy(accessibility = "emailEditText")
    @AndroidFindBy(accessibility = "emailEditText")
    public MobileElement emailEditText;

    @iOSXCUITFindBy(accessibility = "phoneEditText")
    @AndroidFindBy(accessibility = "phoneEditText")
    public MobileElement phoneEditText;

    @iOSXCUITFindBy(accessibility = "streetEditText")
    @AndroidFindBy(accessibility = "streetEditText")
    public MobileElement streetEditText;

    @iOSXCUITFindBy(accessibility = "cityEditText")
    @AndroidFindBy(accessibility = "cityEditText")
    public MobileElement cityEditText;

    @iOSXCUITFindBy(accessibility = "zipCodeEditText")
    @AndroidFindBy(accessibility = "zipCodeEditText")
    public MobileElement zipCodeEditText;

    @iOSXCUITFindBy(accessibility = "createUserButton")
    @AndroidFindBy(accessibility = "createUserButton")
    public MobileElement createUserButton;

    @iOSXCUITFindBy(accessibility = "Complete your account")
    @AndroidFindBy(xpath = "//*[@text='Complete your account']")
    public MobileElement completeYourAccount;

    public boolean isTextCompleteYourAccountDisplayed() {
        return completeYourAccount.isDisplayed();
    }

    public void inputDisplayNameEditText (String displayName) {
        displayNameEditText.click();
        displayNameEditText.clear();
        displayNameEditText.sendKeys(displayName);
        driver.hideKeyboard();
    }

    public void inputFirstNameEditText (String firstName) {
        firstNameEditText.click();
        firstNameEditText.clear();
        firstNameEditText.sendKeys(firstName);
        driver.hideKeyboard();
    }

    public void inputLastNameEditText (String lastName) {
        lastNameEditText.click();
        lastNameEditText.clear();
        lastNameEditText.sendKeys(lastName);
        driver.hideKeyboard();
    }

    public void setDateOfBirthSelector () throws InterruptedException {
        System.out.println("setDateOfBirthSelector");
        System.out.println("dateOfBirthSelector: "+ dateOfBirthSelector.isDisplayed());
        dateOfBirthSelector.click();
        dateOfBirthSelector.click();
        System.out.println("setDateOfBirthSelector.click()");
        Thread.sleep(5000);
//        DateSelector dateSelector = new DateSelector();
//        dateSelector.performSelectDate();
    }

    public void inputEmailEditText (String email) {
        emailEditText.click();
        emailEditText.clear();
        emailEditText.sendKeys(email);
        driver.hideKeyboard();
    }

    public SetUpOption performCreateAccount(
            String displayName,
            String firstName,
            String lastName,
            String dateOfBirth,
            String email
//            String phone,
//            String street,
//            String city,
//            String state,
//            String zipCode
            ) throws InterruptedException {

        inputDisplayNameEditText(displayName);

        inputFirstNameEditText(firstName);

        inputLastNameEditText(lastName);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(0,500))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, 200)).release().perform();

        Thread.sleep(5000);

        setDateOfBirthSelector();

//        inputEmailEditText(email);

        return new SetUpOption();
    }

}
