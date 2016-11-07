package com.assignment.truestrength;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.assignment.truestrength.R.id.llExpandArea;

/**
 * Created by Brogan King on 11/3/2016.
 * <p>
 * This class is parallel with exercise_cardview.xml
 */

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ItemViewHolder> /*implements View.OnFocusChangeListener */ {
    DatabaseHelper myDB;
    private List<MyItems> myItems;
    private int expandedPosition = -1;

    // constructor for this class
    ExerciseAdapter(List<MyItems> items) {
        this.myItems = items;
    }

    /* @Override
     public void onFocusChange(View v, boolean hasFocus) {
         switch(v.getId()){
             case R.id.exercise_weightsText0:

                 if(hasFocus){
                     Toast.makeText(v.getContext(), "got the focus", Toast.LENGTH_LONG).show();
                 }else {
                     Toast.makeText(v.getContext(), "lost the focus", Toast.LENGTH_LONG).show();
                 }

                 break;

         }
     }
 */


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

        if (i == expandedPosition) {
            holder.llExpandArea.setVisibility(View.VISIBLE);
        } else {
            holder.llExpandArea.setVisibility(View.GONE);
        }

        final boolean isExpanded = i==expandedPosition;
        holder.llExpandArea.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);
  /*      holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandedPosition = isExpanded ? -1:ItemViewHolder.getAdapterPosition();
                TransitionManager.beginDelayedTransition(recyclerView);
                notifyDataSetChanged();
            }
        });
*/
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.excercise_cardview, parent, false);
        myDB = new DatabaseHelper(v.getContext());
        final TextView exercise_headingText = (TextView) v.findViewById(R.id.exercise_headingText);
        final EditText exercise_weightsText0 = (EditText) v.findViewById(R.id.exercise_weightsText0);
        final EditText exercise_weightsText1 = (EditText) v.findViewById(R.id.exercise_weightsText1);
        final EditText exercise_weightsText2 = (EditText) v.findViewById(R.id.exercise_weightsText2);
        final EditText exercise_repsText0 = (EditText) v.findViewById(R.id.exercise_repsText0);
        final EditText exercise_repsText1 = (EditText) v.findViewById(R.id.exercise_repsText1);
        final EditText exercise_repsText2 = (EditText) v.findViewById(R.id.exercise_repsText2);



        exercise_weightsText0.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    myDB.setSet1weight(Integer.parseInt(exercise_weightsText0.getText().toString()), exercise_headingText.getText().toString());

                }
            }
        });

        exercise_weightsText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    myDB.setSet2weight(Integer.parseInt(exercise_weightsText1.getText().toString()), exercise_headingText.getText().toString());
                }
            }
        });


        exercise_weightsText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    myDB.setSet3weight(Integer.parseInt(exercise_weightsText2.getText().toString()), exercise_headingText.getText().toString());
                }
            }
        });


        exercise_repsText0.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    myDB.setSet1reps(Integer.parseInt(exercise_repsText0.getText().toString()), exercise_headingText.getText().toString());
                }
            }
        });


        exercise_repsText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    myDB.setSet2reps(Integer.parseInt(exercise_repsText1.getText().toString()), exercise_headingText.getText().toString());
                }
            }
        });


        exercise_repsText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    myDB.setSet3reps(Integer.parseInt(exercise_repsText2.getText().toString()), exercise_headingText.getText().toString());
                }
            }
        });


        return new ItemViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // internal class
    static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView _cardView;
        //        ImageView _image;
        TextView _exerciseName;
        TextView _weight0, _weight1, _weight2;
        TextView _rep0, _rep1, _rep2;
        LinearLayout llExpandArea;


        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder holder = (RecyclerView.ViewHolder) view.getTag();
/*
            // Check for an expanded view, collapse if you find one
            if (expandedPosition >= 0) {
                int prev = expandedPosition;
                notifyItemChanged(prev);
            }
            // Set the current position to "expanded"
            expandedPosition = holder.getAdapterPosition();
            notifyItemChanged(expandedPosition);
*/
        }



        // constructor for internal class
        ItemViewHolder(View itemView) {
            super(itemView);
            _cardView = (CardView) itemView.findViewById(R.id.exercise_cardView);
//            _image = (ImageView) itemView.findViewById(R.id.exercise_image);

            _exerciseName = (TextView) itemView.findViewById(R.id.exercise_headingText);
            llExpandArea =  (LinearLayout) itemView.findViewById(R.id.llExpandArea);

            _rep0 = (TextView) itemView.findViewById(R.id.exercise_repsText0);
            _rep1 = (TextView) itemView.findViewById(R.id.exercise_repsText1);
            _rep2 = (TextView) itemView.findViewById(R.id.exercise_repsText2);

            _weight0 = (TextView) itemView.findViewById(R.id.exercise_weightsText0);
            _weight1 = (TextView) itemView.findViewById(R.id.exercise_weightsText1);
            _weight2 = (TextView) itemView.findViewById(R.id.exercise_weightsText2);

        }
    }


}
