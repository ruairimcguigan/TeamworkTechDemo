package demo.teamwork.aquidigital.tasks;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;
import demo.teamwork.aquidigital.common.injection.FragmentComponent;

public class TasksFragment extends BaseFragment implements TaskContract.View{

    @Inject
    TaskPresenter presenter;

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);

        ((TeamworkApplication) getActivity().getApplication()).getAppComponent().inject(this);
        Toast.makeText(getActivity(), "TasksFragment", Toast.LENGTH_SHORT).show();
        return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_tasks;
    }


    @Override
    protected void attachView() {

    }

    @Override
    protected void detachPresenter() {

    }
}
