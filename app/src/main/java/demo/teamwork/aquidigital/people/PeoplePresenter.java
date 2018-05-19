package demo.teamwork.aquidigital.people;

import javax.inject.Inject;

import demo.teamwork.aquidigital.tasks.TaskContract.Model;
import demo.teamwork.aquidigital.tasks.TaskContract.Presenter;

public class PeoplePresenter implements Presenter{

    private Model model;

    @Inject
    public PeoplePresenter(Model model) {
        this.model = model;
    }
}
