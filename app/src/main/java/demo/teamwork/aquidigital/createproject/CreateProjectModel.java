package demo.teamwork.aquidigital.createproject;

import demo.teamwork.aquidigital.createproject.CreateProjectContract.Model;
import demo.teamwork.aquidigital.createproject.models.CreateProjectResult;
import demo.teamwork.aquidigital.createproject.models.ProjectRequest;
import demo.teamwork.aquidigital.createproject.models.TagResponse;
import demo.teamwork.aquidigital.repository.api.TeamworkApi;
import io.reactivex.Observable;

class CreateProjectModel implements Model {

    @Override
    public Observable<CreateProjectResult> createProject(ProjectRequest project, TeamworkApi api) {
        return api.createProject(project);
    }

    @Override
    public Observable<TagResponse> provideTags(TeamworkApi api) {
        return api.getTags();
    }
}
