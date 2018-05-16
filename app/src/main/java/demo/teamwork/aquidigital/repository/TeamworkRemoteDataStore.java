package demo.teamwork.aquidigital.repository;

import android.util.Log;

import javax.inject.Inject;

import demo.teamwork.aquidigital.repository.api.ProjectAPI;
import io.reactivex.Single;
import retrofit2.Retrofit;

public class TeamworkRemoteDataStore implements TeamworkDataStore{
    @Inject
    Retrofit retrofit;

    @Inject
    TeamworkLocalDataStore localDataStore;

    @Override
    public Single getProjects() {
        Log.d("REMOTE", "Loaded from remote");
        return retrofit.create(ProjectAPI.class)
                .getProjects();
//                .doOnSuccess(TeamworkLocalDataStore::persistProjectsDataToDB);
    }

}
