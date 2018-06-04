package demo.teamwork.aquidigital.createproject;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;
import demo.teamwork.aquidigital.repository.api.addprojectmodel.TagItem;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectItem;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectsResponse;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;
import demo.teamwork.aquidigital.taskdetail.TaskDetailFragment;
import demo.teamwork.aquidigital.util.ui.AfterTextWatcher;
import demo.teamwork.aquidigital.util.ui.ViewUtil;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsActivity;
import timber.log.Timber;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static butterknife.ButterKnife.bind;
import static demo.teamwork.aquidigital.R.layout.spinner_item_view;
import static demo.teamwork.aquidigital.tasks.ViewTasksAdapter.AdapterCallback;
import static demo.teamwork.aquidigital.viewprojectdetails.ViewProjectDetailsActivity.EXTRA_PROJECTS_LIST;
import static java.lang.Integer.valueOf;
import static java.util.Calendar.getInstance;
import static java.util.Objects.requireNonNull;

public class CreateProjectFragment extends BaseFragment
        implements AdapterCallback, CreateProjectContract.View, OnClickListener {

    @Inject CreateProjectPresenter presenter;

    @Inject ViewUtil viewUtil;

    @BindView(R.id.content_root)
    ViewGroup contentRoot;

    @BindView(R.id.add_project_add_title)
    EditText addTitle;

    @BindView(R.id.add_project_add_description)
    EditText addDescription;

    @BindView(R.id.add_project_category_spinner)
    Spinner categorySpinner;

    @BindView(R.id.add_project_company_spinner)
    Spinner companySpinner;

    @BindView(R.id.add_project_tags_spinner)
    Spinner tagsSpinner;

    @BindView(R.id.add_project_start_date)
    TextView startDate;

    @BindView(R.id.add_project_end_date)
    TextView endDate;

    @BindView(R.id.add_project_save_project_button)
    Button saveProject;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private List<TodoItemsItem> items = new ArrayList<>();
    private List<ProjectItem> projects = new ArrayList<>();
    private ArrayAdapter companyAdapter;
    private ArrayAdapter categoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        bind(this, view);
        ((TeamworkApplication) requireNonNull(getActivity()).getApplication()).getAppComponent().inject(this);

        setClickListeners();
        viewUtil.handleSoftKeyBoardVisibility(getActivity(), categorySpinner, companySpinner, tagsSpinner);
        receiveProjectData();
        return view;
    }

    private void setClickListeners() {
        startDate.setOnClickListener(this);
        endDate.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
        presenter.loadTags();
    }

    @Override
    public void onResume() {
        super.onResume();
        setProjectSpinners();

        setTitle();
        setDescription();
    }

    private void setTitle() {
        addTitle.addTextChangedListener(new AfterTextWatcher() {
            @Override
            public void changed(Editable editable) {
                presenter.onTitleChanged(addTitle.getText().toString());
            }
        });
    }

    private void setDescription() {
        addDescription.addTextChangedListener(new AfterTextWatcher() {
            @Override
            public void changed(Editable editable) {
                presenter.onDescriptionChanged(addDescription.getText().toString());
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requireNonNull(getActivity()).setTitle("Create project");
    }

    private void receiveProjectData() {
        if (getArguments() != null) {
            ProjectsResponse projectResponse = (ProjectsResponse) getArguments().getSerializable(EXTRA_PROJECTS_LIST);
            projects.addAll(requireNonNull(projectResponse).getProjects());
        }
    }

    private void setProjectSpinners() {
        companyAdapter = new ArrayAdapter(requireNonNull(getActivity()), spinner_item_view, viewUtil.getCompanyNames(projects));
        companyAdapter.setDropDownViewResource(spinner_item_view);
        companySpinner.setAdapter(companyAdapter);

        companySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categorySpinner.setSelection(position);
                presenter.onCompanyChanged(companySpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        categoryAdapter = new ArrayAdapter(requireNonNull(getActivity()), spinner_item_view, viewUtil.getCategories(projects));
        categoryAdapter.setDropDownViewResource(spinner_item_view);
        categorySpinner.setAdapter(categoryAdapter);

        categorySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categorySpinner.setSelection(position);
                presenter.onCategoryChanged(valueOf(categorySpinner.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setTagsAdapter(List<TagItem> tags) {
        ArrayAdapter tagsAdapter = new ArrayAdapter(requireNonNull(getActivity()), spinner_item_view, viewUtil.getTagNames(tags));

        tagsAdapter.setDropDownViewResource(R.layout.spinner_item_view);
        tagsSpinner.setAdapter(tagsAdapter);

        tagsSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tagsSpinner.setSelection(position);
                presenter.onTagChanged(tagsSpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onTaskSelected(TodoItemsItem task) {
        if (task != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("TASK", task);

            ((ViewProjectsActivity) requireNonNull(getActivity())).showFragment(
                    R.id.fragment_container, TaskDetailFragment.class, bundle, true);
        }
    }

    @Override
    public void showTags(List<TagItem> tags) {
        setTagsAdapter(tags);
    }

    @Override
    public void onError(Throwable throwable) {
        Timber.d("Error retrieving tags", Arrays.toString(throwable.getStackTrace()));
        showRetrySnackbar(R.string.project_load_failed, R.string.retry,
                view -> presenter.loadTags());
    }

    @Override
    public void populateStartDate(String date) {
        startDate.setText(date);
    }

    @Override
    public void populateEndDate(String date) {
        endDate.setText(date);
    }

    @Override
    public void showCreateProjectSuccess() {
        Toast.makeText(getActivity(), "Project created successfully", Toast.LENGTH_SHORT).show();
    }

    private void showStartDatePicker() {

        Calendar start = getInstance();
        int startYear = start.get(Calendar.YEAR);
        int startMonth = start.get(Calendar.MONTH);
        int startDay = start.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog startDatePicker = new DatePickerDialog(requireNonNull(getActivity()),
                (datePicker, startYear1, startMonth1, startDay1)
                        -> presenter.onStartDateSelected(startYear1, startMonth1 + 1, startDay1),
                startYear, startMonth + 1, startDay);

        startDatePicker.show();
    }

    private void showEndDateDatePicker() {

        Calendar end = Calendar.getInstance();
        int endYear = end.get(Calendar.YEAR);
        int endMonth = end.get(Calendar.MONTH);
        int endDay = end.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog endDatePicker = new DatePickerDialog(requireNonNull(getActivity()),
                (datePicker, endYear1, endMonth1, endDay1)
                        -> presenter.onEndDateSelected(endYear1, endMonth1 + 1, endDay1),
                endYear, endMonth + 1, endDay);

        endDatePicker.show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_add_project;
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detach();
    }

    @OnClick(R.id.add_project_save_project_button)
    public void createProject() {
        presenter.createProjectRequest();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_project_start_date:
                showStartDatePicker();
                break;
            case R.id.add_project_end_date:
                showEndDateDatePicker();
                break;
        }
    }
}