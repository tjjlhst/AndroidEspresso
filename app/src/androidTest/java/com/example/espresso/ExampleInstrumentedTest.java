package com.example.espresso;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
//import android.support.test.rule.ActivityTestRule;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.espresso", appContext.getPackageName());
    }
    @Rule
    public ActivityScenarioRule<MainActivity> rule = new ActivityScenarioRule<>(MainActivity.class);
//    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickTest() {
        //tvContent是否默认不显示
//        onView(ViewMatchers.withId(R.id.name))
//                .check(matches(not(isDisplayed())));    //是否不可见
//        for (int i = 0;i< 100;i++){
            //检查btn01的text，然后执行点击事件
            onView(withId(R.id.name))
                    .perform(clearText(), replaceText("username"), closeSoftKeyboard())
//                .check(matches(withText("")))
                    .perform(click());

            onView(withId(R.id.password))
                    .perform(clearText(),replaceText("password"))
                    .perform(click());

            onView(withId(R.id.btn))
                    .perform(click());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }
        //检查tv内容是否修改，并且是否可见
//        onView(withId(R.id.tv_content))
//                .check(matches(withText("hello espresso!")))
//                .check(matches(isDisplayed()));
    }

}
