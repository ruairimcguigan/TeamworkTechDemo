package demo.teamwork.aquidigital.tasks;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.repository.api.TeamworkAPI;
import demo.teamwork.aquidigital.tasks.ViewTasksContract.Model;
import demo.teamwork.aquidigital.tasks.ViewTasksContract.Presenter;
import demo.teamwork.aquidigital.tasks.ViewTasksContract.View;
import demo.teamwork.aquidigital.util.network.NetworkUtil;
import timber.log.Timber;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static timber.log.Timber.d;

public class ViewTasksPresenter extends BasePresenter implements Presenter {

    @Inject TeamworkAPI projectService;
    @Inject NetworkUtil networkUtil;

    private Model model;
    private View view;

    @Inject
    public ViewTasksPresenter(Model model) {
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
        if (networkUtil.isNetworkConnected()) {
            addDisposable(projectService
                    .getTasks()
                    .observeOn(mainThread())
                    .doOnSubscribe(__ -> view.showProgress())
                    .doOnTerminate(() -> view.hideProgress())
                    .subscribe(tasksResponse
                            -> onSuccess(tasksResponse.getTodoItems()), this::onError));
        }
    }

    @Override
    protected void onSuccess(List tasks) {
        d("Success! Tasks received");
            view.showTasks(tasks);
    }

    @Override
    protected void onError(Throwable throwable) {
        Timber.d("Error retrieving tasks", Arrays.toString(throwable.getStackTrace()));
        view.onError(throwable);
    }
}
