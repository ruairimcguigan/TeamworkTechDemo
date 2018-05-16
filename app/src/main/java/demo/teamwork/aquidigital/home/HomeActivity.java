package demo.teamwork.aquidigital.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.TeamworkApplication;
import demo.teamwork.aquidigital.home.HomeContract.View;

public class HomeActivity extends AppCompatActivity implements View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TeamworkApplication) getApplication()).getAppComponent().inject(this);
    }
}
