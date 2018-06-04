package demo.teamwork.aquidigital.viewprojectdetails;

import javax.inject.Inject;

import demo.teamwork.aquidigital.viewprojectdetails.ViewProjectDetailsContract.Presenter;

import static demo.teamwork.aquidigital.viewprojectdetails.ViewProjectDetailsContract.*;

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
