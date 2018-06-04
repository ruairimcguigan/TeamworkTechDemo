package demo.teamwork.aquidigital.util.ui;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class AfterTextWatcher implements TextWatcher {

    public abstract void changed(Editable editable);

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        changed(editable);
    }
}
