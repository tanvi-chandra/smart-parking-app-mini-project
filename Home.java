package com.example.mad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    CardView cd1,cd2,cd3,cd4;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Smart Parking");

        setContentView(R.layout.activity_home);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigationView);
        cd1=(CardView) findViewById(R.id.cd_mangalore);
        cd2=(CardView) findViewById(R.id.cd_moodbidre);
        cd3=(CardView) findViewById(R.id.cd_belthangady);
        cd4=(CardView) findViewById(R.id.cd_udupi);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.menu_Open,R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            private MenuItem item;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                this.item = item;
                //int id = item.getItemId();
                switch (item.getItemId()){
                    case 1:
                    int i = Log.i("MENU_DRAWER_TAG", "Home is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                   break;
                    /*case 2:
                    Log.i("MENU_DRAWER_TAG", "Search is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;*/
                    case 3:
                    Log.i("MENU_DRAWER_TAG", "Bookings is clicked");
                    Intent intent = new Intent(Home.this, bookdisplay.class);
                    startActivity(intent);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                } /*else if (id == R.id.nav_logout) {
                    Log.i("MENU_DRAWER_TAG", "logout is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                   // break;
                }*/

                return true;
            }
        });
        cd1.setOnClickListener(new View.OnClickListener() {
            private View view;
            @Override
            public void onClick(View view) {
                this.view=view;
                String cn="MANGALORE";
                Intent intentt=new Intent(getApplicationContext(),booking.class);
                intentt.putExtra("city",cn);
                startActivity(intentt);
            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cn="MANGALORE";
               /* Intent intentt=new Intent(getApplicationContext(),booking.class);
                intentt.putExtra("city",cn);
                startActivity(intentt);*/
            }
        });
        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cn="MANGALORE";
                /*Intent intentt=new Intent(getApplicationContext(),booking.class);

                intentt.putExtra("city",cn);
                startActivity(intentt);*/
            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cn="MANGALORE";
                /*Intent intentt=new Intent(getApplicationContext(),booking.class);
                intentt.putExtra("city",cn);
                startActivity(intentt);*/
            }
        });

    }
}