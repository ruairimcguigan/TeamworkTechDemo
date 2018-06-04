package demo.teamwork.aquidigital.tasks;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.tasks.ViewTasksContract.Model;
import demo.teamwork.aquidigital.tasks.ViewTasksContract.Presenter;

@Module
public class ViewTasksModule {

    @Provides
    @Singleton
    Presenter provideTaskPresenter(Model model){
        return new ViewTasksPresenter(model);
    }

    @Provides
    @Singleton
    Model provideProjectModel(){
        return new ViewTasksModel();
    }
}
