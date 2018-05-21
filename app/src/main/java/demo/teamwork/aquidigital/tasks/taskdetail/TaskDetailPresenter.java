package demo.teamwork.aquidigital.tasks.taskdetail;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.repository.api.TeamworkAPI;

import demo.teamwork.aquidigital.tasks.taskdetail.TaskDetailContract.View;
import timber.log.Timber;

import static demo.teamwork.aquidigital.tasks.taskdetail.TaskDetailContract.*;
import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static timber.log.Timber.d;

public class TaskDetailPresenter extends BasePresenter implements Presenter {

    @Inject
    TeamworkAPI projectService;

    private View view;
    private Model model;

    @Inject
    public TaskDetailPresenter(Model model) {
        this.model = model;
    }


    @Override
    public void attachView(View view) {
        if (view != null) {
            this.view = view;
        }
    }



    @Override
    protected void onSuccess(List tasks) {
        d("Success! Tasks received");
        if (tasks != null && tasks.size() > 0){
            view.showTasks(tasks);
        }

    }

    @Override
    protected void onError(Throwable throwable) {
        Timber.d("Error retrieving tasks", Arrays.toString(throwable.getStackTrace()));
    }
}
