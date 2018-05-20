package demo.teamwork.aquidigital.projects;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.common.base.BaseActivity;
import timber.log.Timber;

public class ProjectDetailsActivity extends BaseActivity{

    @BindView(R.id.project_backdrop)
    ImageView backdrop;

    @BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.toolbar) Toolbar toolbar;

    public static final String EXTRA_NAME = "project_name";
    public static final String EXTRA_LOGO = "project_logo";

    private String projectName;
    private  String projectLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        setToolbar();

        setProjectDetails();
    }

    private void setProjectDetails() {
        Intent intent = getIntent();
        projectName = intent.getStringExtra(EXTRA_NAME);
        projectLogo = intent.getStringExtra(EXTRA_LOGO);

        collapsingToolbar.setTitle(projectName);
        backdrop.setImageURI(Uri.parse(projectLogo));
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
}
