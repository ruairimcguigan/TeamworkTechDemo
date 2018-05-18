package demo.teamwork.aquidigital.projects;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.projects.ProjectsContract.Model;
import demo.teamwork.aquidigital.projects.ProjectsContract.Presenter;

@Module
public class ProjectsModule {



    @Provides
    @Singleton
    Presenter provideProjectPresenter(Model model){
        return new ProjectsPresenter(model);
    }

    @Provides
    @Singleton
    Model provideProjectModel(){
        return new ProjectsModel();
    }
}
