package demo.teamwork.aquidigital.people;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.common.base.BasePresenter;
import demo.teamwork.aquidigital.people.ViewPeopleContract.Model;
import demo.teamwork.aquidigital.people.ViewPeopleContract.View;
import demo.teamwork.aquidigital.repository.api.TeamworkAPI;
import demo.teamwork.aquidigital.util.network.NetworkUtil;
import timber.log.Timber;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static timber.log.Timber.d;

public class ViewPeoplePresenter extends BasePresenter implements ViewPeopleContract.Presenter {

    @Inject TeamworkAPI projectService;
    @Inject NetworkUtil networkUtil;

    private View view;
    private Model model;

    @Inject
    ViewPeoplePresenter(Model model) {
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
        if (networkUtil.isNetworkConnected()) {
            addDisposable(projectService
                    .getPeople()
                    .observeOn(mainThread())
                    .doOnSubscribe(__ -> view.showProgress())
                    .doOnTerminate(() -> view.hideProgress())
                    .subscribe(peopleResponse
                            -> onSuccess(peopleResponse.getPeople()), this::onError));
        }
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
        view.onError(throwable);
    }
}
