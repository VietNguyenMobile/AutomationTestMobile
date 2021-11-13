package com.humanizehealth.pages;

import com.humanizehealth.base.Base;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Date of Birth*\"])[3]")
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
    public MobileElement completeYourAccount = driver.findElement(By.xpath(""));

    public boolean isTextCompleteYourAccountDisplayed() {
        return completeYourAccount.isDisplayed();
    }

    public void inputDisplayNameEditText (String displayName) {
        displayNameEditText.click();
        displayNameEditText.clear();
        displayNameEditText.sendKeys(displayName);
        displayNameEditText.sendKeys(Keys.RETURN);
//        driver.hideKeyboard();
        logger.log(LogStatus.INFO, "inputDisplayNameEditText successfully");
    }

    public void inputFirstNameEditText (String firstName) {
        firstNameEditText.click();
        firstNameEditText.clear();
        firstNameEditText.sendKeys(firstName);
        firstNameEditText.sendKeys(Keys.RETURN);
//        driver.hideKeyboard();
        logger.log(LogStatus.INFO, "inputFirstNameEditText successfully");
    }

    public void inputLastNameEditText (String lastName) {
        lastNameEditText.click();
        lastNameEditText.clear();
        lastNameEditText.sendKeys(lastName);
        lastNameEditText.sendKeys(Keys.RETURN);
//        driver.hideKeyboard();
        logger.log(LogStatus.INFO, "inputLastNameEditText successfully");
    }

    public void setDateOfBirthSelector () throws InterruptedException {
        System.out.println("dateOfBirthSelector: " + dateOfBirthSelector.isDisplayed());
        dateOfBirthSelector.click();
        System.out.println("dateOfBirthSelector.click() 0");
        dateOfBirthSelector.click();
        System.out.println("dateOfBirthSelector.click() 1");
        Thread.sleep(5000);
        DateSelector dateSelector = new DateSelector();
        Thread.sleep(2000);
        dateSelector.performSelectDate();
        logger.log(LogStatus.INFO, "setDateOfBirthSelector successfully");
    }

    public void inputEmailEditText (String email) {
        emailEditText.click();
        emailEditText.clear();
        emailEditText.sendKeys(email);
        driver.hideKeyboard();
        logger.log(LogStatus.INFO, "inputEmailEditText successfully");
    }

    public void inputPhoneEditText (String phone) {
        phoneEditText.click();
        phoneEditText.clear();
        phoneEditText.sendKeys(phone);
        driver.hideKeyboard();
        logger.log(LogStatus.INFO, "inputPhoneEditText successfully");
    }

    public void inputStreetEditText (String phone) {
        streetEditText.click();
        streetEditText.clear();
        streetEditText.sendKeys(phone);
        driver.hideKeyboard();
        logger.log(LogStatus.INFO, "inputStreetEditText successfully");
    }

    public void inputCityEditText (String city) {
        cityEditText.click();
        cityEditText.clear();
        cityEditText.sendKeys(city);
        driver.hideKeyboard();
        logger.log(LogStatus.INFO, "inputCityEditText successfully");
    }

    public void inputZipCodeEditText (String zipcode) {
        zipCodeEditText.click();
        zipCodeEditText.clear();
        zipCodeEditText.sendKeys(zipcode);
        driver.hideKeyboard();
        cityEditText.click();
        driver.hideKeyboard();
        logger.log(LogStatus.INFO, "inputZipCodeEditText successfully");
    }

    public SetUpOption performCreateAccount(
            String displayName,
            String firstName,
            String lastName,
            String dateOfBirth,
            String email,
            String phone,
            String street,
            String city,
//            String state,
            String zipCode
            ) throws InterruptedException {

        inputDisplayNameEditText(displayName);
        Thread.sleep(1000);

        inputFirstNameEditText(firstName);
        Thread.sleep(1000);

        inputLastNameEditText(lastName);
        Thread.sleep(1000);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(0,500))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, 200)).release().perform();

        Thread.sleep(5000);

        setDateOfBirthSelector();

//        inputEmailEditText(email);
//        Thread.sleep(1000);
//
//        inputPhoneEditText(phone);
//        Thread.sleep(1000);
//
//        inputStreetEditText(street);
//        Thread.sleep(1000);
//
//        inputCityEditText(city);
//        Thread.sleep(1000);
//
//        action.press(PointOption.point(0,1000))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
//                .moveTo(PointOption.point(0, 100)).release().perform();
//
//        Thread.sleep(4000);
//
//        inputZipCodeEditText(zipCode);
//
//        createUserButton.click();
//        createUserButton.click();

        return new SetUpOption();
    }


}
