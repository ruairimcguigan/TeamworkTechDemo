package demo.teamwork.aquidigital.tasks;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;

public interface ViewTasksContract {

    interface View {

        void showTasks(List<TodoItemsItem> taskList);

        void onError(Throwable throwable);

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
