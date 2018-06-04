package demo.teamwork.aquidigital.messages;

import javax.inject.Inject;

import demo.teamwork.aquidigital.tasks.ViewTasksContract;
import demo.teamwork.aquidigital.tasks.ViewTasksContract.Model;
import demo.teamwork.aquidigital.tasks.ViewTasksContract.Presenter;

public class MessagesPresenter implements Presenter{

    private Model model;

    @Inject
    public MessagesPresenter(Model model) {
        this.model = model;
    }

    @Override
    public void attachView(ViewTasksContract.View view) {

    }

    @Override
    public void loadTasks() {

    }
}
