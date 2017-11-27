package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

/**
 * Created by @thedancercodes on 27/11/2017.
 */

// Specify AndroidJUnitRunner class as the default test runner
@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {

    // Declaring a Tea Name variable
    public static final String TEA_NAME = "Black Tea";

    // ActivityTestRule - A rule that provides functional testing for a specific, single activity.
    @Rule
    public ActivityTestRule<MenuActivity> mMenuActivityActivityTestRule
            = new ActivityTestRule<>(MenuActivity.class);

    /**
     * Test that clicks on a gridView item and verifies that
     * the OrderActivity opens up with the correct tea name displayed.
     */
    @Test
    public void clickGridViewItem_OpensOrderActivity() {

        // Use {@link Espresso#onData(org.hamcrest.Matcher)} to get a reference to a specific
        // gridView item and clicks it.
        onData(anything())
                .inAdapterView(withId(R.id.tea_grid_view))
                .atPosition(0)
                .perform(click());

        // Checks that the OrderActivity opens with the correct tea name displayed
        onView(withId(R.id.tea_name_text_view)).check(matches(withText(TEA_NAME)));
    }
}
