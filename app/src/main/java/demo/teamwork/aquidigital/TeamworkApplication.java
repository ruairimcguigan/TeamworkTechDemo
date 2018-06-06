package demo.teamwork.aquidigital;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;
import com.singhajit.sherlock.core.Sherlock;
import com.squareup.leakcanary.LeakCanary;
import com.tspoon.traceur.Traceur;

import demo.teamwork.aquidigital.common.injection.AppComponent;
import demo.teamwork.aquidigital.common.injection.AppModule;
import demo.teamwork.aquidigital.common.injection.DaggerAppComponent;
import demo.teamwork.aquidigital.repository.api.ApiModule;
import demo.teamwork.aquidigital.tasks.ViewTasksModule;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsModule;
import timber.log.Timber;

public class TeamworkApplication extends Application {

    private String API_KEY="twp_k9ejP88LcuojHjmFkUFuYIUNYalg";
    private String BASE_URL="https://yat.teamwork.com";

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Fresco.initialize(this);
            Timber.plant(new Timber.DebugTree());
            Stetho.initializeWithDefaults(this);
            LeakCanary.install(this);
            Sherlock.init(this);
            Traceur.enableLogging();

            initDagger();
        }
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .viewTasksModule(new ViewTasksModule())
                .viewProjectsModule(new ViewProjectsModule())
                .apiModule(new ApiModule(this, BASE_URL))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
