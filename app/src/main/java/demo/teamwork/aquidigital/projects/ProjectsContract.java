package demo.teamwork.aquidigital.projects;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectItem;


class ProjectsContract {

    interface View {

        void setAdapter();

        void showProjects(List<ProjectItem> projectItemList);

        void showProgress();

        void hideProgress();

    }

    interface Presenter{

        void attachView(View view);

        void loadProjects();

    }

    interface Model {

        void cacheForOfflineViewing();
    }
}
