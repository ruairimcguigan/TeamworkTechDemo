package demo.teamwork.aquidigital.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class TeamworkRemoteDataStore implements TeamworkDataStore{
    @Inject
    Retrofit retrofit;

    @Inject
    TeamworkLocalDataStore localDataStore;

    @Override
    public Single getProjects() {
        return null;
//        Log.d("REMOTE", "Loaded from remote");
//        return retrofit.create(ProjectAPI.class)
//                .getProjects();
////                .doOnSuccess(TeamworkLocalDataStore::persistProjectsDataToDB);
    }

}
