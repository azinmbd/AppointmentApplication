package com.example.appointmentapplication;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {

    private EditText eamilInput, passwordInput;
    private Button login, NoAccount;
    private SharedPreferences sharedPreferences;
    private TextView errorTextView;

    protected void onCreate(Bundle savedInstanceState) {
        // Initialize SharedPreferences
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        //hiding the default toolbar
        getSupportActionBar().hide();


        // Initialize views
        eamilInput = findViewById(R.id.eamilInput);
        passwordInput = findViewById(R.id.passwordInput);
        login = findViewById(R.id.login);
        errorTextView = findViewById(R.id.errorTextView2);
        NoAccount = findViewById(R.id.NoAccount);

        // Set click listener for login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String email = eamilInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                // Retrieve stored user information from SharedPreferences
                String storedEmail = sharedPreferences.getString("email", "");
                String storedPassword = sharedPreferences.getString("password", "");

                // Check if input matches stored information
                if (email.equals(storedEmail) && password.equals(storedPassword)) {
                    // Successful login
                    // Move to next activity
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                    finish();
                } else {
                    // Invalid login
                    // Show error message
                    errorTextView.setBackgroundColor(Color.parseColor("#99D16B6B"));
                    errorTextView.setText("Eamil or Password are wrong. Try again!");
                }
            }
        });

        NoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }
}