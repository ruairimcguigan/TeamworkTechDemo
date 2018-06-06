package demo.teamwork.aquidigital.tasks;


import demo.teamwork.aquidigital.repository.api.TeamworkApi;
import demo.teamwork.aquidigital.tasks.ViewTasksContract.Model;
import io.reactivex.Observable;

public class ViewTasksModel implements Model{

    @Override
    public Observable provideTasks(TeamworkApi api) {
        return api.getTasks();
    }
}
