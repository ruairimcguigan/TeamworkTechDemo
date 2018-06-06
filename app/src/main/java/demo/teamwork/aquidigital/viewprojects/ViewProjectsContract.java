package demo.teamwork.aquidigital.viewprojects;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.TeamworkApi;
import demo.teamwork.aquidigital.viewprojects.model.ProjectItem;
import demo.teamwork.aquidigital.viewprojects.model.ProjectsResponse;
import io.reactivex.Observable;


public class ViewProjectsContract {

    public interface View {

        void setAdapter();

        void showProjects(List<ProjectItem> projectItemList);

        void showProgress();

        void hideProgress();

        void onError(Throwable throwable);
    }

    interface Presenter {

        void attachView(View view);

        void loadProjects();

    }

    public interface Model {

        Observable<ProjectsResponse> provideProjects(TeamworkApi api);
    }
}
