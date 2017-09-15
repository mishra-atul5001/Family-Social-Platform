package com.example.mishr.myapplication;

import android.os.Bundle;
import android.support.design.internal.TextScale;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.transitionseverywhere.extra.Scale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FloatingActionButton fab;
    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // tx = (TextView)findViewById(R.id.textviewagic);
         fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Thanks for the Like..!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();  //This is a Snack Bar
               // Toast.makeText(getApplicationContext(),"Thanks for the Like..!!",Toast.LENGTH_SHORT).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       switch (item.getItemId()){
           case R.id.love:
               Toast.makeText(getApplicationContext(),"Yeah We love too to make you feel Happy..!!",Toast.LENGTH_SHORT).show();
               break;

           case R.id.Contact:
               Toast.makeText(getApplicationContext(),"Contact @ 8939445650",Toast.LENGTH_LONG).show();

               break;
           case R.id.suggestions:
               Toast.makeText(getApplicationContext(),"Mail @ mishra.atul775@gmail..!!",Toast.LENGTH_LONG).show();
               break;
       }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the home action
            HomeFragment homeFragment = new HomeFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layout,homeFragment,homeFragment.getTag()).commit();
        } else if (id == R.id.freinds) {
            // Handle the freinds action
            FreindsFragment freindsFragment = new FreindsFragment();
            FragmentManager fragmentManager1 = getSupportFragmentManager();
            fragmentManager1.beginTransaction().replace(R.id.layout,freindsFragment,freindsFragment.getTag()).commit();

        } else if (id == R.id.messages) {
            //Handles the Messages Fragment here

            MessageFragment messageFragment = new MessageFragment();
            FragmentManager fragmentManager2 = getSupportFragmentManager();
            fragmentManager2.beginTransaction().replace(R.id.layout,messageFragment,messageFragment.getTag()).commit();



        } else if (id == R.id.settings) {
            //Handle the Settings Fragment here

            SettingsFragment settingsFragment = new SettingsFragment();
            FragmentManager fragmentManager3 = getSupportFragmentManager();
            fragmentManager3.beginTransaction().replace(R.id.layout,settingsFragment,settingsFragment.getTag()).commit();



        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

  /*  public void DoMagic(View view) {
        final ViewGroup transitionsContainer = (ViewGroup) view.findViewById(R.id.transitions_container);

        boolean visible=true;

        TransitionSet set = new TransitionSet()
                        .addTransition(new TextScale())
                .addTransition(new Fade())
                .setInterpolator(visible ? new LinearOutSlowInInterpolator() :
                        new FastOutLinearInInterpolator());

        TransitionManager.beginDelayedTransition(transitionsContainer, set);
        tx.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);

    }  */
}
