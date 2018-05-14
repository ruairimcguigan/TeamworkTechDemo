package demo.teamwork.aquidigital.common.injection.component;

import dagger.Subcomponent;
import demo.teamwork.aquidigital.common.injection.PerFragment;
import demo.teamwork.aquidigital.common.injection.module.FragmentModule;
import demo.teamwork.aquidigital.projects.ProjectDetailsFragment;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(ProjectDetailsFragment fragment);


}
