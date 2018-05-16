package demo.teamwork.aquidigital.common.injection;

import javax.inject.Singleton;

import dagger.Component;
import demo.teamwork.aquidigital.home.HomeActivity;
import demo.teamwork.aquidigital.home.HomeModule;
import demo.teamwork.aquidigital.projects.ProjectsActivity;
import demo.teamwork.aquidigital.projects.ProjectsModule;
import demo.teamwork.aquidigital.repository.ApiModule;

@Singleton
@Component(modules = {
        AppModule.class,
        HomeModule.class,
        ProjectsModule.class,
        ApiModule.class})
public interface AppComponent {

    void inject(HomeActivity activity);

    void inject(ProjectsActivity activity);


}
