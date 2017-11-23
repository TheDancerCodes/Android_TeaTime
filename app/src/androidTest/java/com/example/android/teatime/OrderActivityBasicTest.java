package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by @thedancercodes on 23/11/2017.
 */

@RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {

    // ActivityTestRule - A rule that provides functional testing for a specific, single activity.
    @Rule public ActivityTestRule<OrderActivity> mActivityActivityTestRule
            = new ActivityTestRule<>(OrderActivity.class);

    // @Test - Indicates where we'll be testing what we are interested in.
    @Test
    public void clickIncrementButton_ChangesQuantityAndCost(){
        /**
         * Three steps to write a UI Test
         *      1. Find the View - [ViewMatcher]
         *      2. Perform action on the View - [ViewAction]
         *      3. Check if the View does what is expected - [ViewAssertion]
         */

        // 1. Find the view
        // 2. Perform action on view
        onView((withId(R.id.increment_button))).perform(click());

        // 3. Check if the View does what is expected:
        // EXPECTATIONS / ASSERTIONS:
        // Quantity text view increased by 1 and
        // Cost text view increased by the cost of one small cup of tea - $5 for a single cup
        onView(withId(R.id.quantity_text_view)).check(matches(withText("1")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$5.00")));



    }
}
