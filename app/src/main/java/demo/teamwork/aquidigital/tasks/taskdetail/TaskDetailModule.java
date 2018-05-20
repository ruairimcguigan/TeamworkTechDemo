package demo.teamwork.aquidigital.tasks.taskdetail;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.tasks.taskdetail.TaskDetailContract.Presenter;

@Module
public class TaskDetailModule {

    @Provides
    @Singleton
    Presenter provideTaskDetailPresenter(TaskDetailContract.Model model){
        return new TaskDetailPresenter(model);
    }

    @Provides
    @Singleton
    TaskDetailContract.Model provideTaskDetailModel(){
        return new TaskDetailModel();
    }
}
