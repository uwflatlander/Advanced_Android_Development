package com.example.android.sunshine.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tim on 9/28/2015.
 */
public class LocationEditTextPreference extends EditTextPreference {
    private static final String LOG_TAG = LocationEditTextPreference.class.getSimpleName();
    private int mMinLength;
    private static final int DEFAULT_MIN_LOCATION_LENGTH = 2;

    @Override
    protected View onCreateView(ViewGroup parent) {
        Log.v(LOG_TAG, "Min length: " + mMinLength);
        return super.onCreateView(parent);
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
