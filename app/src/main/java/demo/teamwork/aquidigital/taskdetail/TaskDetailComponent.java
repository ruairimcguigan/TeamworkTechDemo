package demo.teamwork.aquidigital.taskdetail;

import demo.teamwork.aquidigital.tasks.ViewTasksPresenter;

/**
 * Injects dependencies in the TaskDetail component
 */
public interface TaskDetailComponent {

    void inject(TaskDetailFragment fragment);

    void inject(ViewTasksPresenter presenter);
}
