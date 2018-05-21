package demo.teamwork.aquidigital.tasks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.common.base.BaseAdapter;
import demo.teamwork.aquidigital.projects.ProjectDetailsActivity;
import demo.teamwork.aquidigital.repository.api.projectsmodel.Project;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;
import timber.log.Timber;

public class TasksAdapter extends BaseAdapter<TodoItemsItem, TasksAdapter.TaskViewHolder> {

    private Context context;

    TasksAdapter(Context context) {
        this.context = context;
    }

    AdapterCallback callback;

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

    class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
            itemView.setOnClickListener(v -> { callback.onTaskSelected(task); });
        }

        @Override
        public void onClick(View v) {  }
    }

    public interface AdapterCallback{
        void onTaskSelected(TodoItemsItem task);
    }
}
