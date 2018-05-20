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
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import timber.log.Timber;

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
        disposable.add(projectService
                .getProjects()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(this::onError)
                .subscribe(result -> ProjectsPresenter.this.onSuccess(result.getProjects())));
    }


    private void onSuccess(List<Project> projects) {
        Timber.d("Success! Projects received");
        if (projects != null && projects.size() > 0) {
            view.showProjects(projects);
        }
    }

    private void onError(Throwable throwable) {
        Timber.d("Error retrieving projects", Arrays.toString(throwable.getStackTrace()));

    }
}
