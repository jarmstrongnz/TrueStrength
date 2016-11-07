package com.assignment.truestrength.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.assignment.truestrength.Exercise_InfoClasses.ExerciseGetterSetter;
import com.assignment.truestrength.R;

import java.util.List;

//Adapter Class
public class DeclanExerciseAdapter extends RecyclerView.Adapter<DeclanExerciseAdapter.ExerciseHolder> {

    //Variables
    private List<ExerciseGetterSetter> listData;
    private LayoutInflater inflater;

    public List<ExerciseGetterSetter> getListData(){
        return this.listData;
    }
    //ItemListener & ItemCallBack Methods
    private ItemClickCallBack itemClickCallBack;

    //
    public DeclanExerciseAdapter(List<ExerciseGetterSetter> listData, Context c) {
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    public void setItemClickCallBack(final ItemClickCallBack itemClickCallBack) {
        this.itemClickCallBack = itemClickCallBack;
    }

    //
    public ExerciseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new ExerciseHolder(view);
    }

    @Override
    public void onBindViewHolder(ExerciseHolder holder, int position) {
        ExerciseGetterSetter item = listData.get(position);

        holder.exercise_name.setText(item.getExercise_Name());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public interface ItemClickCallBack {
        void onItemClick(int p);
    }

    class ExerciseHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //Variables
        TextView exercise_name;
        View container;


        public ExerciseHolder(View itemView) {
            super(itemView);

            //Links to list_item.xml textview : eName
            exercise_name = (TextView) itemView.findViewById(R.id.eName);

            //Container Stuff
            container = itemView.findViewById(R.id.cont_item_root);
            container.setOnClickListener(this);
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public void onClick(View v) {
            if (v.getId() == R.id.cont_item_root) {
                itemClickCallBack.onItemClick(getAdapterPosition());
            }
        }

    }

}
