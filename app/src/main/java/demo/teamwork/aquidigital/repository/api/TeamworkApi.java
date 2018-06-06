package demo.teamwork.aquidigital.repository.api;

import demo.teamwork.aquidigital.createproject.models.CreateProjectResult;
import demo.teamwork.aquidigital.createproject.models.ProjectRequest;
import demo.teamwork.aquidigital.createproject.models.TagResponse;
import demo.teamwork.aquidigital.people.models.PeopleResponse;
import demo.teamwork.aquidigital.tasks.models.TasksResponse;
import demo.teamwork.aquidigital.viewprojects.model.ProjectsResponse;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TeamworkApi {

    @GET("/projects.json")
    Observable<ProjectsResponse> getProjects();

    @GET("/tasks.json")
    Observable<TasksResponse> getTasks();

    @GET("/people.json")
    Observable<PeopleResponse> getPeople();

    @GET("/tags.json")
    Observable<TagResponse> getTags();

    @Headers("Content-Type: application/json")
    @POST("/projects.json")
    Observable<CreateProjectResult> createProject(@Body ProjectRequest project);

}