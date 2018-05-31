package demo.teamwork.aquidigital.viewprojects;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static demo.teamwork.aquidigital.viewprojects.ViewProjectsContract.*;

@Module
public class ViewProjectsModule {

    @Provides
    @Singleton
    Presenter providePeoplePresenter(Model model){
        return new ViewProjectsPresenter(model);
    }

    @Provides
    @Singleton
    Model provideProjectModel(){
        return new ViewProjectsModel();
    }
}
