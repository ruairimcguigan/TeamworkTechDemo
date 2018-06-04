package demo.teamwork.aquidigital.people;

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
import demo.teamwork.aquidigital.repository.api.peoplemodel.PeopleItem;

public class ViewPeopleAdapter extends BaseAdapter<PeopleItem, ViewPeopleAdapter.TaskViewHolder> {

    private Context context;

    ViewPeopleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.people_item, parent, false);

        final TaskViewHolder viewHolder = new TaskViewHolder(view);
        viewHolder.itemView.setOnClickListener(v -> onItemClicked(viewHolder.getAdapterPosition()));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        PeopleItem task = (PeopleItem) getItem(position);
        holder.populate(task);
    }

    class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.people_image)
        ImageView personImage;

        @BindView(R.id.people_name)
        TextView personName;

        @BindView(R.id.people_email)
        TextView personEmail;

        @BindView(R.id.people_address)
        TextView personAddress;

        TaskViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void populate(PeopleItem peopleItem) {
            personImage.setImageURI(Uri.parse(peopleItem.getAvatarUrl()));
            personName.setText(peopleItem.getFirstName() + " " + peopleItem.getLastName());
            personEmail.setText(peopleItem.getEmailAddress());
            personAddress.setText(peopleItem.getAddressCountry());
        }

        @Override
        public void onClick(View v) {  }
    }
}
