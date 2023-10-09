package com.example.thesis.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thesis.R;

import java.util.ArrayList;
import java.util.List;

public class ExpandableProductSecondLvlAdapter extends BaseExpandableListAdapter {

    private Context context;


    List<ArrayList<String>> data;

    ArrayList<String> headers;

    ImageView ivGroupIndicator;


    public ExpandableProductSecondLvlAdapter(Context context, ArrayList<String> headers, List<ArrayList<String>> data) {
        this.context = context;
        this.data = data;
        this.headers = headers;

    }

    @Override
    public Object getGroup(int groupPosition) {

        return headers.get(groupPosition);
    }

    @Override
    public int getGroupCount() {

        return headers.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.row_expandable_second_image, null);
        //convertView = inflater.inflate(R.layout.row_expandable_second, null);
        TextView text = (TextView) convertView.findViewById(R.id.rowSecondText);


        String groupText = getGroup(groupPosition).toString();
        text.setText(groupText);
        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        ArrayList<String> childData;

        childData = data.get(groupPosition);


        return childData.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row_expandable_third, null);

        TextView textView = (TextView) convertView.findViewById(R.id.rowThirdText);

        ArrayList<String> childArray = data.get(groupPosition);

        String text = childArray.get(childPosition);

        textView.setText(text);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<String> children = data.get(groupPosition);

        return children.size();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    public void setLastChildItem(int groupPosition, View convertView){
        if(groupPosition == getGroupCount() -1){
            @SuppressLint("WrongViewCast") ImageView text = (ImageView) convertView.findViewById(R.id.expandable_second_image);
        }
    }
}
