package demo.teamwork.aquidigital.projects.addproject;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.repository.api.projectsmodel.Project;

import static butterknife.ButterKnife.bind;

public class AddProjectSpinnerAdapter extends ArrayAdapter<Project> {

    @BindView(R.id.project_logo)
    ImageView logo;

    @BindView(R.id.project_name)
    TextView name;

    private Context context;
    private List<Project> projectList;

    public AddProjectSpinnerAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return AddProjectSpinnerView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return AddProjectSpinnerView(position, convertView, parent);
    }

    private View AddProjectSpinnerView(int position, @Nullable View view, ViewGroup parent){
        View v = LayoutInflater.from(context).inflate(R.layout.project_spinner_item, null);
        ButterKnife.bind(this,v);

        logo.setImageURI(Uri.parse(projectList.get(position).getLogo()));
        name.setText(projectList.get(position).getName());

//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//        View addProjectView = inflater.inflate(R.layout.project_spinner_item, parent, false);
        return v;
    }

    public void setData(List<Project> data){
        projectList.addAll(data);
    }

}
