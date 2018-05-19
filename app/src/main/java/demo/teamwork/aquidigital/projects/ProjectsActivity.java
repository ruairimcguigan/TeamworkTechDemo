package demo.teamwork.aquidigital.projects;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseActivity;
import demo.teamwork.aquidigital.projects.ProjectsContract.View;
import demo.teamwork.aquidigital.repository.api.apimodel.Project;

import static android.support.v7.widget.RecyclerView.HORIZONTAL;

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

        showFragment(R.id.fragment_container, ProjectsListFragment.class);
        setNavigationView();

        ((TeamworkApplication) getApplication()).getAppComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_projects;
    }

    private void setNavigationView() {
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
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {

            case R.id.nav_projects:
                //do somthing
                break;

            case R.id.nav_messages:
                //do somthing
                break;

            case R.id.nav_milestones:
                //do somthing
                break;

            case R.id.nav_people:
                //do somthing
                break;
        }
        //close navigation drawer
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
