package demo.teamwork.aquidigital.messages;

import javax.inject.Inject;

import demo.teamwork.aquidigital.tasks.TaskContract.Model;
import demo.teamwork.aquidigital.tasks.TaskContract.Presenter;

public class MessagesPresenter implements Presenter{

    private Model model;

    @Inject
    public MessagesPresenter(Model model) {
        this.model = model;
    }
}
