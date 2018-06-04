package demo.teamwork.aquidigital.createproject;

import java.util.List;

import demo.teamwork.aquidigital.repository.api.addprojectmodel.TagItem;

public interface CreateProjectContract {

    interface View {

        void showProgress();

        void hideProgress();

        void showTags(List<TagItem> tags);

        void onError(Throwable throwable);

        void populateStartDate(String date);

        void populateEndDate(String date);

        void showCreateProjectSuccess();
    }

    interface Presenter{

        void attachView(View view);

        void loadTags();

        void onTitleChanged(String title);

        void onDescriptionChanged(String title);

        void onCompanyChanged(String title);

        void onTagChanged(String title);

        void onCategoryChanged(int title);

        void onStartDateSelected(int day, int month, int year);

        void onEndDateSelected(int day, int month, int year);

        void createProjectRequest();

    }

    interface Model {

    }
}
