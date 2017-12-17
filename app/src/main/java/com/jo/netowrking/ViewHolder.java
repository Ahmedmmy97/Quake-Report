package com.jo.netowrking;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ahmed on 27/11/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView power;
    private TextView loc;
    private TextView cty;
    private TextView date;
    private TextView time;
    Context c;
    ListItemClickListener mOnClickListener;
    public ViewHolder(View itemView, Context c, ListItemClickListener mOnClickListener) {
        super(itemView);
        assign_controls(itemView);
        this.c=c;
        this.mOnClickListener=mOnClickListener;
        itemView.setOnClickListener(this);
    }
    void assign_controls(View v){
        power = (TextView)v.findViewById(R.id.power);
        loc = (TextView)v.findViewById(R.id.loc);
        cty = (TextView)v.findViewById(R.id.cty);
        date = (TextView)v.findViewById(R.id.date);
        time = (TextView)v.findViewById(R.id.time);
    }
    void bind_data(EarthQuake item){
        DecimalFormat formatter = new DecimalFormat("0.0");
        power.setText(String.valueOf(formatter.format(item.getPower())));
        Set_color(item.getPower());
        loc.setText(item.getLocation());
        cty.setText(item.getCountry());
        SimpleDateFormat spf= new SimpleDateFormat("dd MMM yyyy");
        date.setText(spf.format(item.getDate()));
        spf = new SimpleDateFormat("H:mm a");
        time.setText(spf.format(item.getDate()));
    }

    void Set_color(Double value){
        GradientDrawable magnitudeCircle = (GradientDrawable) power.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(value);
        int magnitude1Color = ContextCompat.getColor(c, magnitudeColor);
        int ColorStroke = ContextCompat.getColor(c, getMagnitudeStrokeColor(value));
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitude1Color);
        magnitudeCircle.setStroke(1,ColorStroke);
    }

    private int getMagnitudeColor(Double value) {
        int color;
        switch (value.intValue()){
            case 0:
            case 1:
                color= R.color.magnitude1;
            break;
            case 2:
                color= R.color.magnitude2;
            break;
            case 3:
                color= R.color.magnitude3;
            break;

            case 4:
                color= R.color.magnitude4;
            break;

            case 5:
                color= R.color.magnitude5;
            break;

            case 6:
                color= R.color.magnitude6;
            break;

            case 7:
                color= R.color.magnitude7;
            break;

            case 8:
                color= R.color.magnitude8;
            break;

            case 9:
                color= R.color.magnitude9;
            break;

            default:
                color= R.color.magnitude10plus;
                break;
        }
        return color;
    }
    private int getMagnitudeStrokeColor(Double value) {
        int color;
        switch (value.intValue()){
            case 0:
            case 1:
                color= R.color.magnitude1s;
                break;
            case 2:
                color= R.color.magnitude2s;
                break;
            case 3:
                color= R.color.magnitude3s;
                break;

            case 4:
                color= R.color.magnitude4s;
                break;

            case 5:
                color= R.color.magnitude5s;
                break;

            case 6:
                color= R.color.magnitude6s;
                break;

            case 7:
                color= R.color.magnitude7s;
                break;

            case 8:
                color= R.color.magnitude8s;
                break;

            case 9:
                color= R.color.magnitude9s;
                break;

            default:
                color= R.color.magnitude10pluss;
                break;
        }
        return color;
    }

    @Override
    public void onClick(View v) {
        mOnClickListener.onItemClick(getAdapterPosition());
    }
}
