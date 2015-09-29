package com.example.android.sunshine.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Tim on 9/28/2015.
 */
public class LocationEditTextPreference extends EditTextPreference {
    private static final String LOG_TAG = LocationEditTextPreference.class.getSimpleName();
    private int mMinLength;
    private static final int DEFAULT_MIN_LOCATION_LENGTH = 2;

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);

        EditText editText = getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Dialog dialog = getDialog();
                if (dialog instanceof AlertDialog) {
                    AlertDialog alertDialog = (AlertDialog) dialog;
                    Button okButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    if(s.length() < mMinLength)
                    {
                        okButton.setEnabled(false);
                    }
                    else
                    {
                        okButton.setEnabled(true);
                    }
                }
            }
        });
    }

    public LocationEditTextPreference(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(
                attributeSet
                ,R.styleable.LocationEditTextPreference
                ,0,0);

        try {
            mMinLength = typedArray.getInt(R.styleable.LocationEditTextPreference_minLength, DEFAULT_MIN_LOCATION_LENGTH);
        }
        finally {
            typedArray.recycle();
        }

    }
}
