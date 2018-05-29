package demo.teamwork.aquidigital.common.injection;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.tasks.TasksFragment;
import demo.teamwork.aquidigital.projects.ProjectsActivity;
import demo.teamwork.aquidigital.repository.TeamworkDataStore;
import demo.teamwork.aquidigital.repository.TeamworkRemoteDataStore;

import static demo.teamwork.aquidigital.util.Constants.PREF_FILE_NAME;

@Module()
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    TasksFragment provideTasksFragment(){
        return new TasksFragment();
    }

    @Provides
    ProjectsActivity provideProjectsActivity(){
        return new ProjectsActivity();
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    @ApplicationContext
    SharedPreferences provideSharedPreference(@ApplicationContext Context context) {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @ApplicationContext
    TeamworkDataStore provideRepository(){
        return new TeamworkRemoteDataStore();
    }
}
