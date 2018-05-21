package demo.teamwork.aquidigital.projects.addproject;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.projects.addproject.AddProjectContract.Model;
import demo.teamwork.aquidigital.projects.addproject.AddProjectContract.Presenter;
import demo.teamwork.aquidigital.projects.addproject.AddProjectContract.View;
import demo.teamwork.aquidigital.repository.api.TeamworkAPI;
import timber.log.Timber;

import static timber.log.Timber.d;

public class AddProjectPresenter extends BasePresenter implements Presenter {

    @Inject
    TeamworkAPI projectService;

    private View view;
    private Model model;

    @Inject
    public AddProjectPresenter(Model model) {
        this.model = model;
    }

    @Override
    public void attachView(View view) {
        if (view != null) {
            this.view = view;
        }
    }


    @Override
    protected void onSuccess(List tasks) {
        d("Success! Project saved");


    }

    @Override
    protected void onError(Throwable throwable) {
        Timber.d("Error saving project", Arrays.toString(throwable.getStackTrace()));
    }
}
