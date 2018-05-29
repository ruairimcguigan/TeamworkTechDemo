package demo.teamwork.aquidigital.tasks;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.tasks.TaskContract.Model;
import demo.teamwork.aquidigital.tasks.TaskContract.Presenter;

@Module
public class TaskModule {

    @Provides
    @Singleton
    Presenter provideTaskPresenter(Model model){
        return new TaskPresenter(model);
    }

    @Provides
    @Singleton
    Model provideProjectModel(){
        return new TasksModel();
    }
}
