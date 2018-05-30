package demo.teamwork.aquidigital.repository.api;

import demo.teamwork.aquidigital.repository.api.addprojectmodel.ProjectRequest;
import demo.teamwork.aquidigital.repository.api.addprojectmodel.TagResponse;
import demo.teamwork.aquidigital.repository.api.messagesmodel.MessagesResponse;
import demo.teamwork.aquidigital.repository.api.peoplemodel.PeopleResponse;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectsResponse;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TasksResponse;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TeamworkAPI {

    @GET("/projects.json")
    Observable<ProjectsResponse> getProjects();

    @GET("/tasks.json")
    Observable<TasksResponse> getTasks();

    @GET("/posts.json")
    Observable<MessagesResponse> getMessages();

    @GET("/people.json")
    Observable<PeopleResponse> getPeople();

    @GET("/tags.json")
    Observable<TagResponse> getTags();

    @Headers("Content-Type: application/json")
    @POST("/projects.json")
    Observable<ProjectRequest> createProject(@Body ProjectRequest project);


}
