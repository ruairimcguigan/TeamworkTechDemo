package demo.teamwork.aquidigital.tasks.taskdetail;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;

public interface TaskDetailContract {

    interface View {

    }

    interface Presenter{

        void attachView(View view);

    }

    interface Model {

    }
}
