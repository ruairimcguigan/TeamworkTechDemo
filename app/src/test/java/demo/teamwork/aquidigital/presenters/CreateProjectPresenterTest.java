package demo.teamwork.aquidigital.presenters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import demo.teamwork.aquidigital.common.BaseTests;
import demo.teamwork.aquidigital.createproject.CreateProjectContract.Model;
import demo.teamwork.aquidigital.createproject.CreateProjectContract.View;
import demo.teamwork.aquidigital.createproject.CreateProjectDateObj;
import demo.teamwork.aquidigital.createproject.CreateProjectPresenter;
import demo.teamwork.aquidigital.createproject.models.CreateProjectResult;
import demo.teamwork.aquidigital.createproject.models.TagResponse;
import demo.teamwork.aquidigital.repository.api.TeamworkApi;
import demo.teamwork.aquidigital.util.TestData;
import demo.teamwork.aquidigital.util.network.NetworkUtil;
import demo.teamwork.aquidigital.util.ui.ViewUtil;
import io.reactivex.Observable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateProjectPresenterTest extends BaseTests{

    @Mock private TeamworkApi api;

    @Mock private NetworkUtil networkUtil;

    @Mock private View view;

    @Mock private Model model;

    @Spy ViewUtil viewUtil;

    @InjectMocks private CreateProjectPresenter presenter;

    private TagResponse tagResponse;

    @Before
    public void setUp() {
        tagResponse = TestData.getTagResponse();
        presenter.attachView(view);
    }

    @Test
    public void loadTagsForTagSpinner() {

        // given
        when(networkUtil.isNetworkConnected()).thenReturn(true);
        when(model.provideTags(api)).thenReturn(Observable.just(tagResponse));

        // when
        presenter.loadTags();

        // then
        verify(view).showProgress();
        verify(view).hideProgress();
        verify(view).showTags(tagResponse.getTags());
    }

    @Test
    public void onFormCompleted_AllowUserToSubmitOnSaveButtonClick() {

        // given
        presenter.onTitleChanged("title");
        presenter.onDescriptionChanged("description");
        presenter.onCompanyChanged("company");
        presenter.onCategoryChanged(23417);
        presenter.onTagChanged("tag");

        CreateProjectDateObj startDateObj = new CreateProjectDateObj(2018, 7, 1);
        CreateProjectDateObj endDateObj = new CreateProjectDateObj(2018, 9, 1);


        CreateProjectResult result = new CreateProjectResult();
        result.setStatus("ok");

        Observable<CreateProjectResult> resultObservable = Observable.just(result);

        when(networkUtil.isNetworkConnected()).thenReturn(true);
        when(model.createProject((any()), eq(api))).thenReturn(resultObservable);

        // when
        presenter.onStartDateSelected(2018, 7, 1);
        presenter.onEndDateSelected(2018, 9, 1);
        presenter.createProjectRequest();

        // then
        verify(view).showProgress();
        verify(view).hideProgress();
        verify(view).showCreateProjectSuccess();
    }

    @Test
    public void onCreateProjectFail_DisplayErrorMessageSnackbar() {

        // given
        presenter.onTitleChanged("title");
        presenter.onDescriptionChanged("description");
        presenter.onCompanyChanged("company");
        presenter.onCategoryChanged(23417);
        presenter.onTagChanged("tag");
        Exception exception = new Exception();

        CreateProjectResult result = new CreateProjectResult();
        result.setStatus("ok");

        when(networkUtil.isNetworkConnected()).thenReturn(true);
        when(model.createProject((any()), eq(api))).thenReturn(Observable.error(exception));

        // when
        presenter.onStartDateSelected(2018, 7, 1);
        presenter.onEndDateSelected(2018, 9, 1);
        presenter.createProjectRequest();

        // then
        verify(view).showProgress();
        verify(view).hideProgress();
        verify(view).onError(exception);
    }
}