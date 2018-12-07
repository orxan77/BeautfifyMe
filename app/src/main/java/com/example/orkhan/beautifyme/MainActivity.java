package com.example.orkhan.beautifyme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.orkhan.beautifyme.ui.HealthyFragment;
import com.example.orkhan.beautifyme.ui.HomeFragment;
import com.example.orkhan.beautifyme.ui.ProfileFragment;
import com.example.orkhan.beautifyme.ui.PromotionsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar toolbar = getSupportActionBar();
        assert toolbar != null;
        toolbar.setTitle("Beautify Me");
        loadFragment(new HomeFragment());

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_news_feed:
                    loadFragment(new HomeFragment());
                    return true;
                case R.id.navigation_promotions:
                    loadFragment(new PromotionsFragment());
                    return true;
                case R.id.navigation_healthy:
                    loadFragment(new HealthyFragment());
                    return true;
                case R.id.navigation_profile:
                    loadFragment(new ProfileFragment());
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
