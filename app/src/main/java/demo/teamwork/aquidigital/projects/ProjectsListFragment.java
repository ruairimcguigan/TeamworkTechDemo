package demo.teamwork.aquidigital.projects;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;
import demo.teamwork.aquidigital.repository.api.projectsmodel.Project;

import static android.support.v7.widget.RecyclerView.HORIZONTAL;

public class ProjectsListFragment extends BaseFragment implements ProjectsContract.View{

    @Inject
    ProjectsPresenter presenter;

    @BindView(R.id.projectList)
    RecyclerView projectList;

    private ProjectAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        setAdapter();

        Toast.makeText(getActivity(), "ProjectsListFragment", Toast.LENGTH_SHORT).show();

        ((TeamworkApplication) getActivity().getApplication()).getAppComponent().inject(this);

        return view;
    }

    private void setAdapter() {
        adapter = new ProjectAdapter(getActivity());
        projectList.setLayoutManager(new LinearLayoutManager(getActivity()));
        projectList.setHasFixedSize(true);
        projectList.setAdapter(adapter);
        DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(), HORIZONTAL);
        projectList.addItemDecoration(itemDecor);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_project_list;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
        presenter.loadProjects();
    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void detachPresenter() {

    }

    @Override
    public void showProjects(List<Project> projectList) {
        adapter.setData(projectList);
    }

    @Override
    public void toggleProgress() {

    }
}
