package demo.teamwork.aquidigital.tasks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;
import demo.teamwork.aquidigital.taskdetail.TaskDetailFragment;
import demo.teamwork.aquidigital.viewprojects.ViewProjectsActivity;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static butterknife.ButterKnife.bind;
import static demo.teamwork.aquidigital.tasks.TasksAdapter.AdapterCallback;
import static java.util.Objects.requireNonNull;

public class TasksFragment extends BaseFragment implements AdapterCallback, TaskContract.View{

    @Inject
    TaskPresenter presenter;

    private TasksAdapter adapter;

    @BindView(R.id.task_list)
    RecyclerView taskList;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private List<TodoItemsItem> items = new ArrayList<>();

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        bind(this, view);
        setAdapter();

        ((TeamworkApplication) requireNonNull(getActivity()).getApplication()).getAppComponent().inject(this);

        return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_tasks;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
        presenter.loadTasks();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requireNonNull(getActivity()).setTitle("Tasks");
    }

    @Override
    public void setAdapter(){
        adapter = new TasksAdapter(getActivity());
        adapter.callback = this;

        taskList.setLayoutManager(new LinearLayoutManager(getActivity()));
        taskList.setHasFixedSize(true);
        taskList.setAdapter(adapter);
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
    public void showTasks(List<TodoItemsItem> taskList) {
        items.addAll(taskList);
        adapter.setData(taskList);
    }

    @Override
    public void onTaskSelected(TodoItemsItem task) {
        if (task != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("TASK", task);

            ((ViewProjectsActivity) requireNonNull(getActivity())).showFragment(R.id.fragment_container, TaskDetailFragment.class, bundle, true);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detach();
    }
}
