package demo.teamwork.aquidigital.repository;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.BuildConfig;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.repository.api.AuthenticationInterceptor;
import demo.teamwork.aquidigital.repository.api.ProjectAPI;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static demo.teamwork.aquidigital.BuildConfig.BASE_URL;
import static okhttp3.Credentials.basic;

@Module
public class ApiModule {

    @Inject
    TeamworkApplication application;

    private final Context context;
    private final String baseUrl;

    public ApiModule(final Context context, String baseUrl) {
        this.context = context;
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Cache provideCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    AuthenticationInterceptor provideAuthenticationInterceptor(String token) {
        return new AuthenticationInterceptor(token);
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy. LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(provideLoggingInterceptor());
        client.addInterceptor(provideAuthenticationInterceptor(basic(BuildConfig.API_KEY, "X")));
        client.cache(cache);
        return client.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(String baseUrl, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public ProjectAPI provideProjectApiService(Cache cache) {
        return provideRetrofit(BASE_URL, provideClient(cache)).create(ProjectAPI.class);
    }

    @Provides
    @Singleton
    TeamworkLocalDataStore providesAppLocalDataStore(Application context) {
        return new TeamworkLocalDataStore();
    }

    @Provides
    @Singleton
    TeamworkRemoteDataStore providesRepository() {
        return new TeamworkRemoteDataStore();
    }
}
