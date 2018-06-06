package demo.teamwork.aquidigital.presenters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import demo.teamwork.aquidigital.common.BaseTests;
import demo.teamwork.aquidigital.repository.api.TeamworkApi;
import demo.teamwork.aquidigital.util.TestData;
import demo.teamwork.aquidigital.util.network.NetworkUtil;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsContract.Model;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsContract.View;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsPresenter;
import demo.teamwork.aquidigital.viewprojects.model.ProjectsResponse;
import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ViewProjectsPresenterTest extends BaseTests{

    @Mock private TeamworkApi api;
    @Mock private NetworkUtil networkUtil;

    @Mock private View view;
    @Mock private Model model;

    @InjectMocks
    private ViewProjectsPresenter presenter;

    private ProjectsResponse response;

    @Before
    public void setUp() {
        response = TestData.getProjectResponse();

        presenter.attachView(view);
    }

    @Test
    public void onStart_UserShouldBeAbleToViewAllActiveProjects() {

        // given
        when(model.provideProjects(api)).thenReturn(Observable.just(response));
        when(networkUtil.isNetworkConnected()).thenReturn(true);

        // when
        presenter.loadProjects();

        // then
        verify(view).showProgress();
        verify(view).hideProgress();
        verify(view).showProjects(response.getProjects());
    }

    @Test
    public void ifLoadProjectsFail_DisplayErrorMessageSnackbar() {

        // given
        Exception exception = new Exception();
        when(networkUtil.isNetworkConnected()).thenReturn(true);

        when(model.provideProjects(api)).thenReturn(Observable.error(exception));

        // when
        presenter.loadProjects();

        // then
        verify(view).onError(exception);
    }
}