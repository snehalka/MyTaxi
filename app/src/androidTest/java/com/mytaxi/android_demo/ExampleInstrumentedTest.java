package com.mytaxi.android_demo;

import android.content.Context;
import android.os.Build;
import android.support.test.InstrumentationRegistry;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import android.support.test.espresso.assertion.ViewAssertions;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    static Properties prop;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
        public void listGoesOverTheFold() throws Exception{
            System.out.println(Build.VERSION.SDK_INT);
            if (Build.VERSION.SDK_INT >= 23) {
                UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
                UiObject allowPermissions = device.findObject(new UiSelector().text("ALLOW"));
                if (allowPermissions.exists()) {
                    try {
                        allowPermissions.click();
                    } catch (UiObjectNotFoundException e) {
                    }
                }
            }

            if(Utils.checkIfUserNotLoggedIn()){
                Utils.login();
            }
            onView(withId(R.id.textSearch)).perform(click());
            onView(withId(R.id.textSearch)).perform(typeText("sa"));
            onView(withText("Sarah Scott"))
                    .inRoot(RootMatchers.isPlatformPopup())
                    .perform(click());
            onView(withId(R.id.fab)).perform(click());
        }
    }


