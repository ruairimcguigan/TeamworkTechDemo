package demo.teamwork.aquidigital.common.injection;

import dagger.Module;
import demo.teamwork.aquidigital.repository.NetworkModule;

@Module(includes = { NetworkModule.class})
public class ApiModule {

//    @Provides
//    @Singleton
//    ChuckService provideChuckApi(Retrofit retrofit) {
//        return retrofit.create(ChuckService.class);
//    }
}
