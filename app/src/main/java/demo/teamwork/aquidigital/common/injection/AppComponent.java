package demo.teamwork.aquidigital.common.injection;

import javax.inject.Singleton;

import dagger.Component;
import demo.teamwork.aquidigital.messages.MessagesFragment;
import demo.teamwork.aquidigital.people.PeopleFragment;
import demo.teamwork.aquidigital.people.PeopleModule;
import demo.teamwork.aquidigital.tasks.TasksFragment;
import demo.teamwork.aquidigital.tasks.TaskModule;
import demo.teamwork.aquidigital.projects.ProjectsActivity;
import demo.teamwork.aquidigital.projects.ProjectsListFragment;
import demo.teamwork.aquidigital.projects.ProjectsModule;
import demo.teamwork.aquidigital.repository.api.ApiModule;
import demo.teamwork.aquidigital.tasks.taskdetail.TaskDetailFragment;
import demo.teamwork.aquidigital.tasks.taskdetail.TaskDetailModule;

@Singleton
@Component(modules = {
        AppModule.class,
        TaskModule.class,
        TaskDetailModule.class,
        ProjectsModule.class,
        PeopleModule.class,
        ApiModule.class})
public interface AppComponent {

    void inject(ProjectsActivity activity);

    void inject(ProjectsListFragment fragment);

    void inject(MessagesFragment fragment);

    void inject(PeopleFragment fragment);

    void inject(TasksFragment fragment);

    void inject(TaskDetailFragment fragment);

}
