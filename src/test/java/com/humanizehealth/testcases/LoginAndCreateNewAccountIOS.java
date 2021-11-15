package com.humanizehealth.testcases;

import com.humanizehealth.base.Base;
import com.humanizehealth.pages.AccountSetup;
import com.humanizehealth.pages.SetUpOption;
import com.humanizehealth.pages.SignIn;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginAndCreateNewAccountIOS {

//    SignIn signIn;
//    AccountSetup accountSetup;
//    SetUpOption setUpOption;

//    @Test(groups =  {"Smoke"})
//    public void TC_002_Create_New_Account_With_A_Valid_Data_iOS() throws InterruptedException {
//        signIn = new SignIn();
//
//        accountSetup = signIn.clickPlusButton();
//
//        boolean isDisplayed = accountSetup.isTextCompleteYourAccountDisplayed();
//
//        Assert.assertTrue(isDisplayed);
//
//        String displayName = userTestData.getJSONObject("validAccount").getString("displayName");
//        String firstName = userTestData.getJSONObject("validAccount").getString("firstName");
//        String lastName = userTestData.getJSONObject("validAccount").getString("lastName");
//        String email = userTestData.getJSONObject("validAccount").getString("email");
//        String phoneNumber = userTestData.getJSONObject("validAccount").getString("phoneNumber");
//        String street = userTestData.getJSONObject("validAccount").getString("street");
//        String city = userTestData.getJSONObject("validAccount").getString("city");
//        String state = userTestData.getJSONObject("validAccount").getString("state");
//        String zipCode = userTestData.getJSONObject("validAccount").getString("zipCode");
//
//        accountSetup.performCreateAccount(
//                displayName,
//                firstName,
//                lastName,
//                "",
//                email,
//                phoneNumber,
//                street,
//                city,
//                zipCode
//        );
//
//        Assert.assertTrue(true);
//
//    }

    @Test
    public void Start() {
        System.out.println("Start");
    }

    @Test(dependsOnMethods = {"Start"})
    public void Test_cases() {

    }

    @Test(timeOut = 5000)
    public void Test_case_2() {

    }

    @Test(dataProvider = "getData")
    public void MobileSignOut(String username, String password) {
        System.out.println("Mobile SignOut");
        System.out.println("username " + username);
        System.out.println("password " + password);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];

        data[0][0] = "firstsetusername";
        data[0][1] = "firstpassword";

        data[1][0] = "secondsetusername";
        data[1][1] = "secondpassword";

        data[2][0] = "thirdsetusername";
        data[2][1] = "thirdpassword";

        return data;
    }
}
