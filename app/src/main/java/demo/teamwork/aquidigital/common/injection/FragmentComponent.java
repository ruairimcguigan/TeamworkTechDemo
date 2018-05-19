package demo.teamwork.aquidigital.common.injection;

import dagger.Subcomponent;
import demo.teamwork.aquidigital.projects.ProjectDetailsActivity;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(ProjectDetailsActivity fragment);


}
