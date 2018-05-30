package demo.teamwork.aquidigital.projects.addproject;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.projects.addproject.AddProjectContract.Model;
import demo.teamwork.aquidigital.projects.addproject.AddProjectContract.Presenter;
import demo.teamwork.aquidigital.projects.addproject.AddProjectContract.View;
import demo.teamwork.aquidigital.repository.api.TeamworkAPI;
import demo.teamwork.aquidigital.repository.api.addprojectmodel.ProjectRequest;
import demo.teamwork.aquidigital.repository.api.addprojectmodel.Project;
import demo.teamwork.aquidigital.repository.api.addprojectmodel.Project.Builder;
import timber.log.Timber;

import static demo.teamwork.aquidigital.util.ui.ViewUtil.*;
import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static java.time.LocalDate.of;
import static timber.log.Timber.d;

public class AddProjectPresenter extends BasePresenter implements Presenter {

    @Inject
    TeamworkAPI projectService;

    private View view;
    private Model model;
    private Project project;

    @Inject
    AddProjectPresenter(Model model) {
        this.model = model;
    }

    @Override
    public void attachView(View view) {
        if (view != null) {
            this.view = view;
        }
    }

    @Override
    public void loadTags() {
        addDisposable(projectService
                .getTags()
                .observeOn(mainThread())
                .doOnSubscribe(__ -> view.showProgress())
                .doOnError(this::onError)
                .doOnTerminate(() -> view.hideProgress())
                .subscribe(tagResponse -> onSuccess(tagResponse.getTags()))
        );
    }

    @Override
    protected void onSuccess(List tags) {
        d("Success! Tags loaded");
        if (tags != null && tags.size() > 0) {
            view.showTags(tags);
        }
    }

    @Override
    protected void onError(Throwable throwable) {
        Timber.d("Error saving project", Arrays.toString(throwable.getStackTrace()));
    }

    @Override
    public void onStartDateSelected(int year, int month, int day) {
        view.populateStartDate(formatDateForDisplay(year, month, day));
    }



    @Override
    public void onEndDateSelected(int year, int month, int day) {
        view.populateEndDate(formatDateForDisplay(year, month, day));
    }

    @Override
    public void onProjectFormComplete(String title, String description, String company,
                                      String tags, int category, String startDate, String endDate) {


        ProjectRequest requestWrapper = new ProjectRequest(
                new Builder(title, description, company, tags, category, startDate, endDate).build());


        addDisposable(projectService
                .createProject(requestWrapper)
                .observeOn(mainThread())
                .doOnSubscribe(__ -> view.showProgress())
                .doOnError(this::onError)
                .doOnTerminate(() -> view.hideProgress())
                .subscribe(create -> onCreateProjectSuccess())
        );
    }

    private void onCreateProjectSuccess() {
        view.showCreateProjectSuccess();
    }


}
