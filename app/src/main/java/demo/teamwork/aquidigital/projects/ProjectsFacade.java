package demo.teamwork.aquidigital.projects;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.apimodel.Project;
import io.reactivex.Single;

public interface ProjectsFacade {

    Single<List<Project>> getProjects();
}
