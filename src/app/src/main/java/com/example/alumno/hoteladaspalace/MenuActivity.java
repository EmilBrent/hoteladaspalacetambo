package com.example.alumno.hoteladaspalace;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.alumno.hoteladaspalace.Fragments.AboutUsFragment;
import com.example.alumno.hoteladaspalace.Fragments.AccountFragment;
import com.example.alumno.hoteladaspalace.Fragments.ContacUsFragment;
import com.example.alumno.hoteladaspalace.Fragments.ContentFragment;
import com.example.alumno.hoteladaspalace.Fragments.CurrentRoomFragment;
import com.example.alumno.hoteladaspalace.Fragments.GalleryFragment;
import com.example.alumno.hoteladaspalace.Fragments.MapFragment2;
import com.example.alumno.hoteladaspalace.Fragments.Registro;
import com.example.alumno.hoteladaspalace.Fragments.Reservation_BeedromFragment;
import com.example.alumno.hoteladaspalace.Fragments.RoomListFragment;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();

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
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_camera) {

            fragmentManager.beginTransaction().replace(R.id.menu,new RoomListFragment()).commit();
        } else if (id == R.id.nav_reserva) {
            fragmentManager.beginTransaction().replace(R.id.menu,new Registro()).commit();
        } else if (id == R.id.nav_gallery) {
            fragmentManager.beginTransaction().replace(R.id.menu,new GalleryFragment()).commit();
        } else if (id == R.id.nav_slideshow) {
            fragmentManager.beginTransaction().replace(R.id.menu,new AboutUsFragment()).commit();
        } else if (id == R.id.nav_manage) {
            fragmentManager.beginTransaction().replace(R.id.menu,new ContacUsFragment()).commit();

        } else if (id == R.id.nav_send) {
            fragmentChange("maps");
        }else if (id ==R.id.show_my_account){
            fragmentChange("my-account");
        }

            //} else if (id == R.id.nav_share) {

        //} else if (id == R.id.nav_send) {



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void fragmentChange(String _fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if ( _fragment.equals("habitacion") ) {
            fragmentManager.beginTransaction().replace(R.id.menu,new CurrentRoomFragment()).commit();
        }
        else if (_fragment.equals("my-account")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.menu,new AccountFragment()).addToBackStack(null).commit();
        }
        else if ( _fragment.equals("maps") ) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.menu, new MapFragment2()).addToBackStack(null).commit();
        }


    }
}
