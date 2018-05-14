package demo.teamwork.aquidigital.repository;

import android.util.Log;

import javax.inject.Inject;

import demo.teamwork.aquidigital.projects.service.ProjectsService;
import io.reactivex.Single;
import retrofit2.Retrofit;

public class TeamworkRemoteDataStore implements TeamworkDataStore{
    @Inject
    Retrofit retrofit;

    @Inject
    TeamworkLocalDataStore localDataStore;

    @Inject
    public TeamworkRemoteDataStore() {
    }

    @Override
    public Single getProjects() {
        Log.d("REMOTE", "Loaded from remote");
        return retrofit.create(ProjectsService.class)
                .getProjects()
                .doOnSuccess(TeamworkLocalDataStore::persistProjectsDataToDB);
    }

}
