package demo.teamwork.aquidigital.createproject;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.createproject.CreateProjectContract.Model;
import demo.teamwork.aquidigital.createproject.CreateProjectContract.Presenter;
import demo.teamwork.aquidigital.createproject.CreateProjectContract.View;
import demo.teamwork.aquidigital.repository.api.TeamworkApi;
import demo.teamwork.aquidigital.createproject.models.Project;
import demo.teamwork.aquidigital.createproject.models.ProjectRequest;
import demo.teamwork.aquidigital.util.network.NetworkUtil;
import demo.teamwork.aquidigital.util.ui.ViewUtil;
import timber.log.Timber;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static timber.log.Timber.d;

public class CreateProjectPresenter extends BasePresenter implements Presenter {

    @Inject TeamworkApi projectService;
    @Inject NetworkUtil networkUtil;
    @Inject ViewUtil viewUtil;

    private View view;
    private Model model;
    private CreateProjectDateObj startCreateProjectDateObj;
    private CreateProjectDateObj endCreateProjectDateObj;

    private String title;
    private String description;
    private String company;
    private String tag;
    private int category;

    @Inject
    CreateProjectPresenter(Model model) {
        this.model = model;
    }

    @Override
    public void attachView(View view) {
        if (view != null) {
            this.view = view;
        }
    }

    @Override
    public void onTitleChanged(String title){
        this.title = title;
    }

    @Override
    public void onDescriptionChanged(String description) {
        this.description = description;
    }

    @Override
    public void onCompanyChanged(String company) {
        this.company = company;
    }

    @Override
    public void onTagChanged(String tag) {
        this.tag = tag;
    }

    @Override
    public void onCategoryChanged(int category) {
        this.category = category;
    }

    @Override
    public void onStartDateSelected(int year, int month, int day) {
        startCreateProjectDateObj = new CreateProjectDateObj(day, month, year);
        view.populateStartDate(viewUtil.formatDateForDisplay(year, month, day));
    }

    @Override
    public void onEndDateSelected(int year, int month, int day) {
        endCreateProjectDateObj = new CreateProjectDateObj(day, month, year);
        view.populateEndDate(viewUtil.formatDateForDisplay(year, month, day));
    }

    @Override
    public void loadTags() {
        if (networkUtil.isNetworkConnected()) {
            addDisposable(model.provideTags(projectService)
                    .observeOn(mainThread())
                    .doOnSubscribe(__ -> view.showProgress())
                    .doOnTerminate(() -> view.hideProgress())
                    .subscribe(tagResponse -> onSuccess(tagResponse.getTags()), this::onError)
            );
        }
    }

    @Override
    protected void onSuccess(List tags) {
        d("Success! Tags loaded");
            view.showTags(tags);
    }

    @Override
    protected void onError(Throwable throwable) {
        Timber.d("Error saving project", Arrays.toString(throwable.getStackTrace()));
        view.onError(throwable);
    }

    private String endDate() {
        return viewUtil.formatForRequest(
                endCreateProjectDateObj.getYear(),
                endCreateProjectDateObj.getMonth(),
                endCreateProjectDateObj.getDay());
    }

    private String startDate() {
        return viewUtil.formatForRequest(
                startCreateProjectDateObj.getYear(),
                startCreateProjectDateObj.getMonth(),
                startCreateProjectDateObj.getDay());
    }

    @Override
    public void createProjectRequest() {
        ProjectRequest requestWrapper = new ProjectRequest(
                new Project.Builder(title,
                        description,
                        company,
                        tag,
                        category,
                        startDate(),
                        endDate())
                        .build());

        if (networkUtil.isNetworkConnected()) {
            addDisposable(model.createProject(requestWrapper, projectService)
                    .observeOn(mainThread())
                    .doOnSubscribe(__ -> view.showProgress())
                    .doOnTerminate(() -> view.hideProgress())
                    .subscribe(create -> onCreateProjectSuccess(), this::onError));
        }
    }

    private void onCreateProjectSuccess() {
        view.showCreateProjectSuccess();
    }
}
