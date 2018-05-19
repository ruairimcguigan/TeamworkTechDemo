package demo.teamwork.aquidigital.tasks;

import javax.inject.Inject;

import demo.teamwork.aquidigital.tasks.TaskContract.Model;
import demo.teamwork.aquidigital.tasks.TaskContract.Presenter;

public class TaskPresenter implements Presenter{

    private Model model;

    @Inject
    public TaskPresenter(Model model) {
        this.model = model;
    }
}
