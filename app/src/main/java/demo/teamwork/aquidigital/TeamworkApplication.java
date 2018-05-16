package demo.teamwork.aquidigital;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.singhajit.sherlock.core.Sherlock;
import com.squareup.leakcanary.LeakCanary;
import com.tspoon.traceur.Traceur;

import demo.teamwork.aquidigital.common.injection.AppComponent;
import demo.teamwork.aquidigital.common.injection.DaggerAppComponent;
import demo.teamwork.aquidigital.home.HomeModule;
import demo.teamwork.aquidigital.projects.ProjectsModule;
import demo.teamwork.aquidigital.common.injection.AppModule;
import demo.teamwork.aquidigital.repository.ApiModule;
import timber.log.Timber;

public class TeamworkApplication extends Application {
    private AppComponent appComponent;

//    public static TeamworkApplication get(Context context) {
//        return (TeamworkApplication) context.getApplicationContext();
//    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Stetho.initializeWithDefaults(this);
            LeakCanary.install(this);
            Sherlock.init(this);
            Traceur.enableLogging();

            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .homeModule(new HomeModule())
                    .projectsModule(new ProjectsModule())
                    .apiModule(new ApiModule(this, BuildConfig.BASE_URL))
                    .build();
        }
    }

    public  AppComponent getAppComponent() {
        return appComponent ;
    }

//    // Needed to replace the component with a test specific one
//    public void setComponent(AppComponent appComponent) {
//        this.appComponent = appComponent;
//    }
}
