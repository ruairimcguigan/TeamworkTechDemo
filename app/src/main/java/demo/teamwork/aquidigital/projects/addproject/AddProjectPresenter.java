package demo.teamwork.aquidigital.projects.addproject;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.projects.addproject.AddProjectContract.Model;
import demo.teamwork.aquidigital.projects.addproject.AddProjectContract.Presenter;
import demo.teamwork.aquidigital.projects.addproject.AddProjectContract.View;
import demo.teamwork.aquidigital.repository.api.TeamworkAPI;
import demo.teamwork.aquidigital.util.ui.ViewUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
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
                .subscribe(tagResponse -> onSuccess(tagResponse.getTags())));
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
    public void onStartDateSelected(int day, int month, int year) {
        view.populateStartDate(formatDateForDisplay(day, month, year));
    }

    private LocalDate convertToLocalDate(int day, int month, int year){
        return of(year, month, day);
    }

    @Override
    public void onEndDateSelected(int day, int month, int year) {
        view.populateEndDate(formatDateForDisplay(day, month, year));
    }


}
