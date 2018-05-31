package demo.teamwork.aquidigital.tasks;

/**
 * Injects dependencies in the Task component
 */
public interface TaskComponent {

    void inject (TasksFragment fragment);

    void inject (TaskPresenter presenter);

}
