package demo.teamwork.aquidigital.taskdetail;

import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.repository.api.TeamworkAPI;

import static demo.teamwork.aquidigital.taskdetail.TaskDetailContract.*;

public class TaskDetailPresenter extends BasePresenter implements Presenter {

    @Inject
    TeamworkAPI projectService;

    private View view;
    private Model model;

    @Inject
    public TaskDetailPresenter(Model model) {
        this.model = model;
    }

    @Override
    public void attachView(View view) {
        if (view != null) {
            this.view = view;
        }
    }

    @Override
    protected void onSuccess(List tasks) { }

    @Override
    protected void onError(Throwable throwable) { }
}
