package demo.teamwork.aquidigital.common.injection;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.util.network.NetworkUtil;

import static demo.teamwork.aquidigital.util.Constants.PREF_FILE_NAME;

@Module()
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return application;
    }

    @Singleton
    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Singleton
    @Provides
    @ApplicationContext
    SharedPreferences provideSharedPreference(@ApplicationContext Context context) {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    NetworkUtil provideNetworkUtil(Context context){
        return new NetworkUtil(context);
    }
}
