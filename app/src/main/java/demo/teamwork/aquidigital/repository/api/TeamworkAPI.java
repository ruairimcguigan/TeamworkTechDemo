package demo.teamwork.aquidigital.repository.api;

import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectsResponse;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TasksResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TeamworkAPI {

    @GET("/projects.json")
    Observable<ProjectsResponse> getProjects();

    @GET("/tasks.json")
    Observable<TasksResponse> getTasks();

    @GET("/posts.json")
    Observable<TasksResponse> getMessages();

    @GET("/people.json")
    Observable<TasksResponse> getPeople();



}
