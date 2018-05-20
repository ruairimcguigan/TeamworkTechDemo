package demo.teamwork.aquidigital.tasks;

import java.util.List;

import demo.teamwork.aquidigital.projects.ProjectsContract;
import demo.teamwork.aquidigital.repository.Item;
import demo.teamwork.aquidigital.repository.api.projectsmodel.Project;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;

public interface TaskContract {

    interface View {

        void setProjectName(String projectName);

        void showTasks(List<TodoItemsItem> taskList);

        void setAdapter();
    }

    interface Presenter{

        void attachView(View view);

        void loadTasks();
    }

    interface Model {

    }
}
