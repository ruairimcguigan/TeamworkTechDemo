package demo.teamwork.aquidigital.addproject;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.addproject.AddProjectContract.Model;

@Module
public class AddProjectModule {

    @Provides
    @Singleton
    AddProjectContract.Presenter provideAddProjectPresenter(Model model){
        return new AddProjectPresenter(model);
    }

    @Provides
    @Singleton
    Model provideAddProjectModel(){
        return new AddProjectModel();
    }
}