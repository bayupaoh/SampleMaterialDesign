package me.bayupaoh.workshopmaterial;

import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declarationWidget();
        setToolbar();
        setNavigationDrawer();
    }

    private void setNavigationDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(navItemSelect);
    }

    NavigationView.OnNavigationItemSelectedListener navItemSelect = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            menuItem.setCheckable(true);
            drawer.closeDrawer(GravityCompat.START);

            switch (menuItem.getItemId()){
                case R.id.id_menu_home:
                    Snackbar.make(getCurrentFocus(),"Anda memilih menu HOME",Snackbar.LENGTH_LONG).show();
                    return true;
                case R.id.id_menu_profil :
                    Snackbar.make(getCurrentFocus(),"Anda memilih menu Profil",Snackbar.LENGTH_LONG).show();
                    return true;
                case R.id.id_menu_addres :
                    Snackbar.make(getCurrentFocus(),"Anda memilih menu Address",Snackbar.LENGTH_LONG).show();
                    return true;
                default:
                    return true;
            }
        }
    };

    private void setToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void declarationWidget() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_drawer);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }
}
