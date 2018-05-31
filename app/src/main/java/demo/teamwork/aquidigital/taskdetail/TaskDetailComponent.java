package demo.teamwork.aquidigital.taskdetail;

import demo.teamwork.aquidigital.tasks.TaskPresenter;

/**
 * Injects dependencies in the TaskDetail component
 */
public interface TaskDetailComponent {

    void inject(TaskDetailFragment fragment);

    void inject(TaskPresenter presenter);
}
