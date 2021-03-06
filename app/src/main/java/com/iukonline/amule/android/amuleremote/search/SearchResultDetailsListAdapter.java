/*
 * Copyright (c) 2015. Gianluca Vegetti, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.iukonline.amule.android.amuleremote.search;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.iukonline.amule.android.amuleremote.R;
import com.iukonline.amule.android.amuleremote.helpers.gui.GUIUtils;
import com.iukonline.amule.ec.ECSearchFile;

public class SearchResultDetailsListAdapter extends ArrayAdapter<ECSearchFile> {
    
    static class SearchResultsHolder {
        TextView mFileName;
        TextView mSize;
        TextView mSources;
        
    }
    
    public SearchResultDetailsListAdapter(Context context, int textViewResourceId, ArrayList<ECSearchFile> items) {
        super(context, textViewResourceId, items);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            
        SearchResultsHolder holder;
        
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.frag_search_result_details_row, null);
            holder = new SearchResultsHolder();
            
            holder.mFileName = (TextView) v.findViewById(R.id.search_result_detail_filename);
            holder.mSize = (TextView) v.findViewById(R.id.search_result_detail_size);
            holder.mSources = (TextView) v.findViewById(R.id.search_result_detail_sources);
            
            v.setTag(holder);
        } else {
            holder = (SearchResultsHolder) v.getTag();
        }
        
        if (position < getCount()) {
            ECSearchFile o = getItem(position);
            holder.mFileName.setText(o.getFileName());
            holder.mSize.setText(GUIUtils.longToBytesFormatted(o.getSizeFull()));
            //holder.mSources.setText("Sources: " + Integer.toString(o.getSourceCount()) + "(" + Integer.toString(o.getSourceXfer()) + ")");
            holder.mSources.setText(getContext().getResources().getString(R.string.search_details_label_sources, o.getSourceCount(), o.getSourceXfer()));
        }
        return v;
    }

    
}
