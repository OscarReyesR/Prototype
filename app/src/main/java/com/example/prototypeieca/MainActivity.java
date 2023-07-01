package com.example.prototypeieca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    DrawerLayout drawerLayout;
NavigationView navigationView;
ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onPostResume() {
        super.onPostResume();
        /*
        Intent intent=new Intent(this,LoginClass.class);
        startActivity(intent);*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.openNav,R.string.closeNav);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                openActivity(item.getItemId());
                return false;
            }
        });
    }

    private void openActivity(int idActivityToStart)
    {
        Intent intent;
        switch (idActivityToStart)
        {
            case R.id.courseSummary:
            {
                intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.rules:
            {
                intent=new Intent(this,Rules.class);
                startActivity(intent);
                break;
            }
            case R.id.classAgenda:
            {
                intent=new Intent(this,ClassAgenda.class);
                startActivity(intent);
                break;
            }
            case R.id.sessions:
            {
                intent=new Intent(this,ClassSessions.class);
                startActivity(intent);
                break;
            }
            case R.id.logOut:
            {
                intent=new Intent(this,LoginClass.class);
                startActivity(intent);
                break;
            }
        }
    }//end function openActivity
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}