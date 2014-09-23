package net.yslibrary.android.agileporcat.enums;

/**
 * Created by shimizu_yasuhiro on 2014/08/22.
 */
public enum DrawerItemType {

    MENU(0),

    HEADER(1);

    private int value;

    DrawerItemType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
