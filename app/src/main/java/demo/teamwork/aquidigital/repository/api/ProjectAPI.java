package demo.teamwork.aquidigital.repository.api;

import demo.teamwork.aquidigital.repository.api.apimodel.Response;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ProjectAPI {

    @GET("/projects.json")
    Observable<Response> getProjects();
}
