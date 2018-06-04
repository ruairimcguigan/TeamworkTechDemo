package demo.teamwork.aquidigital.viewprojectdetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseActivity;
import demo.teamwork.aquidigital.createproject.CreateProjectFragment;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectsResponse;
import demo.teamwork.aquidigital.util.ui.ViewUtil;
import timber.log.Timber;

import static java.util.Objects.requireNonNull;

public class ViewProjectDetailsActivity extends BaseActivity implements OnClickListener{

    @BindView(R.id.project_backdrop)
    ImageView backdrop;

    @Inject ViewUtil viewUtil;

    @BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    @BindView(R.id.toolbar) Toolbar toolbar;

    @BindView(R.id.add_new_project)
    CardView addNewProject;

    @BindView(R.id.project_details_list)
    ViewGroup projectDetailListContainer;

    @BindView(R.id.project_detail_container)
    ViewGroup fragmentContainer;

    public static final String EXTRA_NAME = "project_name";
    public static final String EXTRA_LOGO = "project_logo";
    public static final String EXTRA_PROJECTS_LIST = "project_list";

    private String projectName;
    private  String projectLogo;

    private ProjectsResponse projectsResponse = new ProjectsResponse();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        ((TeamworkApplication) getApplication()).getAppComponent().inject(this);

        setToolbar();
        setProjectDetails();
        viewUtil.setVisibility(projectDetailListContainer, true);

        addNewProject.setOnClickListener(this);
    }

    private void setProjectDetails() {
        Intent intent = getIntent();
        projectName = intent.getStringExtra(EXTRA_NAME);
        projectLogo = intent.getStringExtra(EXTRA_LOGO);

        projectsResponse = (ProjectsResponse) intent.getSerializableExtra(EXTRA_PROJECTS_LIST);

        collapsingToolbar.setTitle(projectName);
        backdrop.setImageURI(Uri.parse(projectLogo));
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            Timber.d("Home pressed");
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_project_detail;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_new_project:
                createNewProject();
        }
    }

    private void createNewProject() {
        viewUtil.setVisibility(fragmentContainer, true);
        viewUtil.setVisibility(projectDetailListContainer, false);
        appBarLayout.setExpanded(false);
        collapsingToolbar.setTitle("Create new project");

        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_PROJECTS_LIST, projectsResponse);

        showFragment(R.id.project_detail_container, CreateProjectFragment.class, bundle, false);
    }
}
