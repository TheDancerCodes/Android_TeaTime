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

    @Test
    public void clickDecrementButton_ChangesQuantityAndCost() {
        /**
         *  Finish writing this test which will:
         *     - Check that the initial quantity is zero
         *     - Click on the decrement button
         *     - Verify that the decrement button won't decrease the quantity 0 and cost below $0.00
         */

        // Check that the initial quantity variable is zero
        onView((withId(R.id.cost_text_view))).check(matches(withText("$0.00")));

        // Find the view & click on decrement button
        onView((withId(R.id.decrement_button)))
                .perform(click());

        // Verify that the decrement button won't decrease the quantity below 0
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));

        // Verify that the decrement button won't decrease cost below $0.00
        onView(withId(R.id.cost_text_view)).check(matches(withText("$0.00")));

    }
}
