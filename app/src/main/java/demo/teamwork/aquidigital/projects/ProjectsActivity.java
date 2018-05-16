package demo.teamwork.aquidigital.projects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.projects.ProjectsContract.View;
import demo.teamwork.aquidigital.repository.apimodel.Project;

public class ProjectsActivity extends AppCompatActivity implements View{

    @Inject
    ProjectsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        ((TeamworkApplication) getApplication()).getAppComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
        presenter.getProjects();
    }

    @Override
    public void showProjects(List<Project> projectList) {
        Toast.makeText(this, "Success   ", Toast.LENGTH_SHORT).show();
        for (Project p:projectList) {
            Toast.makeText(this, p.name(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void toggleProgress() {
        // TODO: 16/05/2018 implement progress
    }
}
