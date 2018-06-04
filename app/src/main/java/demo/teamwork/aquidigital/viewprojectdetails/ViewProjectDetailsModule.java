package demo.teamwork.aquidigital.viewprojectdetails;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static demo.teamwork.aquidigital.viewprojectdetails.ViewProjectDetailsContract.*;

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
