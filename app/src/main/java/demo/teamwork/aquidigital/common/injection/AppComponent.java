package demo.teamwork.aquidigital.common.injection;

import javax.inject.Singleton;

import dagger.Component;

import demo.teamwork.aquidigital.addproject.AddProjectFragment;
import demo.teamwork.aquidigital.addproject.AddProjectModule;
import demo.teamwork.aquidigital.messages.MessagesFragment;
import demo.teamwork.aquidigital.people.PeopleFragment;
import demo.teamwork.aquidigital.people.PeopleModule;
import demo.teamwork.aquidigital.repository.api.ApiModule;
import demo.teamwork.aquidigital.taskdetail.TaskDetailFragment;
import demo.teamwork.aquidigital.taskdetail.TaskDetailModule;
import demo.teamwork.aquidigital.tasks.TaskModule;
import demo.teamwork.aquidigital.tasks.TasksFragment;
import demo.teamwork.aquidigital.viewprojects.ViewProjectDetailsActivity;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsActivity;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsListFragment;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsModule;

@Singleton
@Component(modules = {
        AppModule.class,
        TaskModule.class,
        TaskDetailModule.class,
        ViewProjectsModule.class,
        PeopleModule.class,
        ApiModule.class,
        AddProjectModule.class
})
public interface AppComponent {

    void inject(ViewProjectsActivity activity);

    void inject(ViewProjectDetailsActivity activity);

    void inject(ViewProjectsListFragment fragment);

    void inject(MessagesFragment fragment);

    void inject(PeopleFragment fragment);

    void inject(TasksFragment fragment);

    void inject(TaskDetailFragment fragment);

    void inject(AddProjectFragment fragment);

}
