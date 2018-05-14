package demo.teamwork.aquidigital.util.ui;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterNameInputFilter implements InputFilter {

    private Pattern pattern;

    private static final String EMPTY = "";

    public CharacterNameInputFilter() {
        pattern = Pattern.compile("^[a-zA-Z]+$");
    }

    private boolean validateReference(String value) {
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

        String concat = new StringBuilder(dest).insert(dstart, source.toString()).toString();

        if (validateReference(concat)) {
            return source;
        } else {
            return EMPTY;
        }
    }
}