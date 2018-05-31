package demo.teamwork.aquidigital.viewprojects;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static demo.teamwork.aquidigital.viewprojects.ViewProjectDetailsContract.*;

@Module
public class ViewProjectDetailsModule {
    @Provides
    @Singleton
    Presenter providePeoplePresenter(Model model){
        return new ViewProjectDetailsPresenter(model);
    }

    @Provides
    @Singleton
    Model provideProjectModel(){
        return new ViewProjectDetailsModel();
    }

}
