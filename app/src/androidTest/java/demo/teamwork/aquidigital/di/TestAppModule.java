package demo.teamwork.aquidigital.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.common.injection.ApplicationContext;
import demo.teamwork.aquidigital.util.network.NetworkUtil;

import static demo.teamwork.aquidigital.util.Constants.PREF_FILE_NAME;

@Module
public class TestAppModule {

    private final Application application;

    public TestAppModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    SharedPreferences provideSharedPreference(@ApplicationContext Context context) {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    NetworkUtil provideNetworkUtil(Context context){
        return new NetworkUtil(context);
    }
}
