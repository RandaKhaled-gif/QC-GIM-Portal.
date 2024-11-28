package io.paysky.qc;

import io.paysky.qc.pages.OnboardingPage;
import io.paysky.qc.pages.Login.LoginPage;
import io.paysky.qc.pages.Logout.Logout;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.testng.Tag;

public class LoginTest {

    final OnboardingPage onboardingPage = new OnboardingPage();
    final LoginPage loginPage = new LoginPage();
    final Logout logoutPage = new Logout();

    @org.testng.annotations.Test(priority = 1)
    @Description("Check that the user can login with valid credentials")
    @Link("https://devops.paysky.io/DefaultCollection/Infinity/_workitems/edit/62811")
    @Owner("Mohamed Ehab")
    @Tag("End-To-End")

    public void validLoginWithadminuser() throws Exception {
        onboardingPage.setUp();
        loginPage.LoginURL();
        loginPage.Valid_Login_with_admin_user();
        logoutPage.Log_out();
    }

    @org.testng.annotations.Test(priority = 2)
    @Description("Check that the user can't login with invalid credentials")
    @Link("https://devops.paysky.io/DefaultCollection/Infinity/_workitems/edit/62812")
    @Owner("Mohamed Ehab")
    @Tag("End-To-End")

    public void invalidcredentialsLoginWithadminuser() throws Exception {
        loginPage.Invalid_credentials_with_admin_user();
        loginPage.Login_clear_credentials();
    }

    @org.testng.annotations.Test(priority = 3)
    @Description("check that the user can't login with invalid OTP code")
    @Link("https://devops.paysky.io/DefaultCollection/Infinity/_workitems/edit/62813")
    @Owner("Mohamed Ehab")
    @Tag("End-To-End")

    public void invalidotpLoginWithadminuser() throws Exception {
        loginPage.Invalid_OTP_Login_with_admin_user();
    }

}
