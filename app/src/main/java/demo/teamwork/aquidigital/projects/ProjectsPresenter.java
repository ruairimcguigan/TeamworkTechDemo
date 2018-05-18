package demo.teamwork.aquidigital.projects;

import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.projects.ProjectsContract.Model;
import demo.teamwork.aquidigital.projects.ProjectsContract.Presenter;
import demo.teamwork.aquidigital.projects.ProjectsContract.View;
import demo.teamwork.aquidigital.repository.api.ProjectAPI;
import demo.teamwork.aquidigital.repository.api.apimodel.Project;
import demo.teamwork.aquidigital.repository.api.apimodel.Response;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class ProjectsPresenter implements Presenter {

    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    ProjectAPI projectService;

    private View view;
    private final Model projectModel;

    @Inject
    ProjectsPresenter(Model projectModel) {
        this.projectModel = projectModel;
    }

    @Override
    public void attachView(View view) {
        this.view = view;
    }

    @Override
    public void loadProjects() {

       disposable.add(projectService.getProjects()
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeWith(new DisposableObserver<Response>() {
                                  @Override
                                  public void onNext(Response response) {
                                      Timber.d("Success! Projects received");
                                      if (response.getProjects() != null && response.getProjects().size() > 0) {
                                          onSuccess(response.getProjects());
                                      }
                                  }

                                  @Override
                                  public void onError(Throwable e) {
                                        onError(e);
                                  }

                                  @Override
                                  public void onComplete() {

                                  }
                              }));


//        disposable.add(projectService
//                .getProjects()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Consumer<Response>() {
//                    @Override
//                    public void accept(Response result) throws Exception {
//                        ProjectsPresenter.this.onSuccess(result.getProjects());
//                    }
//                }));
    }

    private void onSuccess(List<Project> projects) {
        Timber.d("Success! Projects received");
        if (projects != null && projects.size() > 0) {
            view.showProjects(projects);
        }
    }

    private void onError(Throwable throwable) {
        Timber.d("Error retrieving projects", throwable.getStackTrace().toString());

    }
}
