/*
 * Copyright (c) 2015. Gianluca Vegetti, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.iukonline.amule.android.amuleremote.helpers.gui.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.iukonline.amule.android.amuleremote.R;

public class AboutDialogFragment extends AlertDialogFragment {
    
    private final static String BUNDLE_VERSION_NAME = "version_name";
    private final static String BUNDLE_RELEASE_NOTES = "release_notes";
    

    private String mVersionName;
    private String mReleaseNotes;
    
    public AboutDialogFragment() {}
    
    public static AboutDialogFragment newInstance(String versionName, String releaseNotes) {

        Bundle args = new Bundle();
        args.putString(BUNDLE_VERSION_NAME, versionName);
        args.putString(BUNDLE_RELEASE_NOTES, releaseNotes);
        args.putBoolean(BUNDLE_SHOW_CANCEL, false);

        AboutDialogFragment fragment = new AboutDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(BUNDLE_VERSION_NAME, mVersionName);
        outState.putString(BUNDLE_RELEASE_NOTES, mReleaseNotes);
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mVersionName = savedInstanceState.getString(BUNDLE_VERSION_NAME);
            mReleaseNotes = savedInstanceState.getString(BUNDLE_RELEASE_NOTES);
        } else {
            Bundle args = getArguments();
            if (args != null) {
                mVersionName = args.getString(BUNDLE_VERSION_NAME);
                mReleaseNotes = args.getString(BUNDLE_RELEASE_NOTES);
            }
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = getDefaultAlertDialogBuilder(savedInstanceState);
        

        
        View aboutView = getActivity().getLayoutInflater().inflate(R.layout.about_dialog, null);
        ((TextView) aboutView.findViewById(R.id.about_dialog_appname)).setText(getString(R.string.app_name) + " " + mVersionName);
        ((TextView) aboutView.findViewById(R.id.about_dialog_release_notes)).setText(mReleaseNotes);
        builder.setView(aboutView);

        return builder.create();
        
        
    }

}
