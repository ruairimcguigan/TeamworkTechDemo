package demo.teamwork.aquidigital.projects.addproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;
import demo.teamwork.aquidigital.projects.ProjectsActivity;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;
import demo.teamwork.aquidigital.tasks.TasksAdapter;
import demo.teamwork.aquidigital.tasks.taskdetail.TaskDetailFragment;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static butterknife.ButterKnife.bind;
import static demo.teamwork.aquidigital.tasks.TasksAdapter.AdapterCallback;
import static java.util.Objects.requireNonNull;

public class AddProjectFragment extends BaseFragment implements AdapterCallback, AddProjectContract.View{

    @Inject
    AddProjectPresenter presenter;

    @BindView(R.id.task_list)
    RecyclerView taskList;

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

    @BindView(R.id.add_project_save_project)
    TextView saveProject;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private List<TodoItemsItem> items = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        bind(this, view);

        ((TeamworkApplication) requireNonNull(getActivity()).getApplication()).getAppComponent().inject(this);

        return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_add_project;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requireNonNull(getActivity()).setTitle("Create project");
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
    public void onTaskSelected(TodoItemsItem task) {
        if (task != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("TASK", task);

            ((ProjectsActivity) requireNonNull(getActivity())).showFragment(R.id.fragment_container, TaskDetailFragment.class, bundle, true);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detach();
    }
}
