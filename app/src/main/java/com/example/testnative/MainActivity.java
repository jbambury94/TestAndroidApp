package com.example.testnative;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;
import sdk.pendo.io.*;
import java.util.HashMap;

import com.example.testnative.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String pendoApiKey = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhY2VudGVyIjoiZXUiLCJrZXkiOiJmNWI1YWYxYWRiYTc2ZmQwNGI0YzE1N2M2ZjdiZGI1Njc1NDhkY2QxN2ZkNDQzODQwN2Q4OWRiNzQ3MjVmZmI4M2NjZDEyNWFhMGE2NTZmNDA1ZmU5YjVjYzNjMmZhNmQzODVmM2YxZjJiOTQ4ODA1Y2Y5YWIzYzgyNTRhZTY4NzkwYzdhOGM3MTIyYzJlZDllNTZhM2EwOTQwNTA0NDM1YjRlYjE2ZDRkOGRjZWJkMTg2MjM2N2VlZGZjNDI1MDg2NWY0ZTJhYTU4Y2Y4NTc0MmM4MTExODAwOTFjZTI3MGU3NjNlZDM3MWNkZmM3ZjAxNWYyYjM5ZGI4YmIwMTZkODc3ZDRjNjc1YzE0N2YxMWFiMTM4NzRiMjY4YmE4M2IuNTFiZmJkOTBhZjA0NDdjZWU5Yjk3OGJhOWIyNmVlOTcuNjg4NTBiYmU3NjQyMzBjNmVhMTkzNjU1ZWVhYmNlZTNhZmQ4N2RjYWNiMWVmZTI3YWU3NDBjYjhhMDhkZjNkZSJ9.UuEfdOOVHF6BMc91eDftz0xxtwDfBdjFUSo3ZcUK_t_pcD3TkTrmKhLilLVm66esqp5boF51INhnAavXLR1_VDeaeAoOognx1C5i-pRHdAsdjkUC2e1Bk4mQXhYN7Jh0cm--oD01lDF0XksR_cY8BDUohIHLHwU6c2ICqnl5xrQ";

        Pendo.setup(
                this,
                pendoApiKey,
                null, // PendoOptions (use only if instructed by Pendo support)
                null  // PendoPhasesCallbackInterface (Optional)
        );

        String visitorId = "VISITOR-UNIQUE-ID";
        String accountId = "ACCOUNT-UNIQUE-ID";

// send Visitor Level Data
        HashMap<String, Object> visitorData = new HashMap<>();
        visitorData.put("age", 27);
        visitorData.put("country", "USA");

// send Account Level Data
        HashMap<String, Object> accountData = new HashMap<>();
       accountData.put("Tier", 1);
       accountData.put("Size", "Enterprise");

        Pendo.startSession(
                visitorId,
                accountId,
         visitorData, accountData
        );

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        if (binding.appBarMain.fab != null) {
            binding.appBarMain.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).setAnchorView(R.id.fab).show());
        }
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();

        NavigationView navigationView = binding.navView;
        if (navigationView != null) {
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_transform, R.id.nav_reflow, R.id.nav_slideshow, R.id.nav_settings)
                    .setOpenableLayout(binding.drawerLayout)
                    .build();
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);
        }

        BottomNavigationView bottomNavigationView = binding.appBarMain.contentMain.bottomNavView;
        if (bottomNavigationView != null) {
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_transform, R.id.nav_reflow, R.id.nav_slideshow)
                    .build();
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(bottomNavigationView, navController);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        // Using findViewById because NavigationView exists in different layout files
        // between w600dp and w1240dp
        NavigationView navView = findViewById(R.id.nav_view);
        if (navView == null) {
            // The navigation drawer already has the items including the items in the overflow menu
            // We only inflate the overflow menu if the navigation drawer isn't visible
            getMenuInflater().inflate(R.menu.overflow, menu);
        }
        return result;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_settings) {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.nav_settings);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}