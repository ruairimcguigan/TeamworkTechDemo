package demo.teamwork.aquidigital.projects;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.common.base.BaseAdapter;
import demo.teamwork.aquidigital.repository.api.apimodel.Project;

public class ProjectAdapter extends BaseAdapter<Project, ProjectAdapter.ProjectViewHolder> {

    private final int TYPE_PROJECT = 0;
    private final int TYPE_PROJECT_LOADING = 1;
    private final int TYPE_ERROR = 2;

    private Context context;

    ProjectAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.project_item, parent, false);

        final ProjectViewHolder viewHolder = new ProjectViewHolder(view);
        viewHolder.itemView.setOnClickListener(v -> onItemClicked(viewHolder.getAdapterPosition()));


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Project project = (Project) getItem(position);
        holder.populate(project);
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.project_logo)
        ImageView projectLogo;

        @BindView(R.id.project_name)
        TextView projectName;

        @BindView(R.id.project_is_starred)
        ImageView projectIsStarred;

        ProjectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void populate(Project project) {
            projectLogo.setImageURI(Uri.parse(project.getLogo()));
            projectName.setText(project.getName());
            setProjectStarred(project);
        }

        private void setProjectStarred(Project project) {
            if (project.isStarred()){
                projectIsStarred.setImageResource(android.R.drawable.btn_star);
            }
        }
    }
}
