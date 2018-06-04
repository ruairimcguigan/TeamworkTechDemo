package demo.teamwork.aquidigital.di;

import javax.inject.Singleton;

import dagger.Component;
import demo.teamwork.aquidigital.TestApiModule;
import demo.teamwork.aquidigital.common.injection.AppComponent;
import demo.teamwork.aquidigital.createproject.CreateProjectComponent;
import demo.teamwork.aquidigital.createproject.TestCreateProjectModule;
import demo.teamwork.aquidigital.messages.MessagesComponent;
import demo.teamwork.aquidigital.people.TestPeopleModule;
import demo.teamwork.aquidigital.people.ViewPeopleComponent;
import demo.teamwork.aquidigital.taskdetail.TaskDetailComponent;
import demo.teamwork.aquidigital.tasks.TestTaskDetailModule;
import demo.teamwork.aquidigital.tasks.TestTaskModule;
import demo.teamwork.aquidigital.tasks.ViewTasksComponent;
import demo.teamwork.aquidigital.tests.ViewProjectActivityTest;
import demo.teamwork.aquidigital.viewprojects.TestViewProjectsModule;
import demo.teamwork.aquidigital.viewprojectdetails.ViewProjectDetailsComponent;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsComponent;

@Singleton
@Component(modules = {
        TestAppModule.class,
        TestTaskModule.class,
        TestTaskDetailModule.class,
        TestViewProjectsModule.class,
        MockViewProjectDetailsModule.class,
        TestCreateProjectModule.class,
        TestPeopleModule.class,
        TestApiModule.class,
})
public interface TestAppComponent extends
        AppComponent,
        ViewProjectsComponent,
        ViewProjectDetailsComponent,
        CreateProjectComponent,
        MessagesComponent,
        ViewPeopleComponent,
        ViewTasksComponent,
        TaskDetailComponent {

    void inject(ViewProjectActivityTest test);
}
