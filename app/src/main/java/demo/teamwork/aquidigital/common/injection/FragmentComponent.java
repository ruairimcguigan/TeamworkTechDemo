package demo.teamwork.aquidigital.common.injection;

import dagger.Subcomponent;
import demo.teamwork.aquidigital.common.injection.PerFragment;
import demo.teamwork.aquidigital.common.injection.FragmentModule;
import demo.teamwork.aquidigital.projects.ProjectDetailsFragment;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(ProjectDetailsFragment fragment);


}
