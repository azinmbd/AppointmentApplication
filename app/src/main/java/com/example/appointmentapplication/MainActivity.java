package com.example.appointmentapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    // toolbar profile btn
    private Button profileBTN, seearchBTN;


    // recycler view for cards
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar design handling
        //  setTitle("Login"); test for changing the title of default toolbar
        //hiding the default toolbar
        getSupportActionBar().hide();

        // find items
        profileBTN = findViewById(R.id.profileBTN);
        seearchBTN = findViewById(R.id.seearchBTN);

        // recycler view codes for the main page

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdaptor();
        recyclerView.setAdapter(adapter);

        // moving to profile page activity
        profileBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the profile activity
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        seearchBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the profile activity
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }



}