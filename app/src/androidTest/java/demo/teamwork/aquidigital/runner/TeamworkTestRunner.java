package demo.teamwork.aquidigital.runner;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import demo.teamwork.aquidigital.TestTeamworkApplication;

public class TeamworkTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        String testApplicationClassName = TestTeamworkApplication.class.getCanonicalName();
        return super.newApplication(cl, testApplicationClassName, context);
    }
}
