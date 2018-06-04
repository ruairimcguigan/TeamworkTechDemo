package demo.teamwork.aquidigital.viewprojectdetails;

public interface ViewProjectDetailsContract {

    interface View {

        void showProgress();

        void hideProgress();

    }

    interface Presenter{

        default void attachView(ViewProjectDetailsContract.View view) { }

    }

    interface Model {

    }
}
