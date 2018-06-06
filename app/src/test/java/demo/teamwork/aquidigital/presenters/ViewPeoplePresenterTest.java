package demo.teamwork.aquidigital.presenters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import demo.teamwork.aquidigital.common.BaseTests;
import demo.teamwork.aquidigital.people.ViewPeopleContract.Model;
import demo.teamwork.aquidigital.people.ViewPeopleContract.View;
import demo.teamwork.aquidigital.people.ViewPeoplePresenter;
import demo.teamwork.aquidigital.people.models.PeopleResponse;
import demo.teamwork.aquidigital.repository.api.TeamworkApi;
import demo.teamwork.aquidigital.util.TestData;
import demo.teamwork.aquidigital.util.network.NetworkUtil;
import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ViewPeoplePresenterTest extends BaseTests {

    @Mock private TeamworkApi api;
    @Mock private NetworkUtil networkUtil;

    @Mock private View view;
    @Mock private Model model;

    @InjectMocks
    private ViewPeoplePresenter presenter;

    private PeopleResponse peopleResponse;

    @Before
    public void setUp(){
        peopleResponse = TestData.getPeopleResponse();
        presenter.attachView(view);
    }

    @Test
    public void onStart_UserShouldBeAbleToViewAllActiveProjects() {

        // given
        when(model.providePeople(api)).thenReturn(Observable.just(peopleResponse));
        when(networkUtil.isNetworkConnected()).thenReturn(true);

        // when
        presenter.loadPeople();

        // then
        verify(view).showProgress();
        verify(view).hideProgress();
        verify(view).showPeople(peopleResponse.getPeople());
    }

    @Test
    public void onLoadPeopleFail_DisplayErrorMessageSnackbar() {

        // given
        Exception exception = new Exception();
        when(networkUtil.isNetworkConnected()).thenReturn(true);
        when(model.providePeople(api)).thenReturn(Observable.error(exception));


        // when
        presenter.loadPeople();

        // then
        verify(view).onError(exception);
    }
}