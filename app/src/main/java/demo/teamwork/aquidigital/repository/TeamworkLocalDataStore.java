package demo.teamwork.aquidigital.repository;

import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectsResponse;
import io.reactivex.Single;

public class TeamworkLocalDataStore implements TeamworkDataStore {

    @Override
    public Single getProjects() {
        return null;
    }

    public static void persistProjectsDataToDB(ProjectsResponse projectsResponse) {
        // TODO: 14/05/2018 to be implemented
    }
}
