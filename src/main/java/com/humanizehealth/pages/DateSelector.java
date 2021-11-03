package com.humanizehealth.pages;

import com.humanizehealth.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.interactions.Actions;

public class DateSelector extends Base {
    @iOSXCUITFindBy(accessibility = "selectButton")
    @AndroidFindBy(accessibility = "selectButton")
    public MobileElement selectButton;

    @iOSXCUITFindBy(accessibility = "Select Month")
    @AndroidFindBy(accessibility = "Select Month")
    public MobileElement selectMonth;

    @iOSXCUITFindBy(accessibility = "Select Date")
    @AndroidFindBy(accessibility = "Select Date")
    public MobileElement selectDate;

    @iOSXCUITFindBy(accessibility = "Select Year")
    @AndroidFindBy(accessibility = "Select Year")
    public MobileElement selectYear;

    @iOSXCUITFindBy(id = "com.humanize.health.qa:id/overlay_top")
    @AndroidFindBy(id = "com.humanize.health.qa:id/overlay_top")
    public MobileElement overlayTop;

    @iOSXCUITFindBy(id = "com.humanize.health.qa:id/overlay_bottom")
    @AndroidFindBy(id = "com.humanize.health.qa:id/overlay_bottom")
    public MobileElement overlayBottom;

    public void performSelectDate() throws InterruptedException {
        System.out.println("performSelectDate");
        selectYear.click();
        System.out.println("selectYear: " + selectYear.isDisplayed());
        Actions actions = new Actions(driver);
        actions.clickAndHold(overlayTop).moveToElement(overlayBottom).build().perform();
        Thread.sleep(4000);
        selectButton.click();
    }

}
