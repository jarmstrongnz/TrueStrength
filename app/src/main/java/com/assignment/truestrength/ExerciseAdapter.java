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
 * <p>
 * This class is parallel with exercise_cardview.xml
 */

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ItemViewHolder> {
    private List<MyItems> myItems;

    // constructor for this class
    ExerciseAdapter(List<MyItems> items) {
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
//        holder._image.setImageResource(myItems.get(i).photoId);
        holder._exerciseName.setText(myItems.get(i).exerciseName);

        holder._rep0.setText(myItems.get(i).rep0);
        holder._rep1.setText(myItems.get(i).rep1);
        holder._rep2.setText(myItems.get(i).rep2);

        holder._weight0.setText(myItems.get(i).weight0);
        holder._weight1.setText(myItems.get(i).weight1);
        holder._weight2.setText(myItems.get(i).weight2);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // internal class
    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView _cardView;
//        ImageView _image;
        TextView _exerciseName;
        TextView _weight0, _weight1, _weight2;
        TextView _rep0, _rep1, _rep2;


        // constructor for internal class
        ItemViewHolder(View itemView) {
            super(itemView);
            _cardView = (CardView) itemView.findViewById(R.id.exercise_cardView);
//            _image = (ImageView) itemView.findViewById(R.id.exercise_image);

            _exerciseName = (TextView) itemView.findViewById(R.id.exercise_headingText);

            _rep0 = (TextView) itemView.findViewById(R.id.exercise_repsText0);
            _rep1 = (TextView) itemView.findViewById(R.id.exercise_repsText1);
            _rep2 = (TextView) itemView.findViewById(R.id.exercise_repsText2);

            _weight0 = (TextView) itemView.findViewById(R.id.exercise_weightsText0);
            _weight1 = (TextView) itemView.findViewById(R.id.exercise_weightsText1);
            _weight2 = (TextView) itemView.findViewById(R.id.exercise_weightsText2);

        }
    }


}
