package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_nav);
        bottomNavigation.setOnNavigationItemSelectedListener(navlistener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_c,new FragmentHome()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedfr = null;

                    switch (menuItem.getItemId()){
                        case R.id.home:
                            selectedfr = new FragmentHome();
                            break;
                        case R.id.search:
                            selectedfr = new FragmentSearch();
                            break;
                        case R.id.map:
                            selectedfr=new FragmentMap();
                            break;

                    }
                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_c,selectedfr).commit();
                  return true;
                }

            };


}
