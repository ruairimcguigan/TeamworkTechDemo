package demo.teamwork.aquidigital.presenters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import demo.teamwork.aquidigital.common.BaseTests;
import demo.teamwork.aquidigital.repository.api.TeamworkAPI;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TasksResponse;
import demo.teamwork.aquidigital.tasks.ViewTasksContract.Model;
import demo.teamwork.aquidigital.tasks.ViewTasksContract.View;
import demo.teamwork.aquidigital.tasks.ViewTasksPresenter;
import demo.teamwork.aquidigital.util.TestData;
import demo.teamwork.aquidigital.util.network.NetworkUtil;
import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ViewTasksPresenterTest extends BaseTests {

    @Mock private TeamworkAPI taskService;
    @Mock private NetworkUtil networkUtil;

    @Mock private View view;
    @Mock private Model model;

    @InjectMocks
    private ViewTasksPresenter presenter;

    private TasksResponse tasksResponse;

    @Before
    public void setUp() {
        tasksResponse = TestData.getTaskResponse();
        presenter.attachView(view);
    }

    @Test
    public void onStart_UserShouldBeAbleToViewAllActiveProjects() {

        // given
        when(taskService.getTasks()).thenReturn(Observable.just(tasksResponse));
        when(networkUtil.isNetworkConnected()).thenReturn(true);

        // when
        presenter.loadTasks();

        // then
        verify(view).showProgress();
        verify(view).hideProgress();
        verify(view).showTasks(tasksResponse.getTodoItems());

    }

    @Test
    public void onLoadPeopleFail_DisplayErrorMessageSnackbar() {

        // given
        Exception exception = new Exception();
        when(networkUtil.isNetworkConnected()).thenReturn(true);
        when(taskService.getTasks()).thenReturn(Observable.error(exception));

        // when
        presenter.loadTasks();

        // then
        verify(view).onError(exception);

    }
}
