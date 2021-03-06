/*
 * Copyright (c) 2015. Gianluca Vegetti, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.iukonline.amule.android.amuleremote.helpers.ec.tasks;

import com.iukonline.amule.ec.ECCategory;
import com.iukonline.amule.ec.ECCodes;
import com.iukonline.amule.ec.exceptions.ECClientException;
import com.iukonline.amule.ec.exceptions.ECPacketParsingException;
import com.iukonline.amule.ec.exceptions.ECServerException;

import java.io.IOException;

public class GetCategoriesAsyncTask extends AmuleAsyncTask {
    
    private ECCategory[] mCategoryList;

    @Override
    protected void backgroundTask() throws IOException, ECClientException, ECPacketParsingException, ECServerException {
        if (isCancelled()) return;
        mCategoryList = mECClient.getCategories(ECCodes.EC_DETAIL_FULL);
    }

    @Override
    protected void notifyResult() {
        mECHelper.notifyCategoriesWatchers(mCategoryList);
    }

}
