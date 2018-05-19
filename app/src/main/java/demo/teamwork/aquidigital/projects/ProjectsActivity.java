package demo.teamwork.aquidigital.projects;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseActivity;
import demo.teamwork.aquidigital.messages.MessagesFragment;
import demo.teamwork.aquidigital.people.PeopleFragment;
import demo.teamwork.aquidigital.projects.ProjectsContract.View;
import demo.teamwork.aquidigital.projects.ProjectsPresenter.NavigationSelection;
import demo.teamwork.aquidigital.repository.api.apimodel.Project;
import demo.teamwork.aquidigital.tasks.TasksFragment;

import static demo.teamwork.aquidigital.projects.ProjectsPresenter.NavigationSelection.MESSAGES;
import static demo.teamwork.aquidigital.projects.ProjectsPresenter.NavigationSelection.PEOPLE;
import static demo.teamwork.aquidigital.projects.ProjectsPresenter.NavigationSelection.PROJECTS;
import static demo.teamwork.aquidigital.projects.ProjectsPresenter.NavigationSelection.TASKS;

public class ProjectsActivity extends BaseActivity implements View, OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Inject
    ProjectsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        showFragment(ProjectsListFragment.class);
        setNavigationView();

        ((TeamworkApplication) getApplication()).getAppComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_projects;
    }

    private void setNavigationView() {
        navigationView.setNavigationItemSelectedListener(this);
        if (navigationView != null) {
            drawerLayout.openDrawer(GravityCompat.START);
//            setupDrawerContent(navigationView);
        }
    }

//    private void setupDrawerContent(NavigationView navigationView) {
//        navigationView.setNavigationItemSelectedListener(
//                new OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(MenuItem menuItem) {
//                        menuItem.setChecked(true);
//                        drawerLayout.closeDrawers();
//                        return true;
//                    }
//                });
//    }

    @Override
    public void showProjects(List<Project> projectList) {
    }

    @Override
    public void toggleProgress() {
        // TODO: 16/05/2018 implement progress
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_projects:
                showFragment(ProjectsListFragment.class);
                break;

            case R.id.nav_messages:
                showFragment(MessagesFragment.class);
                break;

            case R.id.nav_tasks:
                showFragment(TasksFragment.class);
                break;

            case R.id.nav_people:
                showFragment(PeopleFragment.class);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void displayNavigationSelection(NavigationSelection selection) {
        switch (selection){
            case PROJECTS:
                showFragment(ProjectsListFragment.class);
                break;
//            case MESSAGES:
//                showFragment(MessagesFragment.class);
//                break;
//            case TASKS:
//                showFragment(TasksFragment.class);
//                break;
//            case PEOPLE:
//                showFragment(PeopleFragment.class);
//                break;
        }
    }
}
