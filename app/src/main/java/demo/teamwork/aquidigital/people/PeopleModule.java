package demo.teamwork.aquidigital.people;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.tasks.TaskContract.Model;
import demo.teamwork.aquidigital.tasks.TaskContract.Presenter;

@Module
public class PeopleModule {

    @Provides
    @Singleton
    Presenter provideMessagesPresenter(Model model){
        return new PeoplePresenter(model);
    }

    @Provides
    @Singleton
    Model provideMessagesModel(){
        return new PeopleModel();
    }
}
