package demo.teamwork.aquidigital.viewprojects;

import demo.teamwork.aquidigital.repository.api.TeamworkApi;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsContract.Model;
import demo.teamwork.aquidigital.viewprojects.model.ProjectsResponse;
import io.reactivex.Observable;

public class ViewProjectsModel implements Model {

    @Override
    public Observable<ProjectsResponse> provideProjects(TeamworkApi api) {
        return api.getProjects();
    }
}
