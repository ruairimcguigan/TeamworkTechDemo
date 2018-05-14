package demo.teamwork.aquidigital.common.injection.module;

import dagger.Module;

@Module(includes = {NetworkModule.class})
public class ApiModule {

//    @Provides
//    @Singleton
//    ChuckService provideChuckApi(Retrofit retrofit) {
//        return retrofit.create(ChuckService.class);
//    }
}
