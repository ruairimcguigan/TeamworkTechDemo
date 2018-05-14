package demo.teamwork.aquidigital.injection.component;

import dagger.Subcomponent;
import demo.teamwork.aquidigital.injection.PerFragment;
import demo.teamwork.aquidigital.injection.module.FragmentModule;
import demo.teamwork.aquidigital.projects.ProjectDetailsFragment;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(ProjectDetailsFragment fragment);


}
