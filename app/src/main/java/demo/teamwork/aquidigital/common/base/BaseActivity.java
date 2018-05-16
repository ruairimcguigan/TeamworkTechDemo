package demo.teamwork.aquidigital.common.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.LongSparseArray;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.concurrent.atomic.AtomicLong;

import butterknife.ButterKnife;
import demo.teamwork.aquidigital.R;
import demo.teamwork.aquidigital.common.injection.ConfigPersistentComponent;
import demo.teamwork.aquidigital.home.HomeActivity;
import timber.log.Timber;

/**
 * Abstract activity that every other Activity in this application must implement. It provides the
 * following functionality: - Handles creation of Dagger components and makes sure that instances of
 * ConfigPersistentComponent are kept across configuration changes. - Handles signing out
 * when an authentication error event is received.
 */
public abstract class BaseActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private static final String KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID";
    private static final AtomicLong NEXT_ID = new AtomicLong(0);
    private static final LongSparseArray<ConfigPersistentComponent> componentsArray =
            new LongSparseArray<>();

    private long activityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        handleBackButton();

        // Create the ActivityComponent and reuses cached ConfigPersistentComponent if this is
        // being called after a configuration change.
        activityId =
                savedInstanceState != null
                        ? savedInstanceState.getLong(KEY_ACTIVITY_ID)
                        : NEXT_ID.getAndIncrement();

        ConfigPersistentComponent configPersistentComponent;

//        if (componentsArray.get(activityId) == null) {
//
//            Timber.i("Creating new ConfigPersistentComponent id=%d", activityId);
//            configPersistentComponent = DaggerConfigPersistentComponent.builder()
//                    .appComponent(TeamworkApplication.get(this).getComponent())
//                    .build();
//
//            componentsArray.put(activityId, configPersistentComponent);
//        } else {
//
//            Timber.i("Reusing ConfigPersistentComponent id=%d", activityId);
//            configPersistentComponent = componentsArray.get(activityId);
//        }
//        ActivityComponent activityComponent =
//                configPersistentComponent.activityComponent(new ActivityModule(this));
//
//        inject(activityComponent);

        attachView();
    }

    protected final <T extends Fragment> void showFragment(@IdRes int fragmentPlaceholder, Class<T> fragmentClass) {
        showFragment(fragmentPlaceholder, fragmentClass, null, false);
    }

    @SuppressLint("StringFormatInvalid")
    protected final <T extends Fragment> void showFragment(@IdRes int fragmentPlaceholder, Class<T> fragmentClass, Bundle bundle, boolean addToBackStack) {

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
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    protected void showActionbarTitle() {
        if (getActionBar() != null) {
            getActionBar().setDisplayShowTitleEnabled(true);
        }
    }

    protected void hideActionbarTitle() {
        if (getActionBar() != null) {
            getActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    protected abstract int getLayout();

    protected abstract void attachView();

    protected abstract void detachPresenter();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startParentActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startParentActivity() {
        finish();
        startActivity(new Intent(this, HomeActivity.class));
    }

    protected void handleBackButton() {
        getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            int stack = getSupportFragmentManager().getBackStackEntryCount();
            if (stack > 0) {
                getSupportActionBar().setHomeButtonEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            } else {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                getSupportActionBar().setHomeButtonEnabled(false);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(KEY_ACTIVITY_ID, activityId);
    }

    @Override
    protected void onDestroy() {
        if (!isChangingConfigurations()) {
            Timber.i("Clearing ConfigPersistentComponent id=%d", activityId);
            componentsArray.remove(activityId);
        }
        detachPresenter();
        super.onDestroy();
    }
}
