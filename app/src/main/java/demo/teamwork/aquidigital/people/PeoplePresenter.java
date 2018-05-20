package demo.teamwork.aquidigital.people;

import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.tasks.TaskContract;
import demo.teamwork.aquidigital.tasks.TaskContract.Model;
import demo.teamwork.aquidigital.tasks.TaskContract.Presenter;

public class PeoplePresenter extends BasePresenter implements Presenter{

    private Model model;

    @Inject
    public PeoplePresenter(Model model) {
        this.model = model;
    }

    @Override
    public void attachView(TaskContract.View view) {

    }

    @Override
    public void loadTasks() {

    }

    @Override
    protected void onSuccess(List dataList) {

    }

    @Override
    protected void onError(Throwable throwable) {

    }
}
