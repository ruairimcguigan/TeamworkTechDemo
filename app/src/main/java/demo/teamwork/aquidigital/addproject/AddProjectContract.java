package demo.teamwork.aquidigital.addproject;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.addprojectmodel.TagsItem;

public interface AddProjectContract {

    interface View {

        void showProgress();

        void hideProgress();

        void showTags(List<TagsItem> tags);

        void populateStartDate(String date);

        void populateEndDate(String date);

        void showCreateProjectSuccess();
    }

    interface Presenter{

        void attachView(View view);

        void loadTags();

        void onStartDateSelected(int day, int month, int year);

        void onEndDateSelected(int day, int month, int year);

        void onProjectFormComplete(String title, String description, String company, String tags, int category, String startDate, String endDate);

    }

    interface Model {

    }
}
