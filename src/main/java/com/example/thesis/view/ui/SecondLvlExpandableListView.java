package com.example.thesis.view.ui;

import android.content.Context;
import android.view.View;
import android.widget.ExpandableListView;

public class SecondLvlExpandableListView extends ExpandableListView {

    public SecondLvlExpandableListView(Context context) {
        super(context);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(999999, View.MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
