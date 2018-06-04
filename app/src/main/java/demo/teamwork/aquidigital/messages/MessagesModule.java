package demo.teamwork.aquidigital.messages;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.tasks.ViewTasksContract.Model;
import demo.teamwork.aquidigital.tasks.ViewTasksContract.Presenter;

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
