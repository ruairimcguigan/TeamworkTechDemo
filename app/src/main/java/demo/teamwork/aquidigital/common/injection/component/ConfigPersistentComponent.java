package demo.teamwork.aquidigital.common.injection.component;



import dagger.Component;
import demo.teamwork.aquidigital.BaseFragment;
import demo.teamwork.aquidigital.common.base.BaseActivity;
import demo.teamwork.aquidigital.common.injection.ConfigPersistent;
import demo.teamwork.aquidigital.common.injection.module.ActivityModule;
import demo.teamwork.aquidigital.common.injection.module.FragmentModule;

/**
 * A dagger component that will live during the lifecycle of an Activity or Fragment but it won't be
 * destroy during configuration changes. Check {@link BaseActivity} and {@link BaseFragment} to see
 * how this components survives configuration changes. Use the {@link ConfigPersistent} scope to
 * annotate dependencies that need to survive configuration changes (for example Presenters).
 */
@ConfigPersistent
@Component(dependencies = AppComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

    FragmentComponent fragmentComponent(FragmentModule fragmentModule);
}
