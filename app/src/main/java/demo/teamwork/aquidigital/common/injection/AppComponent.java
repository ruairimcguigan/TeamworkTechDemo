package demo.teamwork.aquidigital.common.injection;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import demo.teamwork.aquidigital.common.injection.ApplicationContext;
import demo.teamwork.aquidigital.common.injection.AppModule;
import demo.teamwork.aquidigital.projects.service.ProjectsApi;
import demo.teamwork.aquidigital.repository.TeamworkRemoteDataStore;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ApplicationContext
    Context context();

    Application application();

    ProjectsApi teamworkService();

    void inject(TeamworkRemoteDataStore appRemoteDataStore);

}
