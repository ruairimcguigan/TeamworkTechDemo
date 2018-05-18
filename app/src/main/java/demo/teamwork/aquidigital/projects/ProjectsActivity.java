package demo.teamwork.aquidigital.projects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.projects.ProjectsContract.View;
import demo.teamwork.aquidigital.repository.api.apimodel.Project;

import static android.support.v7.widget.RecyclerView.HORIZONTAL;

public class ProjectsActivity extends AppCompatActivity implements View{

    @BindView(R.id.projectList)
    RecyclerView projectList;

    private ProjectAdapter adapter;

    @Inject
    ProjectsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        ButterKnife.bind(this);

        setAdapter();

        ((TeamworkApplication) getApplication()).getAppComponent().inject(this);
    }

    private void setAdapter() {
        adapter = new ProjectAdapter(this);
        projectList.setLayoutManager(new LinearLayoutManager(this));
        projectList.setHasFixedSize(true);
        projectList.setAdapter(adapter);
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, HORIZONTAL);
        projectList.addItemDecoration(itemDecor);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
        presenter.loadProjects();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void showProjects(List<Project> projectList) {
        for (Project p: projectList) {
        Toast.makeText(this, p.getName(), Toast.LENGTH_SHORT).show();

        }
        adapter.setData(projectList);
    }


    @Override
    public void toggleProgress() {
        // TODO: 16/05/2018 implement progress
    }
}
