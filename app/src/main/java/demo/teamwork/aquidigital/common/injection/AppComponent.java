package demo.teamwork.aquidigital.common.injection;

import javax.inject.Singleton;

import dagger.Component;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.addproject.AddProjectComponent;
import demo.teamwork.aquidigital.addproject.AddProjectModule;
import demo.teamwork.aquidigital.messages.MessagesComponent;
import demo.teamwork.aquidigital.people.PeopleComponent;
import demo.teamwork.aquidigital.people.PeopleModule;
import demo.teamwork.aquidigital.repository.api.ApiModule;
import demo.teamwork.aquidigital.taskdetail.TaskDetailComponent;
import demo.teamwork.aquidigital.taskdetail.TaskDetailModule;
import demo.teamwork.aquidigital.tasks.TaskComponent;
import demo.teamwork.aquidigital.tasks.TaskModule;
import demo.teamwork.aquidigital.viewprojects.ViewProjectDetailsComponent;
import demo.teamwork.aquidigital.viewprojects.ViewProjectDetailsModule;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsActivity;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsComponent;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsModule;

@Singleton
@Component(modules = {
        AppModule.class,
        TaskModule.class,
        TaskDetailModule.class,
        ViewProjectsModule.class,
        ViewProjectDetailsModule.class,
        PeopleModule.class,
        ApiModule.class,
        AddProjectModule.class
})
public interface AppComponent extends
        ViewProjectsComponent,
        ViewProjectDetailsComponent,
        AddProjectComponent,
        TaskComponent,
        TaskDetailComponent,
        MessagesComponent,
        PeopleComponent {

    void inject(TeamworkApplication application);

    void inject(ViewProjectsActivity activity);
}
