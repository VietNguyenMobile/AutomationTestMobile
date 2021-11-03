package com.humanizehealth.pages;

import com.humanizehealth.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SetUpOption extends Base {

    @iOSXCUITFindBy(accessibility = "myOwnHealthButton")
    @AndroidFindBy(accessibility = "myOwnHealthButton")
    public MobileElement myOwnHealthButton;

    @iOSXCUITFindBy(accessibility = "someoneICareForButton")
    @AndroidFindBy(accessibility = "someoneICareForButton")
    public MobileElement someoneICareForButton;

    public boolean isMyOwnHealthButtonDisplayed() {
        return myOwnHealthButton.isDisplayed();
    }
}
