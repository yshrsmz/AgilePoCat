package net.yslibrary.android.agileporcat;

import android.app.Application;

import net.yslibrary.android.agileporcat.model.Card;

/**
 * Created by yshrsmz on 2014/09/21.
 */
public class MainApplication extends Application {

    private Card mCard;

    @Override
    public void onCreate() {
        super.onCreate();

        mCard = new Card(this);
    }

    public Card getCard() {
        return mCard;
    }
}
