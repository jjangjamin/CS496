package com.example.user.cs496;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by ar-android on 15/10/2015.
 */
public class FragmentAnnouncement extends Fragment{
    public FragmentAnnouncement() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_announcement, container, false);
    }
}