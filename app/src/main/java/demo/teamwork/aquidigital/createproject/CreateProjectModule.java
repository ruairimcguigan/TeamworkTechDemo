package demo.teamwork.aquidigital.createproject;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.createproject.CreateProjectContract.Model;

@Module
public class CreateProjectModule {

    @Provides
    @Singleton
    CreateProjectContract.Presenter provideAddProjectPresenter(Model model){
        return new CreateProjectPresenter(model);
    }

    @Provides
    @Singleton
    Model provideAddProjectModel(){
        return new CreateProjectModel();
    }
}
