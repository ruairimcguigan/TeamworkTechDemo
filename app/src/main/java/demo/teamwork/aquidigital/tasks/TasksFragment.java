package demo.teamwork.aquidigital.tasks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;
import demo.teamwork.aquidigital.projects.ProjectsActivity;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;
import demo.teamwork.aquidigital.tasks.taskdetail.TaskDetailFragment;

import static butterknife.ButterKnife.bind;
import static demo.teamwork.aquidigital.tasks.TasksAdapter.AdapterCallback;

public class TasksFragment extends BaseFragment implements AdapterCallback, TaskContract.View{

    @Inject
    TaskPresenter presenter;

    private TasksAdapter adapter;

    @BindView(R.id.task_list)
    RecyclerView taskList;

    private List<TodoItemsItem> items = new ArrayList<>();

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        bind(this, view);
        setAdapter();

        ((TeamworkApplication) getActivity().getApplication()).getAppComponent().inject(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
        presenter.loadTasks();
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
    protected int getLayout() {
        return R.layout.fragment_tasks;
    }

    @Override
    public void setProjectName(String projectName) {

    }

    @Override
    public void showTasks(List<TodoItemsItem> taskList) {
        items.addAll(taskList);
        adapter.setData(taskList);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detach();
    }

    @Override
    public void onTaskSelected(TodoItemsItem task) {
        if (task != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("TASK", task);

            ((ProjectsActivity) getActivity()).showFragment(R.id.fragment_container, TaskDetailFragment.class, bundle, true);
        }
    }
}
