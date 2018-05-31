package demo.teamwork.aquidigital.di;

import javax.inject.Singleton;

import dagger.Component;
import demo.teamwork.aquidigital.addprojects.MockAddProjectModule;
import demo.teamwork.aquidigital.common.injection.AppComponent;
import demo.teamwork.aquidigital.common.injection.FragmentComponent;
import demo.teamwork.aquidigital.people.MockPeopleModule;
import demo.teamwork.aquidigital.taskdetail.MockTaskDetail;
import demo.teamwork.aquidigital.tasks.MockTaskModule;
import demo.teamwork.aquidigital.viewprojects.MockViewProjectsModule;

@Singleton
@Component(modules = {
        MockAppModule.class,
        MockTaskModule.class,
        MockTaskDetail.class,
        MockViewProjectsModule.class,
        MockPeopleModule.class,
        MockApiModule.class,
        MockAddProjectModule.class
})
public interface MockAppComponent extends
        AppComponent,
        FragmentComponent {


}
