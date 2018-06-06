package demo.teamwork.aquidigital.common.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;

import static java.util.Objects.requireNonNull;

public abstract class BaseActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        handleBackButton();
    }

    protected final <T extends Fragment> void showFragment( Class<T> fragmentClass) {
        showFragment(R.id.fragment_container, fragmentClass, null, false);
    }

    @SuppressLint("StringFormatInvalid")
    public final <T extends Fragment> void showFragment(@IdRes int fragmentPlaceholder, Class<T> fragmentClass, Bundle bundle, boolean addToBackStack) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentClass.getSimpleName());

        if (fragment == null) {
            try {
                fragment = fragmentClass.newInstance();

                fragment.setArguments(bundle);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(getApplicationContext().getString(R.string.fragment_not_created_message, e));
            }
        }

        addCustomTransitionAnimation(fragmentPlaceholder, fragmentClass, fragmentTransaction, fragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    public void popFragmentBackStack() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }
    }

    protected void shouldShowActionBarUpButton() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        } else {
            requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }
    }

    public void onBackStackChanged() {
        shouldShowActionBarUpButton();
    }

    private <T extends Fragment> void addCustomTransitionAnimation(@IdRes int fragmentPlaceholder, Class<T> fragmentClass, FragmentTransaction fragmentTransaction, Fragment fragment) {
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        fragmentTransaction.replace(fragmentPlaceholder, fragment, fragmentClass.getSimpleName());
    }

    protected Snackbar makeSnackBar(@IdRes int hostLayoutId, String message) {
        Snackbar mySnackbar = Snackbar.make(findViewById(hostLayoutId),
                message, Snackbar.LENGTH_SHORT);
        mySnackbar.show();
        return mySnackbar;
    }

    protected abstract int getLayout();


    protected void handleBackButton() {
        getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            int stack = getSupportFragmentManager().getBackStackEntryCount();
            if (stack > 0) {
                requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            } else {
                requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
                getSupportActionBar().setHomeButtonEnabled(false);
            }
        });
    }
}
