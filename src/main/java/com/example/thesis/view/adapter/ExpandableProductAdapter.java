package com.example.thesis.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.thesis.R;
import com.example.thesis.view.ui.SecondLvlExpandableListView;

import java.util.ArrayList;
import java.util.List;

//import com.example.thesis.View.ExpandableProductAdapterSecondLevel;
//import com.example.thesis.View.SecondLevelExpandableListView;

public class ExpandableProductAdapter extends BaseExpandableListAdapter {

    private Context context;

    private ArrayList<String> parentHeaders;
    private List<ArrayList<String>> secondLevel; //headers
    List<ArrayList<String>> data;
    List<String> data2;


    public ExpandableProductAdapter(Context context, ArrayList<String> parentHeader,List<ArrayList<String>> secondLevel,List<ArrayList<String>> data) {
        this.context = context;
        this.parentHeaders = parentHeader;
        this.secondLevel = secondLevel;
        this.data = data;
    }


    @Override
    public int getGroupCount() {
        return parentHeaders.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1; //autor nie ma pojecia dlaczego to dziala
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int group, int child) {
        return child;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row_expandable_first, null);
        TextView text = (TextView) convertView.findViewById(R.id.rowParentText);
        text.setText(this.parentHeaders.get(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {

        final SecondLvlExpandableListView secondLevelExpandableList = new SecondLvlExpandableListView(context);
        ArrayList<String> headers = secondLevel.get(groupPosition); //naglowki

        List<ArrayList<String>> childData = new ArrayList<>();
        ArrayList<String> secondLevelData = data.get(groupPosition);

        for(String key: secondLevelData){
            childData.add(secondLevelData);
        }

        /*for(String key: secondLevelData.keySet()){
            childData.add(secondLevelData.get(key));
        }*/


        secondLevelExpandableList.setAdapter(new ExpandableProductSecondLvlAdapter(context, headers, childData));
        secondLevelExpandableList.setGroupIndicator(null);
        secondLevelExpandableList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)
                    secondLevelExpandableList.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });


        return secondLevelExpandableList;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}