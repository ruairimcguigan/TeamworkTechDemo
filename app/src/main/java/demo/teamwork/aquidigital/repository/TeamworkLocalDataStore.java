package demo.teamwork.aquidigital.repository;

import javax.inject.Inject;

import demo.teamwork.aquidigital.repository.model.Response;
import io.reactivex.Single;

public class TeamworkLocalDataStore implements TeamworkDataStore {


    @Inject
    public TeamworkLocalDataStore() {
    }

    @Override
    public Single getProjects() {
        return null;
    }

    public static void persistProjectsDataToDB(Response response) {
        // TODO: 14/05/2018 to be implemented
    }
}
