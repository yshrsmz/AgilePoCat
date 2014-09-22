package net.yslibrary.android.agileporcat.dto;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yshrsmz on 2014/09/21.
 */
public class CardDto implements Parcelable {

    private int mCardResId;
    private int mCardValue;

    public CardDto(int cardResId, int cardValue) {
        this.mCardResId = cardResId;
        this.mCardValue = cardValue;
    }

    public int getCardResId() {
        return mCardResId;
    }

    public int getCardValue() {
        return mCardValue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mCardResId);
        dest.writeInt(this.mCardValue);
    }

    private CardDto(Parcel in) {
        this.mCardResId = in.readInt();
        this.mCardValue = in.readInt();
    }

    public static final Parcelable.Creator<CardDto> CREATOR = new Parcelable.Creator<CardDto>() {
        public CardDto createFromParcel(Parcel source) {
            return new CardDto(source);
        }

        public CardDto[] newArray(int size) {
            return new CardDto[size];
        }
    };
}
