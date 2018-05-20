package demo.teamwork.aquidigital.projects;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.apimodel.Project;

import static demo.teamwork.aquidigital.projects.ProjectsPresenter.*;


public class ProjectsContract {

    interface View {

        void showProjects(List<Project> projectList);

        void toggleProgress();

    }

    interface Presenter{

        void attachView(View view);

        void loadProjects();

    }

    interface Model {

        void persistToDataBase();
    }
}
