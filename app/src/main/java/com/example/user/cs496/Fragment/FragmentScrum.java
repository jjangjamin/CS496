package com.example.user.cs496.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.cs496.R;


/**
 * Created by ar-android on 15/10/2015.
 */
public class FragmentScrum extends Fragment{
    public FragmentScrum() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scrum, container, false);
    }
}