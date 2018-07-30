package com.example.user.cs496.Activity;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.user.cs496.Adapter.MyPagerAdapter;
import com.example.user.cs496.Fragment.FragmentAnnouncement;
import com.example.user.cs496.Fragment.FragmentScrum;
import com.example.user.cs496.Fragment.FragmentSubmit;
import com.example.user.cs496.Fragment_Bottom_Nav.FragmentFAQ;
import com.example.user.cs496.Fragment_Bottom_Nav.FragmentFood;
import com.example.user.cs496.Fragment_Bottom_Nav.FragmentToDoList;
import com.example.user.cs496.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentFAQ.OnFragmentInteractionListener, FragmentFood.OnFragmentInteractionListener, FragmentToDoList.OnFragmentInteractionListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private int activeMenu;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    private FragmentScrum fScrum = new FragmentScrum();
    private FragmentAnnouncement fAnnouncement = new FragmentAnnouncement();
    private FragmentSubmit fSubmit = new FragmentSubmit();

    private Handler handlerSaveId = new Handler();
    private long DRAWER_CLOSE_DELAY = 350;
    private String ID_MENU_ACTIVE = "IdMenuActive";
    private FloatingActionButton fab, fab1,  fab3, fab4;
    private boolean isFABOpen = false;
    private Animation fab_scale_up, fab_scale_down, rotate_forward, rotate_backward;
    private boolean isfab3Open = false;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);
        fab1 = findViewById(R.id.fab1);
        fab3 = findViewById(R.id.fab3);
        fab4 = findViewById(R.id.fab4);
        fab_scale_up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_scale_up);
        fab_scale_down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_scale_down);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(null == savedInstanceState){
            activeMenu = R.id.scrum;
        }else{
            activeMenu = savedInstanceState.getInt(ID_MENU_ACTIVE);
        }
        navigationView = (NavigationView)findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(activeMenu).setChecked(true);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        switchFragment(activeMenu);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFAB();
            }
        });
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab3();
            }
        });
    }

    private void animateFab3() {
        if (isfab3Open) {
            //  fab1.startAnimation(rotate_backward);
            fab3.startAnimation(fab_scale_down);
            fab3.setClickable(false);
            isfab3Open = false;
        } else {
            //   fab1.startAnimation(rotate_forward);
            fab3.startAnimation(fab_scale_up);
            fab3.setClickable(true);
            isfab3Open = true;
        }
    }

    public void animateFAB() {

        if (isFABOpen) {
            fab1.startAnimation(rotate_backward);
            fab1.startAnimation(fab_scale_down);
            fab1.setClickable(false);
            isFABOpen = false;

        } else {
            fab1.startAnimation(rotate_forward);
            fab1.startAnimation(fab_scale_up);
            fab1.setClickable(true);
            isFABOpen = true;

        }    }



    /**
     * for switch active fragment by sevedInstanState
     * @param activeMenu
     */
    private void switchFragment(int activeMenu) {
        switch (activeMenu){
            case R.id.scrum:
                setFragment(fScrum);
                break;
            case R.id.announcement:
                setFragment(fAnnouncement);
                break;
            case R.id.submit:
                setFragment(fSubmit);
            default:
                //Default
                break;
        }
    }

    /**
     * replace fragment by activemenu id
     * @param fragment
     */
    private void setFragment(Fragment fragment){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem menuItem) {

        menuItem.setChecked(true);
        activeMenu = menuItem.getItemId();
        drawerLayout.closeDrawer(GravityCompat.START);
        handlerSaveId.postDelayed(new Runnable() {
            @Override
            public void run() {
                switchFragment(menuItem.getItemId());
            }
        }, DRAWER_CLOSE_DELAY);

        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    /**
     * to case active id menu
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ID_MENU_ACTIVE, activeMenu);
    }
}