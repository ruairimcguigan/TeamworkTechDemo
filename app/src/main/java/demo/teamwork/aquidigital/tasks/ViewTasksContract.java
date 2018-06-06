package demo.teamwork.aquidigital.tasks;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.TeamworkApi;
import demo.teamwork.aquidigital.tasks.models.TasksResponse;
import demo.teamwork.aquidigital.tasks.models.TodoItemsItem;
import io.reactivex.Observable;

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

        Observable<TasksResponse> provideTasks(TeamworkApi projectService);
    }
}
