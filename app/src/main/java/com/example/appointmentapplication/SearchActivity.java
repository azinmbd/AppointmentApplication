package com.example.appointmentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView searchRecyclerView;
    private List<String> itemPostalCode;

    private SearchRecyclerAdapter recyclerAdapter;
    private EditText searchInput;
    private Button backToMain;
    private List<String> titles;
    private List<String> details;
    private int[] images;
    private List<Float> ratings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().hide();

        // Find views
        searchRecyclerView = findViewById(R.id.searchRecyclerView);
        backToMain = findViewById(R.id.backToMain);

        // Back to main button
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the profile activity
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Retrieve the search query from the intent
        String searchQuery = getIntent().getStringExtra("searchQuery");

        // Set up the RecyclerView with the adapter
        titles = new ArrayList<>();
        details = new ArrayList<>();
        images = new int[]{R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5};
        ratings = new ArrayList<>();
        itemPostalCode = new ArrayList<>();


        // Populate the titles, details, and ratings lists with your data
        titles.add("Vancouver General Hospital");
        titles.add("St. Paul's Hospital");
        titles.add("Mount Saint Joseph Hospital");
        titles.add("Lions Gate Hospital");

        details.add("Vancouver General Hospital is a medical facility located in Vancouver, British Columbia...");
        details.add("St. Paul's Hospital is an acute care hospital located in downtown Vancouver, British Columbia...");
        details.add("Mount Saint Joseph Hospital is a community acute-care hospital located in Vancouver, British Columbia...");
        details.add("Lions Gate Hospital is a 268-bed medical facility located in North Vancouver, British Columbia...");

        ratings.add(3.5f);
        ratings.add(4.0f);
        ratings.add(4.5f);
        ratings.add(3.0f);

        itemPostalCode.add("V7M 1P6");
        itemPostalCode.add("M6G 1R4");
        itemPostalCode.add("V3N 2L4");
        itemPostalCode.add("V7M 1Z3");

        recyclerAdapter = new SearchRecyclerAdapter(titles, details, itemPostalCode, images, ratings);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchRecyclerView.setAdapter(recyclerAdapter);

        // Find the search input field
        searchInput = findViewById(R.id.searchInput);

        // Add a TextWatcher to listen for changes in the search input
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Filter the data based on the search query
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // Perform the initial search with the provided query
        filterData(searchQuery);
    }

    private void filterData(String searchQuery) {
        List<String> filteredTitles = new ArrayList<>();
        List<String> filteredDetails = new ArrayList<>();
        List<Integer> filteredImages = new ArrayList<>();
        List<Float> filteredRatings = new ArrayList<>();

        if (searchQuery != null) {
            for (int i = 0; i < titles.size(); i++) {
                String title = titles.get(i);
                if (title != null && title.toLowerCase().contains(searchQuery.toLowerCase())) {
                    filteredTitles.add(title);
                    filteredDetails.add(details.get(i));
                    filteredImages.add(images[i]);
                    filteredRatings.add(ratings.get(i));
                }
            }
        }

        recyclerAdapter = new SearchRecyclerAdapter(filteredTitles, itemPostalCode, filteredDetails, convertIntegerListToArray(filteredImages), filteredRatings);

        searchRecyclerView.setAdapter(recyclerAdapter);
    }

    private int[] convertIntegerListToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
