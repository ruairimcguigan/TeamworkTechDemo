package demo.teamwork.aquidigital.repository;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import javax.inject.Inject;

import io.reactivex.Single;

public class  Repository implements TeamworkDataStore{

    private TeamworkLocalDataStore mAppLocalDataStore;
    private TeamworkRemoteDataStore mAppRemoteDataStore;


    @Inject
    public Repository(TeamworkLocalDataStore mAppLocalDataStore, TeamworkRemoteDataStore mAppRemoteDataStore) {
        this.mAppLocalDataStore = mAppLocalDataStore;
        this.mAppRemoteDataStore = mAppRemoteDataStore;
    }

    @Override
    public Single getProjects() {
        return Single.concat(mAppLocalDataStore.getProjects(), mAppRemoteDataStore.getProjects())
                .first((Function<List, Boolean>) Objects::nonNull);
    }
}
