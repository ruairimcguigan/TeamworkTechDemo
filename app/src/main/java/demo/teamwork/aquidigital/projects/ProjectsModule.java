package demo.teamwork.aquidigital.projects;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static demo.teamwork.aquidigital.projects.ProjectsContract.*;

@Module
public class ProjectsModule {

    @Provides
    @Singleton
    Presenter providePeoplePresenter(Model model){
        return new ProjectsPresenter(model);
    }

    @Provides
    @Singleton
    Model provideProjectModel(){
        return new ProjectsModel();
    }
}
