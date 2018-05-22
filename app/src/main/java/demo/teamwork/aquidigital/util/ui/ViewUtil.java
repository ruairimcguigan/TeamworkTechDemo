package demo.teamwork.aquidigital.util.ui;

import android.view.View;

public class ViewUtil {

    public static void setVisibility(View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }
}
