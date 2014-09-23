package net.yslibrary.android.agilepocat.model;

import android.content.Context;

import net.yslibrary.android.agilepocat.R;
import net.yslibrary.android.agilepocat.dto.CardDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yshrsmz on 2014/09/21.
 */
public class Card extends BaseModel{

    private List<CardDto> mCardList;

    public Card(Context context) {
        super(context);
    }

    public List<CardDto> getCardList() {
        if (mCardList == null) {
            mCardList = generateFibonacciCardList();
        }

        return mCardList;
    }

    public List<CardDto> generateFibonacciCardList() {
        List<CardDto> cardList = new ArrayList<CardDto>(
            Arrays.asList(
                new CardDto(R.drawable.card_01, 1),
                new CardDto(R.drawable.card_02, 2),
                new CardDto(R.drawable.card_03, 3),
                new CardDto(R.drawable.card_05, 5),
                new CardDto(R.drawable.card_08, 8),
                new CardDto(R.drawable.card_13, 13),
                new CardDto(R.drawable.card_21, 21),
                new CardDto(R.drawable.card_99, 99)
            )
        );

        return cardList;
    }
}
