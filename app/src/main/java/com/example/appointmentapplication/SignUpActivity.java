package com.example.appointmentapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    private EditText nameEditText, emailEditText, passwordEditText;
    private Button signupButton, haveAccount;
    private TextView errorTextView;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //hiding the default toolbar
        getSupportActionBar().hide();

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        // Initialize views
        nameEditText = findViewById(R.id.nameInputSignup);
        emailEditText = findViewById(R.id.emailInputSignup);
        passwordEditText = findViewById(R.id.passwordInputSignup);
        signupButton = findViewById(R.id.signup);
        errorTextView = findViewById(R.id.errorTextView);
        haveAccount = findViewById(R.id.haveAccount);

        // Set click listener for signup button
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform sign-up process
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validate input fields
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    errorTextView.setBackgroundColor(Color.parseColor("#99D16B6B"));
                    errorTextView.setText("Please fill in the information correctly.");
                } else {
                    // Save user information and proceed
                    saveUserInformation(name, email, password);
                    // Clear input fields
                    nameEditText.setText("");
                    emailEditText.setText("");
                    passwordEditText.setText("");
                    errorTextView.setText("");

                    // Show success notification
                    Toast.makeText(SignUpActivity.this, "Sign up successful!", Toast.LENGTH_SHORT).show();

                    // Start ActivityLogin
                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                    // Finish the SignUpActivity to prevent going back to it
                    finish();
                }
            }
        });

        haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });






    }

    private void saveUserInformation(String name, String email, String password) {
        // Save user information to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
    }
}
