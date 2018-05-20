package demo.teamwork.aquidigital.projects;

import java.util.List;

import demo.teamwork.aquidigital.repository.Item;
import demo.teamwork.aquidigital.repository.api.projectsmodel.Project;


public class ProjectsContract {

    interface View {

        void setAdapter();

        void showProjects(List<Project> projectList);

    }

    interface Presenter{

        void attachView(View view);

        void loadProjects();

    }

    interface Model {

        void persistToDataBase();
    }
}
