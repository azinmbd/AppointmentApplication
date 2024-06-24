package com.example.appointmentapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private TextView userEmailTXV, userNameTXV;
    private Button backToMain, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().hide();

        userNameTXV = findViewById(R.id.userNameTXV);
        userEmailTXV = findViewById(R.id.userEmailTXV);
        backToMain = findViewById(R.id.backToMain);
        logout = findViewById(R.id.logout);

        // Retrieve login information from data source (e.g., SharedPreferences)
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String email = sharedPreferences.getString("email", "");

        // Set the retrieved information to the TextViews
        userNameTXV.setText(name);
        userEmailTXV.setText(email);


        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the profile activity
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the profile activity
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}



