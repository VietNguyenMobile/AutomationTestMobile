package com.humanizehealth.pages;

import com.humanizehealth.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SignIn extends Base {
    @iOSXCUITFindBy(accessibility = "plusButton")
    @AndroidFindBy(accessibility = "plusButton")
    public MobileElement plusButton;

    public AccountSetup clickPlusButton() {
        plusButton.click();
        return new AccountSetup();
    }

}
