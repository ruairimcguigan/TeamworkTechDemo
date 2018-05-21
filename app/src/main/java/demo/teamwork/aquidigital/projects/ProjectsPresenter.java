package demo.teamwork.aquidigital.projects;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.projects.ProjectsContract.Model;
import demo.teamwork.aquidigital.projects.ProjectsContract.Presenter;
import demo.teamwork.aquidigital.projects.ProjectsContract.View;
import demo.teamwork.aquidigital.repository.api.TeamworkAPI;
import demo.teamwork.aquidigital.repository.api.projectsmodel.Project;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectsResponse;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import timber.log.Timber;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;

public class ProjectsPresenter extends BasePresenter implements Presenter {

    @Inject
    TeamworkAPI projectService;

    private View view;
    private final Model projectModel;

    @Inject
    ProjectsPresenter(Model projectModel) {
        this.projectModel = projectModel;
    }

    public enum NavigationSelection{
        PROJECTS, MESSAGES, TASKS, PEOPLE
    }

    @Override
    public void attachView(View view) {
        if (view != null) {
            this.view = view;
        }
    }

    @Override
    public void loadProjects() {
        addDisposable(projectService
                .getProjects()
                .observeOn(mainThread())
                .doOnSubscribe(__ -> view.showProgress())
                .doOnError(this::onError)
                .doOnTerminate(() -> view.hideProgress())
                .subscribe(result -> onSuccess(result.getProjects())));
    }

    @Override
    protected void onSuccess(List projects) {
        Timber.d("Success! Projects received");
        if (projects != null && projects.size() > 0) {
            view.showProjects(projects);
        }
    }

    @Override
    protected void onError(Throwable throwable) {
        Timber.d("Error retrieving projects", Arrays.toString(throwable.getStackTrace()));
    }

}
