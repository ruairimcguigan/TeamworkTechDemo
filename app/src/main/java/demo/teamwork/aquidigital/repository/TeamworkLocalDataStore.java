package demo.teamwork.aquidigital.repository;

import demo.teamwork.aquidigital.repository.api.apimodel.Response;
import io.reactivex.Single;

public class TeamworkLocalDataStore implements TeamworkDataStore {

    @Override
    public Single getProjects() {
        return null;
    }

    public static void persistProjectsDataToDB(Response response) {
        // TODO: 14/05/2018 to be implemented
    }
}
