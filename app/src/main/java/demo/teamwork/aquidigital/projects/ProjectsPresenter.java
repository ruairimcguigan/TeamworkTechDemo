package demo.teamwork.aquidigital.projects;

import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.projects.ProjectsContract.Model;
import demo.teamwork.aquidigital.projects.ProjectsContract.Presenter;
import demo.teamwork.aquidigital.projects.ProjectsContract.View;
import demo.teamwork.aquidigital.repository.api.ProjectAPI;
import demo.teamwork.aquidigital.repository.apimodel.Project;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class ProjectsPresenter implements Presenter {

    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    ProjectAPI projectService;

    private View view;
    private Model projectModel;

    @Inject
    ProjectsPresenter(Model projectModel) {
        this.projectModel = projectModel;
    }

    @Override
    public void attachView(View view) {
        this.view = view;
    }

    @Override
    public void getProjects() {
        disposable.add(projectService
                .getProjects()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(result -> onSuccess(result.projects()), this::onError));
    }

    private void onSuccess(List<Project> projects) {
        view.showProjects(projects);
    }

    private void onError(Throwable throwable) {
        Timber.d("Error retrieving projects", throwable.getLocalizedMessage());
    }
}
