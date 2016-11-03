package com.assignment.truestrength;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Brogan King on 11/3/2016.
 */

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ItemViewHolder> {
    private List<Programme.MyItems> myItems;

    // constructor for this class
    ExerciseAdapter(List<Programme.MyItems> items) {
        this.myItems = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.excercise_cardview, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int i) {
        holder._image.setImageResource(myItems.get(i).photoId);
        holder._exerciseName.setText(myItems.get(i).exerciseName);
        holder._reps.setText(myItems.get(i).reps);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // internal class
    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView _cardView;
        TextView _exerciseName;
        TextView _reps;
        ImageView _image;

        // constructor for internal class
        ItemViewHolder(View itemView) {
            super(itemView);
            _cardView = (CardView) itemView.findViewById(R.id.exercise_cardView);
            _exerciseName = (TextView) itemView.findViewById(R.id.exercise_headingText);
            _reps = (TextView) itemView.findViewById(R.id.exercise_repsText);
            _image = (ImageView) itemView.findViewById(R.id.exercise_image);
        }
    }
}
