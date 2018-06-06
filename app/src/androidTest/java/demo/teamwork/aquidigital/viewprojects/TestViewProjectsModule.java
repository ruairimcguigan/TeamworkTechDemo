package demo.teamwork.aquidigital.viewprojects;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.repository.api.TeamworkApi;

@Module
public class TestViewProjectsModule {

    @Provides
    ViewProjectsContract.Presenter providePeoplePresenter(ViewProjectsContract.Model model){
        return new ViewProjectsPresenter(model);
    }

    @Provides
    ViewProjectsContract.Model provideProjectModel(TeamworkApi api){
        return new ViewProjectsModel(api);
    }
}
