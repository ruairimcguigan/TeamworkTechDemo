package demo.teamwork.aquidigital;

import demo.teamwork.aquidigital.createproject.TestCreateProjectModule;
import demo.teamwork.aquidigital.di.TestAppComponent;
import demo.teamwork.aquidigital.di.TestAppModule;
import demo.teamwork.aquidigital.messages.TestMessagesModule;
import demo.teamwork.aquidigital.people.TestPeopleModule;
import demo.teamwork.aquidigital.tasks.TestTaskDetailModule;
import demo.teamwork.aquidigital.tasks.TestTaskModule;
import demo.teamwork.aquidigital.viewprojects.TestViewProjectsModule;

public class TestTeamworkApplication extends TeamworkApplication {

    private TestAppComponent testAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        testAppComponent = DaggerTestAppComponent.builder()
                .testAppModule(new TestAppModule(this))
                .testMessagesModule(new TestMessagesModule())
                .testCreateProjectModule(new TestCreateProjectModule())
                .testPeopleModule(new TestPeopleModule())
                .testTaskModule(new TestTaskModule())
                .testTaskDetailModule(new TestTaskDetailModule())
                .testViewProjectsModule(new TestViewProjectsModule())
                .testApiModule(new TestApiModule())
                .build();
    }

    @Override
    public TestAppComponent getAppComponent() {
        return testAppComponent;
    }
}
