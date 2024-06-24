package com.example.appointmentapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchRecyclerAdapter extends RecyclerView.Adapter<SearchRecyclerAdapter.ViewHolder> {
    private List<String> titles;
    private List<String> itemPostalCode;
    private List<String> details;
    private int[] images;
    private List<Float> ratings;

    public SearchRecyclerAdapter(List<String> titles, List<String> itemPostalCode, List<String> details, int[] images, List<Float> ratings) {
        this.titles = titles;
        this.itemPostalCode = itemPostalCode;
        this.details = details;
        this.images = images;
        this.ratings = ratings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = titles.get(position);
        String detail = details.get(position);
        String postalCode = itemPostalCode.get(position);
        int image = images[position];
        float rating = ratings.get(position);

        holder.itemTitle.setText(title);
        holder.itemDetail.setText(detail);
        holder.itemPostalCode.setText(postalCode);
        holder.itemImage.setImageResource(image);
        holder.ratingBar.setRating(rating);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle, itemPostalCode, itemDetail;
        RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            itemPostalCode = itemView.findViewById(R.id.itemPostalCode);



            Button bookNowButton = itemView.findViewById(R.id.bookNowButton);
            bookNowButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start the new activity for booking
                    Intent intent = new Intent(itemView.getContext(), BookingActivity.class);
                    // Pass any necessary data to the new activity using intent.putExtra()
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
