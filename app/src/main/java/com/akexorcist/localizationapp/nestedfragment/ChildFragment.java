package com.akexorcist.localizationapp.nestedfragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.akexorcist.localizationapp.R;

/**
 * Created by Akexorcist on 7/22/15 AD.
 */
public class ChildFragment extends Fragment {
    private final String KEY_SCROLL_Y = "scroll_y";

    private ScrollView svAppleStory;

    public static Fragment newInstance() {
        return new ChildFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nested_child, container, false);
        svAppleStory = rootView.findViewById(R.id.sv_apple_story);

        if (savedInstanceState != null) {
            // Restore y-position of scroll view.
            svAppleStory.scrollTo(0, savedInstanceState.getInt(KEY_SCROLL_Y));
        }

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save y-position of scroll view.
        outState.putInt(KEY_SCROLL_Y, svAppleStory.getScrollY());
        super.onSaveInstanceState(outState);
    }
}

