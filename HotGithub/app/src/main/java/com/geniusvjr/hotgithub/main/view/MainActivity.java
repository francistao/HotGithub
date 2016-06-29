package com.geniusvjr.hotgithub.main.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.geniusvjr.hotgithub.R;
import com.geniusvjr.hotgithub.hotgit.view.HotFragment;
import com.geniusvjr.hotgithub.main.MainView;
import com.geniusvjr.hotgithub.main.presenter.MainPresenter;
import com.geniusvjr.hotgithub.main.presenter.MainPresenterImpl;


public class MainActivity extends AppCompatActivity implements MainView{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawerContent(mNavigationView);

        mMainPresenter = new MainPresenterImpl(this);
        switch2Hotgit();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mMainPresenter.switchNavigation(menuItem.getItemId());
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                }
        );
    }


    @Override
    public void switch2Hotgit() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new HotFragment()).commit();
        mToolbar.setTitle(R.string.hotgithub);
    }

    @Override
    public void switch2Favorites() {

    }

    @Override
    public void switch2Custom() {

    }

    @Override
    public void switch2Settings() {

    }

    @Override
    public void switch2About() {

    }
}
