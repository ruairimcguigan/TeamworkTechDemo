package demo.teamwork.aquidigital.projects.addproject;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.addprojectmodel.AddProject;
import demo.teamwork.aquidigital.repository.api.addprojectmodel.TagsItem;

public interface AddProjectContract {

    interface View {

        void showProgress();

        void hideProgress();

        void showTags(List<TagsItem> tags);

        void populateStartDate(String date);

        void populateEndDate(String date);
    }

    interface Presenter{

        void attachView(View view);

        void loadTags();

        void onStartDateSelected(int day, int month, int year);

        void onEndDateSelected(int day, int month, int year);

    }

    interface Model {

    }
}
