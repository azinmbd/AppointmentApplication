package com.example.appointmentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {
    private Button backToMain;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        //hiding the default toolbar
        getSupportActionBar().hide();

        backToMain = findViewById(R.id.backToMain);

        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the profile activity
                Intent intent = new Intent(BookingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
