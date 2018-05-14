package demo.teamwork.aquidigital.projects.service;

import demo.teamwork.aquidigital.repository.model.Response;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface ProjectsService {

    @GET("/projects.json")
    Single<Response> getProjects();
}
