package demo.teamwork.aquidigital.people;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.people.PeopleContract.Model;
import demo.teamwork.aquidigital.people.PeopleContract.Presenter;

@Module
public class PeopleModule {

    @Provides
    @Singleton
    Presenter providePeoplePresenter(Model model){
        return new PeoplePresenter(model);
    }

    @Provides
    @Singleton
    Model provideMessagesModel(){
        return new PeopleModel();
    }
}
