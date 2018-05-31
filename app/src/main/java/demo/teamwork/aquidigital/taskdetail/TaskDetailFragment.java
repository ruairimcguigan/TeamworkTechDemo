package demo.teamwork.aquidigital.taskdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import javax.inject.Inject;

import butterknife.BindView;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;

import static butterknife.ButterKnife.bind;
import static java.util.Objects.requireNonNull;

public class TaskDetailFragment extends BaseFragment implements TaskDetailContract.View, View.OnClickListener {

    @Inject
    TaskDetailPresenter presenter;

    @BindView(R.id.project_details_expand_container)
    ExpandableRelativeLayout projectDetailsExpandContainer;

    @BindView(R.id.project_details_header)
    TextView projectDetailsHeader;

    @BindView(R.id.task_id)
    TextView taskId;

    @BindView(R.id.progress_percentage)
    TextView progressPercentage;

    @BindView(R.id.responsible)
    TextView responsible;

    @BindView(R.id.start_date)
    TextView startDate;

    @BindView(R.id.task_list)
    TextView taskList;

    @BindView(R.id.task_project_name)
    TextView projectName;

    @BindView(R.id.created_by)
    TextView createdBy;

    @BindView(R.id.created_on)
    TextView createdOn;

    @BindView(R.id.last_modified)
    TextView lastModified;

    @BindView(R.id.access_status)
    TextView accessStatus;

    @BindView(R.id.following_status)
    TextView followingStatus;

    private OnGlobalLayoutListener globalLayoutListener;
    private TodoItemsItem task;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            task = (TodoItemsItem) getArguments().getSerializable("TASK");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        bind(this, view);

        ((TeamworkApplication) requireNonNull(getActivity()).getApplication()).getAppComponent().inject(this);

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
        taskId.setText(String.valueOf(task.getId()));
        progressPercentage.setText(String.valueOf(task.getProgress() + "%"));
        responsible.setText(task.getResponsiblePartyFirstname());
        startDate.setText(task.getStartDate());
        taskList.setText(task.getPriority());
        projectName.setText(task.getProjectName());
        createdBy.setText(getString(R.string.task_detail_name_concat,
                task.getCreatorFirstname(), task.getCreatorLastname()));
        createdOn.setText(task.getCreatedOn());
        lastModified.setText(task.getLastChangedOn());
        accessStatus.setText(task.getStatus());
        followingStatus.setText(task.getTimeIsLogged());
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_task_detail_list;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requireNonNull(getActivity()).setTitle("Task details");
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
                toggleProjectDetailsContainer();
                break;
        }
    }

    private void toggleProjectDetailsContainer() {
        if (!projectDetailsExpandContainer.isExpanded()) {
            projectDetailsExpandContainer.expand();
        }else {
            projectDetailsExpandContainer.collapse();
        }
    }

    private void setExpandableLayoutListener() {
        globalLayoutListener = () -> {
            projectDetailsExpandContainer.move(projectDetailsHeader.getHeight(), 0, null);

            projectDetailsHeader.getViewTreeObserver().removeOnGlobalLayoutListener(globalLayoutListener);
        };
        projectDetailsHeader.getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
    }
}
