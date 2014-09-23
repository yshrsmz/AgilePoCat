package net.yslibrary.android.agilepocat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import net.yslibrary.android.agilepocat.R;
import net.yslibrary.android.agilepocat.dto.CardDto;

import java.util.List;

/**
 * Created by yshrsmz on 2014/09/22.
 */
public class CardStackAdapter extends ArrayAdapter<CardDto> {

    private Context mContext;

    private List<CardDto> mCards;

    public CardStackAdapter(Context context, int resource, List<CardDto> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mCards = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.item_card_stack, null);

            holder = new ViewHolder();

            holder.cardImage = (ImageView) convertView.findViewById(R.id.image_item_card_stack);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CardDto card = mCards.get(position);

        if (card != null) {
            holder.cardImage.setImageDrawable(mContext.getResources().getDrawable(card.getCardResId()));
        };

        return convertView;
    }

    public class ViewHolder {
        ImageView cardImage;
    }
}
