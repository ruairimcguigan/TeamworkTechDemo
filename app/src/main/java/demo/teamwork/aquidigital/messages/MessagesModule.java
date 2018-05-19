package demo.teamwork.aquidigital.messages;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.tasks.TaskContract.Model;
import demo.teamwork.aquidigital.tasks.TaskContract.Presenter;

@Module
public class MessagesModule {

    @Provides
    @Singleton
    Presenter provideMessagesPresenter(Model model){
        return new MessagesPresenter(model);
    }

    @Provides
    @Singleton
    Model provideMessagesModel(){
        return new MessagesModel();
    }
}
