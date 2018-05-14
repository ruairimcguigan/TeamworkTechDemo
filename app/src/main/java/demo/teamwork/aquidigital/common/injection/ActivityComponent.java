package demo.teamwork.aquidigital.common.injection;

import dagger.Subcomponent;
import demo.teamwork.aquidigital.common.injection.PerActivity;
import demo.teamwork.aquidigital.common.injection.ActivityModule;
import demo.teamwork.aquidigital.home.HomeActivity;
import demo.teamwork.aquidigital.projects.ProjectsActivity;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(HomeActivity activity);

    void inject(ProjectsActivity activity);

}
