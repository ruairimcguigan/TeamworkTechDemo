package demo.teamwork.aquidigital.tasks;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;

import static butterknife.ButterKnife.bind;

public class TasksFragment extends BaseFragment implements TaskContract.View{

    @Inject
    TaskPresenter presenter;

    private TasksAdapter adapter;

    @BindView(R.id.task_list)
    RecyclerView taskList;

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
        adapter.setData(taskList);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detach();
    }
}
