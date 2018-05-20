package demo.teamwork.aquidigital.tasks.taskdetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.common.base.BaseAdapter;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;

public class TaskDetailAdapter extends BaseAdapter<TodoItemsItem, TaskDetailAdapter.TaskViewHolder> {

    private Context context;

    TaskDetailAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.task_item, parent, false);

        final TaskViewHolder viewHolder = new TaskViewHolder(view);
        viewHolder.itemView.setOnClickListener(v -> onItemClicked(viewHolder.getAdapterPosition()));


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TodoItemsItem task = (TodoItemsItem) getItem(position);
        holder.populate(task);
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.task_title)
        TextView taskTitle;

        @BindView(R.id.task_description)
        TextView taskDescription;

        @BindView(R.id.tasks_project_name)
        TextView projectName;

        TaskViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void populate(TodoItemsItem task) {
            taskTitle.setText(task.getTodoListName());
            taskDescription.setText(task.getDescription());
            projectName.setText(task.getProjectName());

            startProjectDetailsActivityOnViewSelect(task);
        }

        private void startProjectDetailsActivityOnViewSelect(TodoItemsItem task) {
            itemView.setOnClickListener(v -> {
                Context context = v.getContext();

                // TODO: 20/05/2018 pass task object through to detail
//                Intent intent = new Intent(context, ProjectDetailsActivity.class);
//                intent.putExtra(ProjectDetailsActivity.EXTRA_NAME,project.getName());
//                intent.putExtra(ProjectDetailsActivity.EXTRA_LOGO, project.getLogo());

//                context.startActivity(intent);
            });
        }
    }
}
