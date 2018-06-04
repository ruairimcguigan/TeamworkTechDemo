package demo.teamwork.aquidigital.people;


import java.util.List;

import demo.teamwork.aquidigital.repository.api.peoplemodel.PeopleItem;

public interface ViewPeopleContract {

    interface View {

        void showPeople(List<PeopleItem> people);

        void onError(Throwable throwable);

        void setAdapter();

        void showProgress();

        void hideProgress();
    }

    interface Presenter{

        void attachView(ViewPeopleContract.View view);

        void loadPeople();
    }

    interface Model {

    }
}
