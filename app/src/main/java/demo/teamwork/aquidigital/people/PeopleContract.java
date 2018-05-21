package demo.teamwork.aquidigital.people;


import java.util.List;

import demo.teamwork.aquidigital.repository.api.peoplemodel.PeopleItem;
import demo.teamwork.aquidigital.tasks.TaskContract;

public interface PeopleContract {

    interface View {

        void showPeople(List<PeopleItem> people);

        void setAdapter();

        void showProgress();

        void hideProgress();
    }

    interface Presenter{

        void attachView(PeopleContract.View view);

        void loadPeople();
    }

    interface Model {

    }
}
