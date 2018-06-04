package demo.teamwork.aquidigital.tasks;

/**
 * Injects dependencies in the Task component
 */
public interface ViewTasksComponent {

    void inject (ViewTasksFragment fragment);

    void inject (ViewTasksPresenter presenter);

}
