/*
 * Copyright (c) 2015. Gianluca Vegetti, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.iukonline.amule.android.amuleremote.helpers.ec.tasks;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import android.widget.Toast;

import com.iukonline.amule.android.amuleremote.R;
import com.iukonline.amule.ec.ECSearchFile;
import com.iukonline.amule.ec.exceptions.ECClientException;
import com.iukonline.amule.ec.exceptions.ECPacketParsingException;
import com.iukonline.amule.ec.exceptions.ECServerException;

public class SearchStartResultAsyncTask extends AmuleAsyncTask {
    
    private ECSearchFile mECSearchFile;
    
    public void setECSearchFile(ECSearchFile sf) {
        mECSearchFile = sf;
    }

    @Override
    protected void backgroundTask() throws UnknownHostException, SocketTimeoutException, IOException, AmuleAsyncTaskException, ECClientException,
                    ECPacketParsingException, ECServerException {
        if (isCancelled()) return;
        mECClient.searchStartResult(mECSearchFile);
        
    }

    @Override
    protected void notifyResult() {

        Toast.makeText(
            mECHelper.mApp, 
            mECHelper.mApp.getResources().getString(R.string.search_details_file_added, mECSearchFile.getFileName()), 
            Toast.LENGTH_LONG
        ).show();
    }

}
