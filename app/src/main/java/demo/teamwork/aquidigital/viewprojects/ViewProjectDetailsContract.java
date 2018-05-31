package demo.teamwork.aquidigital.viewprojects;

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
