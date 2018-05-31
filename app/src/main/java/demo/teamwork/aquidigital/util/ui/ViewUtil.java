package demo.teamwork.aquidigital.util.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import demo.teamwork.aquidigital.repository.api.addprojectmodel.TagsItem;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectItem;
import timber.log.Timber;

import static java.lang.Integer.valueOf;
import static java.lang.String.*;
import static java.lang.String.valueOf;
import static java.util.Objects.requireNonNull;

public class ViewUtil {

    private Context context;

    public ViewUtil(Context context) {
        this.context = context;
    }

    public static List<String> getCompanyNames(List<ProjectItem> projectItems) {
        List<String> companyNames = new ArrayList<>();
        for (ProjectItem p : projectItems) {
            companyNames.add(p.getCompany().getName());
        }
        return companyNames;
    }

    public static List<String> getTagNames(List<TagsItem> tagsItems) {
        List<String> tagNames = new ArrayList<>();

        for (TagsItem t : tagsItems) {
            tagNames.add(t.getName());
        }
        Timber.i("getTagsNames:", tagNames.toString());
        return tagNames;
    }

    public static List<Integer> getCategories(List<ProjectItem> projectItems) {
        List<Integer> categories = new ArrayList<>();
        for (ProjectItem p : projectItems) {
            categories.add(valueOf(p.getCategory().getId()));
        }
        return categories;
    }

    public static void setVisibility(View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    private static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);

        if (imm != null && imm.isAcceptingText()) {
            (imm).hideSoftInputFromWindow(requireNonNull(activity.getCurrentFocus()).getWindowToken(), 0);
        }
    }

    public static void handleSoftKeyBoardVisibility(Activity activity, ViewGroup contentView, View... views) {
        for (View v: views) {
            if (!(v instanceof EditText)) {
                v.setOnTouchListener((v1, event) -> {
                    v1.performClick();
                    contentView.requestFocus();
                    hideKeyboard(requireNonNull(activity));
                    return false;
                });
            }
        }
    }

    public static String formatDateForDisplay(int day, int month, int year){
        return String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
    }

    public static String formatForRequest(int year, int month, int day){
        String fjdkj = String.valueOf(year).concat("0" + String.valueOf(month).concat(String.valueOf(day)));
        return fjdkj;
    }

}
