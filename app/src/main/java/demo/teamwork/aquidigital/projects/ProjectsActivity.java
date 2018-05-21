package demo.teamwork.aquidigital.projects;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;

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
import demo.teamwork.aquidigital.repository.api.projectsmodel.Project;
import demo.teamwork.aquidigital.tasks.TasksFragment;

public class ProjectsActivity extends BaseActivity implements OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.toolbar) Toolbar toolbar;

    @Inject
    ProjectsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        setNavigationView();
        showFragment(ProjectsListFragment.class);

        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        ((TeamworkApplication) getApplication()).getAppComponent().inject(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_projects;
    }

    private void setNavigationView() {
        navigationView.setNavigationItemSelectedListener(this);
        if (navigationView != null) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
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

}
