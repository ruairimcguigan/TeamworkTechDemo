package demo.teamwork.aquidigital.tasks.taskdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;

import static android.widget.Toast.makeText;
import static butterknife.ButterKnife.bind;

public class TaskDetailFragment extends BaseFragment implements TaskDetailContract.View, View.OnClickListener {

    @Inject
    TaskDetailPresenter presenter;

    @BindView(R.id.expandableLayout)
    ExpandableRelativeLayout expandableLayout;

    @BindView(R.id.project_details_header)
    TextView projectDetailsHeader;

    @BindView(R.id.project_details_content)
    TextView projectDetailsContent;

    private OnGlobalLayoutListener mGlobalLayoutListener;
    private TodoItemsItem task;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            task = (TodoItemsItem) getArguments().getSerializable("TASK");
            makeText(getActivity(), "Tasks: " + task, Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        bind(this, view);

        ((TeamworkApplication) getActivity().getApplication()).getAppComponent().inject(this);

        projectDetailsHeader.setOnClickListener(this);

        setExpandableLayoutListener();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);

        setProjectDetailsView();
    }

    private void setProjectDetailsView() {
        projectDetailsHeader.setText(task.getTodoListName());
        projectDetailsContent.setText("sample.sample.sample.sample.sample.sample.sample.sample.sample.sample.sample.sample.sample.sample.sample.sample.sample.sample..ruairi");
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_task_detail_list;
    }

    @Override
    public void setProjectName(String projectName) {

    }

    @Override
    public void showTasks(List<TodoItemsItem> taskList) {
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detach();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project_details_header:
                expandableLayout.expand();
                break;
        }
    }

    private void setExpandableLayoutListener() {
        mGlobalLayoutListener = () -> {
            expandableLayout.move(projectDetailsHeader.getHeight(), 0, null);

            projectDetailsHeader.getViewTreeObserver().removeOnGlobalLayoutListener(mGlobalLayoutListener);
        };
        projectDetailsHeader.getViewTreeObserver().addOnGlobalLayoutListener(mGlobalLayoutListener);
    }
}
