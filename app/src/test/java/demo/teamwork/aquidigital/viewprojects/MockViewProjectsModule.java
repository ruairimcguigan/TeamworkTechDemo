package demo.teamwork.aquidigital.viewprojects;

import dagger.Module;
import dagger.Provides;

@Module
public class MockViewProjectsModule {

    @Provides
    ViewProjectsContract.Presenter providePeoplePresenter(ViewProjectsContract.Model model){
        return new ViewProjectsPresenter(model);
    }

    @Provides
    ViewProjectsContract.Model provideProjectModel(){
        return new ViewProjectsModel();
    }
}
