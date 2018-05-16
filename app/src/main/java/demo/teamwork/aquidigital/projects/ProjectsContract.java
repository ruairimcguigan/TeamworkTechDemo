package demo.teamwork.aquidigital.projects;

import java.util.List;

import demo.teamwork.aquidigital.repository.apimodel.Project;

public class ProjectsContract {

    interface View {

        void showProjects(List<Project> projectList);

        void toggleProgress();
    }

    interface Presenter{

        void attachView(View view);

        void getProjects();
    }

    interface Model {

        void persistToDataBase();
    }
}
