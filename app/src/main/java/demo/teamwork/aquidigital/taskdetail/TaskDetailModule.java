package demo.teamwork.aquidigital.taskdetail;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskDetailModule {

    @Provides
    @Singleton
    TaskDetailPresenter provideTaskDetailPresenter(TaskDetailContract.Model model){
        return new TaskDetailPresenter(model);
    }

    @Provides
    @Singleton
    TaskDetailContract.Model provideTaskDetailModel(){
        return new TaskDetailModel();
    }
}
