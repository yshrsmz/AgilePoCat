package net.yslibrary.android.agilepocat.enums;

import java.util.Locale;

/**
 * Created by yshrsmz on 2014/09/23.
 */
public enum DrawerMenu {

    CARD_HEADER(0),

    CARD_FIBONACCI(1),

    OTHERS_HEADER(2),

    OTHERS_ABOUT(3),

    OTHERS_LICENCE(4);

    /**
     * 通しのposition
     */
    private int position = 0;

    DrawerMenu(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getTag() {
        return toString();
    }

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
