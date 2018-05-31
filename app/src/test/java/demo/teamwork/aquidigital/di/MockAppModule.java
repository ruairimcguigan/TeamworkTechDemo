package demo.teamwork.aquidigital.di;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.common.injection.ApplicationContext;

import static demo.teamwork.aquidigital.util.Constants.PREF_FILE_NAME;

@Module
public class MockAppModule {

    private final Context context;

    public MockAppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext(){
        return context;
    }

    @Provides
    SharedPreferences provideSharedPreference(@ApplicationContext Context context) {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }
}
