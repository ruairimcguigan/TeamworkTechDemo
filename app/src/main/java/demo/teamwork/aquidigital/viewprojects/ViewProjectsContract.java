package demo.teamwork.aquidigital.viewprojects;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectItem;


public class ViewProjectsContract {

    public interface View {

        void setAdapter();

        void showProjects(List<ProjectItem> projectItemList);

        void showProgress();

        void hideProgress();

        void onError(Throwable throwable);
    }

    interface Presenter{

        void attachView(View view);

        void loadProjects();

    }

    public interface Model {

        void cacheForOfflineViewing();
    }
}
