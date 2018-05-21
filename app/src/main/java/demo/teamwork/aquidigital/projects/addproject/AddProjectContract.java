package demo.teamwork.aquidigital.projects.addproject;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.addprojectmodel.AddProject;

public interface AddProjectContract {

    interface View {

        void showProgress();

        void hideProgress();
    }

    interface Presenter{

        void attachView(View view);

    }

    interface Model {

    }
}
