package demo.teamwork.aquidigital;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.singhajit.sherlock.core.Sherlock;
import com.squareup.leakcanary.LeakCanary;
import com.tspoon.traceur.Traceur;

import demo.teamwork.aquidigital.common.injection.AppComponent;
import demo.teamwork.aquidigital.common.injection.DaggerAppComponent;
import demo.teamwork.aquidigital.repository.NetworkModule;
import demo.teamwork.aquidigital.common.injection.AppModule;
import timber.log.Timber;

public class TeamworkApplication extends Application {
    private AppComponent appComponent;

    public static TeamworkApplication get(Context context) {
        return (TeamworkApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Stetho.initializeWithDefaults(this);
            LeakCanary.install(this);
            Sherlock.init(this);
            Traceur.enableLogging();
        }
    }

    public AppComponent getComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .networkModule(new NetworkModule(this, BuildConfig.BASE_URL))
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }

    public static AppComponent getAppComponent() {
        return getAppComponent();
    }

    // Needed to replace the component with a test specific one
    public void setComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
