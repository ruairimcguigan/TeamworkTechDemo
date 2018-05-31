package demo.teamwork.aquidigital.taskdetail;

public interface TaskDetailContract {

    interface View { }

    interface Presenter{
        void attachView(View view);
    }

    interface Model { }
}
