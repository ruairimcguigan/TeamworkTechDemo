package demo.teamwork.aquidigital.tasks;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;

public interface TaskContract {

    interface View {

        void showTasks(List<TodoItemsItem> taskList);

        void setAdapter();

        void showProgress();

        void hideProgress();
    }

    interface Presenter{

        void attachView(View view);

        void loadTasks();
    }

    interface Model {

    }
}
