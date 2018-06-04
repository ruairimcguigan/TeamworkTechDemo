package demo.teamwork.aquidigital.common.injection;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.util.network.NetworkUtil;
import demo.teamwork.aquidigital.util.ui.ViewUtil;

import static demo.teamwork.aquidigital.util.Constants.PREF_FILE_NAME;

@Module()
public class AppModule {
    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return context;
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

    @Singleton
    @Provides
    ViewUtil provideViewFormatting(){
        return new ViewUtil();
    }
}
