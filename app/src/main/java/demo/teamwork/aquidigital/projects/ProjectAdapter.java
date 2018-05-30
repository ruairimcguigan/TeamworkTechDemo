package demo.teamwork.aquidigital.projects;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.common.base.BaseAdapter;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectItem;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectsResponse;

public class ProjectAdapter extends BaseAdapter<ProjectItem, ProjectAdapter.ProjectViewHolder> {

    private Context context;
    private List<ProjectItem> projectItemList = new ArrayList<>();
    private ProjectsResponse projectsResponse = new ProjectsResponse();

    ProjectAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.project_item, parent, false);

        final ProjectViewHolder viewHolder = new ProjectViewHolder(view);
        viewHolder.itemView.setOnClickListener(v -> onItemClicked(viewHolder.getAdapterPosition()));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        ProjectItem projectItem = (ProjectItem) getItem(position);
        projectItemList.add(projectItem);

        projectsResponse.setProjectItems(projectItemList);

        holder.populate(projectItem);
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.project_logo)
        ImageView projectLogo;

        @BindView(R.id.project_name)
        TextView projectName;

        @BindView(R.id.project_description)
        TextView projectDescription;

        @BindView(R.id.project_is_starred)
        ImageView projectIsStarred;

        ProjectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void populate(ProjectItem projectItem) {
            projectLogo.setImageURI(Uri.parse(projectItem.getLogo()));
            projectName.setText(projectItem.getName());
            projectDescription.setText(projectItem.getDescription());
            setProjectStarred(projectItem);

            startProjectDetailsActivityOnViewSelect(projectItem);
        }

        private void startProjectDetailsActivityOnViewSelect(ProjectItem projectItem) {
            itemView.setOnClickListener(v -> {
                Context context = v.getContext();

                Intent intent = new Intent(context, ProjectDetailsActivity.class);
                intent.putExtra(ProjectDetailsActivity.EXTRA_PROJECTS_LIST, projectsResponse);
                intent.putExtra(ProjectDetailsActivity.EXTRA_NAME, projectItem.getName());
                intent.putExtra(ProjectDetailsActivity.EXTRA_LOGO, projectItem.getLogo());

                context.startActivity(intent);
            });
        }

        private void setProjectStarred(ProjectItem projectItem) {
            if (projectItem.isStarred()){
                projectIsStarred.setImageResource(android.R.drawable.btn_star);
            }
        }
    }
}
