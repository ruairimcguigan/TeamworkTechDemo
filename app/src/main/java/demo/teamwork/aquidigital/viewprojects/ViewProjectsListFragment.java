package demo.teamwork.aquidigital.viewprojects;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectItem;

import static java.util.Objects.requireNonNull;

public class ViewProjectsListFragment extends BaseFragment implements ViewProjectsContract.View{

    @Inject
    ViewProjectsPresenter presenter;

    @BindView(R.id.projectList)
    RecyclerView projectList;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private ViewProjectAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        setAdapter();

        ((TeamworkApplication) requireNonNull(getActivity())
                .getApplication())
                .getAppComponent()
                .inject(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requireNonNull(getActivity()).setTitle("List all projects");
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
        presenter.loadProjects();
    }

    @Override
    public void showProjects(List<ProjectItem> projectItemList) {
        adapter.setData(projectItemList);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(Throwable throwable) {
        showFailedToRetrieveProjectsAlert();
    }

    private void showFailedToRetrieveProjectsAlert() {
        showRetrySnackbar(R.string.project_load_failed, R.string.retry, view -> presenter.loadProjects());
    }

    @Override
    public void setAdapter() {
        adapter = new ViewProjectAdapter(getActivity());
        projectList.setLayoutManager(new LinearLayoutManager(getActivity()));
        projectList.setHasFixedSize(true);
        projectList.setAdapter(adapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_project_list;
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detach();
    }
}
