package demo.teamwork.aquidigital.di;

import javax.inject.Singleton;

import dagger.Component;
import demo.teamwork.aquidigital.addproject.AddProjectComponent;
import demo.teamwork.aquidigital.addprojects.MockAddProjectModule;
import demo.teamwork.aquidigital.common.injection.AppComponent;
import demo.teamwork.aquidigital.messages.MessagesComponent;
import demo.teamwork.aquidigital.people.MockPeopleModule;
import demo.teamwork.aquidigital.people.PeopleComponent;
import demo.teamwork.aquidigital.taskdetail.MockTaskDetailModule;
import demo.teamwork.aquidigital.taskdetail.TaskDetailComponent;
import demo.teamwork.aquidigital.tasks.MockTaskModule;
import demo.teamwork.aquidigital.tasks.TaskComponent;
import demo.teamwork.aquidigital.viewprojects.MockViewProjectDetailsModule;
import demo.teamwork.aquidigital.viewprojects.MockViewProjectsModule;
import demo.teamwork.aquidigital.viewprojects.ViewProjectDetailsComponent;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsComponent;

@Singleton
@Component(modules = {
        MockAppModule.class,
        MockTaskModule.class,
        MockTaskDetailModule.class,
        MockViewProjectsModule.class,
        MockViewProjectDetailsModule.class,
        MockAddProjectModule.class,
        MockPeopleModule.class,
        MockApiModule.class,
})
public interface MockAppComponent extends
        AppComponent,
        ViewProjectsComponent,
        ViewProjectDetailsComponent,
        AddProjectComponent,
        MessagesComponent,
        PeopleComponent,
        TaskComponent,
        TaskDetailComponent { }
