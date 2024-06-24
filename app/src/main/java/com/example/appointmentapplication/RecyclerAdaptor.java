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

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.ViewHolder> {
    private  String[] titles = {"Vancouver General Hospital",
                                "St. Pauls Hospital",
                                "Mount Saint Joseph Hospital",
                                "Lions Gate Hospital"};
    private  String[] itemPostalCode = {"V7M 1P6",
                                "M6G 1R4",
                                "V3N 2L4",
                                "V7M 1Z3"};

    private String[] details = {"Vancouver General Hospital is a medical facility located in Vancouver, British Columbia. It is the largest facility in the Vancouver Hospital and Health Sciences Centre group of medical facilities. VGH is Canadas third largest hospital by bed count, after Hamilton General Hospital, and Foothills Medical Centre.",
                                "Mount Saint Joseph Hospital is a community acute-care hospital located in Vancouver, British Columbia. Like St. Pauls Hospital in downtown Vancouver, Mount Saint Joseph is operated by Providence Health Care, a Roman Catholic faith-based care provider.",
                                "St. Pauls Hospital is an acute care hospital located in downtown Vancouver, British Columbia, Canada. It is the oldest of the seven health care facilities operated by Providence Health Care, a Roman Catholic faith-based care provider.",
                                "Lions Gate Hospital is a 268-bed medical facility located in North Vancouver, British Columbia. The hospital is part of and operated by Vancouver Coastal Health, the regional health authority for the North Shore."};

    private  int[] images = {R.drawable.h2,
                             R.drawable.h3,
                             R.drawable.h4,
                             R.drawable.h5};

    private float[] ratings = {3.5f, 4.0f, 4.5f, 3.0f};
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemPostalCode.setText(itemPostalCode[i]);
        viewHolder.itemImage.setImageResource(images[i]);
        viewHolder.ratingBar.setRating(ratings[i]);

    }

    @Override
    public int getItemCount() {

        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle ,itemDetail, itemPostalCode;
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
