package demo.teamwork.aquidigital.util.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.createproject.models.TagItem;
import demo.teamwork.aquidigital.viewprojects.model.ProjectItem;
import timber.log.Timber;

import static java.lang.Integer.valueOf;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public class ViewUtil {


    @Inject
    public ViewUtil() { }

    public List<String> getCompanyNames(List<ProjectItem> projectItems) {
        List<String> companyNames = new ArrayList<>();
        for (ProjectItem p : projectItems) {
            companyNames.add(p.getCompany().getName());
        }
        return companyNames;
    }

    public List<String> getTagNames(List<TagItem> tagItems) {
        List<String> tagNames = new ArrayList<>();

        for (TagItem t : tagItems) {
            tagNames.add(t.getName());
        }
        Timber.i("getTagsNames:", tagNames.toString());
        return tagNames;
    }

    public List<Integer> getCategories(List<ProjectItem> projectItems) {
        List<Integer> categories = new ArrayList<>();
        for (ProjectItem p : projectItems) {
            categories.add(valueOf(p.getCategory().getId()));
        }
        return categories;
    }

    public void setVisibility(View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    private void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);

        if (imm != null && imm.isAcceptingText()) {
            (imm).hideSoftInputFromWindow(requireNonNull(activity.getCurrentFocus()).getWindowToken(), 0);
        }
    }

    public void handleSoftKeyBoardVisibility(Activity activity, ViewGroup contentView, View... views) {
        for (View v : views) {
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

    public String formatDateForDisplay(int day, int month, int year){
        return String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
    }

    public String formatForRequest(int year, int month, int day){

        String formatted = "";

        if (day < 10 && month < 10){
            formatted = String.valueOf(year).concat(prefixWithZeroFormat(month).concat(prefixWithZeroFormat(day)));
        }
        else if (month < 10) {
            formatted = String.valueOf(year).concat(prefixWithZeroFormat(month).concat(String.valueOf(day)));
        }
        else if (day < 10){
            formatted = String.valueOf(year).concat(String.valueOf(month).concat(prefixWithZeroFormat(day)));
        }
        return formatted;
    }

    @SuppressLint("DefaultLocale")
    String prefixWithZeroFormat(int value) {
        return format("%02d", value);
    }
}
