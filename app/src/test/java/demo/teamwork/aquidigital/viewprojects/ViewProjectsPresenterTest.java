package demo.teamwork.aquidigital.viewprojects;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import demo.teamwork.aquidigital.repository.api.TeamworkAPI;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectItem;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectsResponse;
import demo.teamwork.aquidigital.util.RxSchedulersOverrideRule;
import demo.teamwork.aquidigital.util.TestData;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsContract.Model;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsContract.View;

import static io.reactivex.Observable.just;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ViewProjectsPresenterTest {

    @Mock
    TeamworkAPI teamworkAPI;

    @Rule
    public final RxSchedulersOverrideRule overrideSchedulersRule = new RxSchedulersOverrideRule();

    @Mock private View view;
    @Mock private Model model;

    @InjectMocks
    private ViewProjectsPresenter presenter;

//    private Presenter presenter;
    private ProjectItem project;
    private ProjectsResponse response;

    @Before
    public void setUp() {
        project = TestData.buildProjectItem();
        response = TestData.getProjectResponse();

//        presenter = new ViewProjectsPresenter(model);
        presenter.attachView(view);

    }

    @Test
    public void onStart_UserShouldBeAbleToViewAllActiveProjects() {

        // given
        when(teamworkAPI.getProjects()).thenReturn(just(response));
//        when(paymentsMocks.paymentsAPI().getMandateList(request)).thenReturn(observable);


        // when
        presenter.loadProjects();

        // then
        verify(view).showProjects(response.getProjects());
    }
}