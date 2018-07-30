package com.example.user.cs496.Adapter;

/**
 * Created by user on 2018-07-31.
 */

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.user.cs496.Fragment_Bottom_Nav.FragmentFAQ;
import com.example.user.cs496.Fragment_Bottom_Nav.FragmentFood;
import com.example.user.cs496.Fragment_Bottom_Nav.FragmentToDoList;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public MyPagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                FragmentFAQ tab1 = new FragmentFAQ();
                return tab1;
            case 1:
                FragmentFood tab2 = new FragmentFood();
                return  tab2;
            case 2:
                FragmentToDoList tab3 = new FragmentToDoList();

                return  tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}