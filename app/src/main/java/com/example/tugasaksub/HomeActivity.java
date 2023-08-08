package com.example.tugasaksub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNav);
        initBotNavView();
        TextView dpUsername1 = findViewById(R.id.display_username);
        TextView dpEmail1 = findViewById(R.id.display_email);

        SharedPreferences sharedPref =  PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String emailnew = sharedPref.getString("dpEmail", "default@gmail.com");
        String usernamenew = sharedPref.getString("dpUsername", "text default");
        dpUsername1.setText("Hi, "+usernamenew);
        dpEmail1.setText(emailnew);
    }

    private void initBotNavView(){
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.home :
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
//                        return true;
//                    case R.id.profile :
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ProfileFragment()).commit();
//                        return true;
//                    case R.id.favorite:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FavoriteFragment()).commit();
//                        return true;
//
//                }
                int id = item.getItemId();
                if(id == R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
                    return true;
                }else if(id == R.id.profile){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ProfileFragment()).commit();
                    return true;
                }else if(id == R.id.favorite){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FavoriteFragment()).commit();
                    return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
}