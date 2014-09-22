package net.yslibrary.android.agileporcat.model;

import android.content.Context;

/**
 * Created by yshrsmz on 2014/09/21.
 */
public abstract class BaseModel {

    private Context mContext;

    public BaseModel(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }
}
