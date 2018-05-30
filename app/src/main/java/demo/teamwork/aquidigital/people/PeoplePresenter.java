package demo.teamwork.aquidigital.people;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.people.PeopleContract.View;
import demo.teamwork.aquidigital.repository.api.TeamworkAPI;
import timber.log.Timber;

import static io.reactivex.android.schedulers.AndroidSchedulers.*;
import static timber.log.Timber.d;

public class PeoplePresenter extends BasePresenter implements PeopleContract.Presenter {

    @Inject
    TeamworkAPI projectService;

    private PeopleContract.View view;
    private PeopleContract.Model model;

    @Inject
    PeoplePresenter(PeopleContract.Model model) {
        this.model = model;
    }

    @Override
    public void attachView(View view) {
        if (view != null) {
            this.view = view;
        }
    }

    @Override
    public void loadPeople() {
        addDisposable(projectService
                .getPeople()
                .observeOn(mainThread())
                .doOnSubscribe(__ -> view.showProgress())
                .doOnError(this::onError)
                .doOnTerminate(() -> view.hideProgress())
                .subscribe(peopleResponse -> onSuccess(peopleResponse.getPeople())));
    }

    @Override
    protected void onSuccess(List people) {
        d("Success! People received");
        if (people != null && people.size() > 0) {
            view.showPeople(people);
        }
    }

    @Override
    protected void onError(Throwable throwable) {
        Timber.d("Error retrieving people", Arrays.toString(throwable.getStackTrace()));
    }
}
