package com.softserve.academy.mosquito.activity;


import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.softserve.academy.mosquito.R;
import com.softserve.academy.mosquito.fragments.AllProjectsFragment_;
import com.softserve.academy.mosquito.fragments.LoginFragment_;
import com.softserve.academy.mosquito.fragments.MyProjectsFragment_;
import com.softserve.academy.mosquito.fragments.TaskFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_task)
public class TaskActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @ViewById(R.id.nav_view)
    NavigationView navigationView;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @AfterViews
    public void initActionBar() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                new TaskFragment_()).commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return actionBarDrawerToggle.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.tasks:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                        new TaskFragment_()).commit();
                break;
            case R.id.my_projects:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                        new MyProjectsFragment_()).commit();
                break;
            case R.id.all_projects:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                        new AllProjectsFragment_()).commit();
                break;
            case R.id.logout:
                SharedPreferences.Editor preferences = getSharedPreferences("Credentials", MODE_PRIVATE).edit();
                preferences.remove("Authorization").remove("userId").apply();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                        new LoginFragment_()).commit();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();

    }
}
