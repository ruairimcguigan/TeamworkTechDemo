package demo.teamwork.aquidigital.people;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;
import demo.teamwork.aquidigital.people.models.PeopleItem;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static butterknife.ButterKnife.bind;
import static java.util.Objects.requireNonNull;

public class ViewPeopleFragment extends BaseFragment implements ViewPeopleContract.View {

    @Inject ViewPeoplePresenter presenter;

    @BindView(R.id.people_list)
    RecyclerView peopleList;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private ViewPeopleAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        bind(this, view);
        setAdapter();

        ((TeamworkApplication) getActivity().getApplication()).getAppComponent().inject(this);

        return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_people;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
        presenter.loadPeople();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requireNonNull(getActivity()).setTitle("People");
    }

    @Override
    public void showPeople(List<PeopleItem> people) {
        adapter.setData(people);
    }

    @Override
    public void onError(Throwable throwable) {
        showRetrySnackbar(R.string.project_load_failed, R.string.retry,
                view -> presenter.loadPeople());
    }

    @Override
    public void setAdapter() {
        adapter = new ViewPeopleAdapter(getActivity());

        peopleList.setLayoutManager(new LinearLayoutManager(getActivity()));
        peopleList.setHasFixedSize(true);
        peopleList.setAdapter(adapter);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detach();
    }
}
