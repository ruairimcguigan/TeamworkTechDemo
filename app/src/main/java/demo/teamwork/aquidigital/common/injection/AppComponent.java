package demo.teamwork.aquidigital.common.injection;

import javax.inject.Singleton;

import dagger.Component;
import demo.teamwork.aquidigital.createproject.CreateProjectComponent;
import demo.teamwork.aquidigital.createproject.CreateProjectModule;
import demo.teamwork.aquidigital.people.ViewPeopleComponent;
import demo.teamwork.aquidigital.people.ViewPeopleModule;
import demo.teamwork.aquidigital.repository.api.ApiModule;
import demo.teamwork.aquidigital.taskdetail.TaskDetailComponent;
import demo.teamwork.aquidigital.taskdetail.TaskDetailModule;
import demo.teamwork.aquidigital.tasks.ViewTasksComponent;
import demo.teamwork.aquidigital.tasks.ViewTasksModule;
import demo.teamwork.aquidigital.viewprojectdetails.ViewProjectDetailsComponent;
import demo.teamwork.aquidigital.viewprojectdetails.ViewProjectDetailsModule;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsActivity;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsComponent;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsModule;

@Singleton
@Component(modules = {
        AppModule.class,
        ViewTasksModule.class,
        TaskDetailModule.class,
        ViewProjectsModule.class,
        ViewProjectDetailsModule.class,
        ViewPeopleModule.class,
        ApiModule.class,
        CreateProjectModule.class
})
public interface AppComponent extends
        ViewProjectsComponent,
        ViewProjectDetailsComponent,
        CreateProjectComponent,
        ViewTasksComponent,
        TaskDetailComponent,
        ViewPeopleComponent {

    void inject(ViewProjectsActivity activity);

}
