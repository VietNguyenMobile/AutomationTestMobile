package com.humanizehealth.testcases;

import com.humanizehealth.base.Base;
import com.humanizehealth.pages.AccountSetup;
import com.humanizehealth.pages.SetUpOption;
import com.humanizehealth.pages.SignIn;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAndCreateNewAccountIOS extends Base {

    SignIn signIn;
    AccountSetup accountSetup;
    SetUpOption setUpOption;

    @Test
    public void TC_001_Create_New_Account_With_A_Valid_Data_iOS() throws InterruptedException {
        signIn = new SignIn();

        accountSetup = signIn.clickPlusButton();

        boolean isDisplayed = accountSetup.isTextCompleteYourAccountDisplayed();

        Assert.assertTrue(isDisplayed);

        String displayName = userTestData.getJSONObject("validAccount").getString("displayName");
        String firstName = userTestData.getJSONObject("validAccount").getString("firstName");
        String lastName = userTestData.getJSONObject("validAccount").getString("lastName");
        String email = userTestData.getJSONObject("validAccount").getString("email");
        String phoneNumber = userTestData.getJSONObject("validAccount").getString("phoneNumber");
        String street = userTestData.getJSONObject("validAccount").getString("street");
        String city = userTestData.getJSONObject("validAccount").getString("city");
        String state = userTestData.getJSONObject("validAccount").getString("state");
        String zipCode = userTestData.getJSONObject("validAccount").getString("zipCode");

        accountSetup.performCreateAccount(
                displayName,
                firstName,
                lastName,
                "",
                email,
                phoneNumber,
                street,
                city,
                zipCode
        );

        Assert.assertTrue(true);

    }
}
