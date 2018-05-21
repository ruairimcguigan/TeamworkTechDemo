package demo.teamwork.aquidigital.tasks;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.repository.api.TeamworkAPI;
import demo.teamwork.aquidigital.tasks.TaskContract.Model;
import demo.teamwork.aquidigital.tasks.TaskContract.Presenter;
import demo.teamwork.aquidigital.tasks.TaskContract.View;
import io.reactivex.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static timber.log.Timber.d;

public class TaskPresenter extends BasePresenter implements Presenter {

    @Inject
    TeamworkAPI projectService;

    private View view;
    private Model model;

    @Inject
    public TaskPresenter(Model model) {
        this.model = model;
    }

    @Override
    public void attachView(View view) {
        if (view != null) {
            this.view = view;
        }
    }

    @Override
    public void loadTasks() {
        addDisposable(projectService
                .getTasks()
                .observeOn(mainThread())
                .doOnSubscribe(__ -> view.showProgress())
                .doOnError(this::onError)
                .doOnTerminate(() -> view.hideProgress())
                .subscribe(tasksResponse -> onSuccess(tasksResponse.getTodoItems()))
        );
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
