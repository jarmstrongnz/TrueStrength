package com.assignment.truestrength;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jambo on 07-Nov-16.
 */

public class SummaryAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final String[] imgid;

    public SummaryAdapter(Activity context, String[] itemname, String[] imgid) {
        super(context, R.layout.summarycard, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.summarycard, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.summ_text);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.summ_img);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(getImageId(this.getContext(), imgid[position]));
        return rowView;

    };
}