package demo.teamwork.aquidigital.projects;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.apimodel.Project;
import io.reactivex.Single;

public class DefaultProjectsFacade implements ProjectsFacade {

    @Override
    public Single<List<Project>> getProjects() {
        return null;
    }
}
