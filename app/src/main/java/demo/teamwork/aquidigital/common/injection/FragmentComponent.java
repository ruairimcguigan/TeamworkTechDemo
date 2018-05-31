package demo.teamwork.aquidigital.common.injection;

import dagger.Subcomponent;
import demo.teamwork.aquidigital.viewprojects.ViewProjectDetailsActivity;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(ViewProjectDetailsActivity fragment);


}
