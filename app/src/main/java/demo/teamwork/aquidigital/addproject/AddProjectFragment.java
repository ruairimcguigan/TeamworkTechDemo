package demo.teamwork.aquidigital.addproject;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;
import demo.teamwork.aquidigital.repository.api.addprojectmodel.TagsItem;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectItem;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectsResponse;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;
import demo.teamwork.aquidigital.taskdetail.TaskDetailFragment;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsActivity;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static butterknife.ButterKnife.bind;
import static demo.teamwork.aquidigital.R.layout.spinner_item_view;
import static demo.teamwork.aquidigital.tasks.TasksAdapter.AdapterCallback;
import static demo.teamwork.aquidigital.util.ui.ViewUtil.formatForRequest;
import static demo.teamwork.aquidigital.util.ui.ViewUtil.getCategories;
import static demo.teamwork.aquidigital.util.ui.ViewUtil.getCompanyNames;
import static demo.teamwork.aquidigital.util.ui.ViewUtil.getTagNames;
import static demo.teamwork.aquidigital.util.ui.ViewUtil.handleSoftKeyBoardVisibility;
import static demo.teamwork.aquidigital.viewprojects.ViewProjectDetailsActivity.EXTRA_PROJECTS_LIST;
import static java.util.Calendar.getInstance;
import static java.util.Objects.requireNonNull;

public class AddProjectFragment extends BaseFragment
        implements AdapterCallback, AddProjectContract.View, OnClickListener {

    @Inject
    AddProjectPresenter presenter;

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

    private Calendar c = getInstance();
    private int startYear = c.get(Calendar.YEAR);
    private int startMonth = c.get(Calendar.MONTH);
    private int startDay = c.get(Calendar.DAY_OF_MONTH);
    private int endYear = c.get(Calendar.YEAR);
    private int endMonth = c.get(Calendar.MONTH);
    private int endDay = c.get(Calendar.DAY_OF_MONTH);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        bind(this, view);

        setClickListeners();
        handleSoftKeyBoardVisibility(getActivity(), categorySpinner, companySpinner, tagsSpinner);

        ((TeamworkApplication) requireNonNull(getActivity()).getApplication()).getAppComponent().inject(this);

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
        companyAdapter = new ArrayAdapter(requireNonNull(getActivity()), spinner_item_view, getCompanyNames(projects));
        companyAdapter.setDropDownViewResource(spinner_item_view);
        companySpinner.setAdapter(companyAdapter);

        categorySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categorySpinner.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        categoryAdapter = new ArrayAdapter(requireNonNull(getActivity()), spinner_item_view, getCategories(projects));
        categoryAdapter.setDropDownViewResource(spinner_item_view);
        categorySpinner.setAdapter(categoryAdapter);

        categorySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categorySpinner.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setTagsAdapter(List<TagsItem> tags) {
        ArrayAdapter tagsAdapter = new ArrayAdapter(requireNonNull(getActivity()), spinner_item_view, getTagNames(tags));

        tagsAdapter.setDropDownViewResource(R.layout.spinner_item_view);
        tagsSpinner.setAdapter(tagsAdapter);

        tagsSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tagsSpinner.setSelection(position);
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
    public void showTags(List<TagsItem> tags) {
        setTagsAdapter(tags);
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

        DatePickerDialog datePickerDialog = new DatePickerDialog(requireNonNull(getActivity()),
                (datePicker, startYear, startMonth, startDay)
                        -> presenter.onStartDateSelected(startYear, startMonth + 1, startDay)
                , startYear, startMonth + 1, startDay);

        datePickerDialog.show();
    }

    private void showEndDateDatePicker() {

        DatePickerDialog datePickerDialog = new DatePickerDialog(requireNonNull(getActivity()),
                (datePicker, endYear, endMonth, endDay)
                        -> presenter.onEndDateSelected(endYear, endMonth + 1, endDay),
                endYear, endMonth + 1, endDay);

        datePickerDialog.show();
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

        presenter.onProjectFormComplete(
                addTitle.getText().toString(),
                addDescription.getText().toString(),
                companySpinner.getSelectedItem().toString(),
                tagsSpinner.getSelectedItem().toString(),
                Integer.parseInt(categorySpinner.getSelectedItem().toString()),
                formatForRequest(startYear, startMonth, startDay),
                formatForRequest(endYear, endMonth, endDay));
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