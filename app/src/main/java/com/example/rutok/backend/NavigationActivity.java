package com.example.rutok.backend;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.example.rutok.AccountActivityFragment;
import com.example.rutok.R;
import com.example.rutok.SearchActivityFragment;
import com.example.rutok.VideoShowerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NavigationActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    VideoShowerFragment videoShowerFragment = new VideoShowerFragment();
    AccountActivityFragment accountActivityFragment = new AccountActivityFragment();
    SearchActivityFragment searchActivityFragment = new SearchActivityFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity);
        System.out.println("dasdqdqsdqs");
        //NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);
       // NavController navController = navHostFragment.getNavController();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,videoShowerFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                System.out.println(item.getItemId());
                switch (item.getItemId()) {
                    case R.id.videoShower:
                        Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_LONG).show();
                        System.out.println("1");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, videoShowerFragment).commit();
                        return true;


                    case R.id.accountActivity:
                        Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT).show();
                        System.out.println("2");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, accountActivityFragment).commit();
                        return true;

                    case R.id.searchActivity:
                        Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_SHORT).show();
                        System.out.println("3");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, searchActivityFragment).commit();
                        return true;

                    }
                    return false;

            }

        });




    }
}
