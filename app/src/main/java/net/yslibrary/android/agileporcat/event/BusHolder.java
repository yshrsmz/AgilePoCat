package net.yslibrary.android.agileporcat.event;

import com.squareup.otto.Bus;

/**
 * Created by yshrsmz on 2014/09/21.
 */
public class BusHolder {

    private static Bus mBus = new Bus();

    private BusHolder() {}

    public static Bus get() {
        return mBus;
    }
}
