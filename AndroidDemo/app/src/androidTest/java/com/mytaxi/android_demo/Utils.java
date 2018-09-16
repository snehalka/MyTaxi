package com.mytaxi.android_demo;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

public class Utils {

    public static boolean checkIfUserNotLoggedIn(){
        try {
            onView(withId(R.id.edt_username)).check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void login() throws Exception
    {

        onView(withId(R.id.edt_username)).check(matches(isDisplayed()));
        onView(withId(R.id.edt_username)).perform(ViewActions.click());
        onView(withId(R.id.edt_username)).perform(typeText("crazydog335"));
        onView(withId(R.id.edt_password)).perform(ViewActions.click());
        onView(withId(R.id.edt_password)).perform(typeText("venture"));
        onView(withId(R.id.btn_login)).perform(ViewActions.click());
    }

    public static void textToBeEntered(String textToBeEntered)
    {
        onView(withId(R.id.edt_username)).perform(typeText(textToBeEntered));
    }

    public static void click()
    {
        onView(withId(R.id.textSearch)).perform(ViewActions.click());
    }

}
