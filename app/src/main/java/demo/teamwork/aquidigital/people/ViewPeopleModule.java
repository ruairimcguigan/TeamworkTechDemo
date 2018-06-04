package demo.teamwork.aquidigital.people;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.people.ViewPeopleContract.Model;
import demo.teamwork.aquidigital.people.ViewPeopleContract.Presenter;

@Module
public class ViewPeopleModule {

    @Provides
    @Singleton
    Presenter providePeoplePresenter(Model model){
        return new ViewPeoplePresenter(model);
    }

    @Provides
    @Singleton
    Model provideMessagesModel(){
        return new ViewPeopleModel();
    }
}
