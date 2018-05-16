package demo.teamwork.aquidigital.projects;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import demo.teamwork.aquidigital.common.base.BaseAdapter;
import demo.teamwork.aquidigital.repository.apimodel.Project;

public class ProjectAdapter extends BaseAdapter<Project, RecyclerView.ViewHolder> {

    private final int TYPE_PROJECT= 0;
    private final int TYPE_PROJECT_LOADING = 1;
    private final int TYPE_ERROR = 2;

    private Context context;

    public ProjectAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
