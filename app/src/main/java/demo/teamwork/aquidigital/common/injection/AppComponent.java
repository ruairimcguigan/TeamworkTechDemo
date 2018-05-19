package demo.teamwork.aquidigital.common.injection;

import javax.inject.Singleton;

import dagger.Component;
import demo.teamwork.aquidigital.tasks.TasksFragment;
import demo.teamwork.aquidigital.tasks.TaskModule;
import demo.teamwork.aquidigital.projects.ProjectsActivity;
import demo.teamwork.aquidigital.projects.ProjectsListFragment;
import demo.teamwork.aquidigital.projects.ProjectsModule;
import demo.teamwork.aquidigital.repository.ApiModule;

@Singleton
@Component(modules = {
        AppModule.class,
        TaskModule.class,
        ProjectsModule.class,
        ApiModule.class})
public interface AppComponent {

    void inject(TasksFragment fragment);

    void inject(ProjectsListFragment fragment);

    void inject(ProjectsActivity activity);


}
