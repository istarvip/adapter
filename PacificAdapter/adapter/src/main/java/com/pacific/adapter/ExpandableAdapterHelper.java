package com.pacific.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

final public class ExpandableAdapterHelper extends BaseAdapterHelper<ExpandableAdapterHelper> {

    protected View convertView;
    protected int groupPosition = -1;
    protected int childPosition = -1;

    private ExpandableAdapterHelper(Context context, ViewGroup parent, int layoutId, int groupPosition, int childPosition) {
        this.groupPosition = groupPosition;
        this.childPosition = childPosition;
        this.views = new SparseArray();
        this.convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        this.convertView.setTag(this);
    }

    static ExpandableAdapterHelper get(Context context, View convertView, ViewGroup parent, int layoutId, int groupPosition, int childPosition) {
        if (convertView == null) {
            return new ExpandableAdapterHelper(context, parent, layoutId, groupPosition, childPosition);
        }
        ExpandableAdapterHelper helper = (ExpandableAdapterHelper) convertView.getTag();
        helper.groupPosition = groupPosition;
        helper.childPosition = childPosition;
        return helper;
    }

    @Override
    public View getItemView() {
        return convertView;
    }

    public int getGroupPosition() {
        return groupPosition;
    }

    public int getChildPosition() {
        return childPosition;
    }
}
