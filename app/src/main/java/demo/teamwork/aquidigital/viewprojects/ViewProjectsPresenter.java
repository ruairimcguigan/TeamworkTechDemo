package demo.teamwork.aquidigital.viewprojects;

import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.repository.api.TeamworkAPI;
import demo.teamwork.aquidigital.util.network.NetworkUtil;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsContract.Model;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsContract.Presenter;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsContract.View;
import timber.log.Timber;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;

public class ViewProjectsPresenter extends BasePresenter implements Presenter {

    @Inject TeamworkAPI projectService;
    @Inject NetworkUtil networkUtil;

    private View view;
    private final Model model;

    @Inject
    ViewProjectsPresenter(Model model) {
        this.model = model;
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
        if (networkUtil.isNetworkConnected()) {
            addDisposable(projectService
                    .getProjects()
                    .observeOn(mainThread())
                    .doOnSubscribe(__ -> view.showProgress())
                    .doOnTerminate(() -> view.hideProgress())
                    .subscribe(result -> onSuccess(result.getProjects()), this::onError));
        }
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
        view.onError(throwable);
    }

}
