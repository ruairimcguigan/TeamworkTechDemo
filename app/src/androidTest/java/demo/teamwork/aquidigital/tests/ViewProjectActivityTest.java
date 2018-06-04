package demo.teamwork.aquidigital.tests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import demo.teamwork.aquidigital.TestTeamworkApplication;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsActivity;

@RunWith(AndroidJUnit4.class)
public class ViewProjectActivityTest {

    @Rule
    public ActivityTestRule<ViewProjectsActivity> activityTestRule = new ActivityTestRule<>(ViewProjectsActivity.class);

    @Before
    public void setUp(){

        ((TestTeamworkApplication) activityTestRule.getActivity().getApplication()).getAppComponent().inject(this);

    }
}
