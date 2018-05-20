package demo.teamwork.aquidigital.people;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.common.base.BaseFragment;

public class PeopleFragment extends BaseFragment implements PeopleContract.View{

    @Inject
    PeoplePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);

        ((TeamworkApplication) getActivity().getApplication()).getAppComponent().inject(this);
        Toast.makeText(getActivity(), "PeopleFragment", Toast.LENGTH_SHORT).show();
        return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_people;
    }

}
