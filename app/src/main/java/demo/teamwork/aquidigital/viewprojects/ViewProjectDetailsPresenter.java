package demo.teamwork.aquidigital.viewprojects;

import javax.inject.Inject;

import demo.teamwork.aquidigital.viewprojects.ViewProjectDetailsContract.Presenter;

import static demo.teamwork.aquidigital.viewprojects.ViewProjectDetailsContract.*;

public class ViewProjectDetailsPresenter implements Presenter{

    private View view;
    private final Model model;

    @Inject
    public ViewProjectDetailsPresenter(Model projectModel) {
        this.model = projectModel;
    }

    @Override
    public void attachView(View view) { }
}
