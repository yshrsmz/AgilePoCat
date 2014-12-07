package net.yslibrary.android.agilepocat.ui.fragment;



import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import net.yslibrary.android.agilepocat.R;
import net.yslibrary.android.agilepocat.dto.CardDto;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CardDialogFragment extends DialogFragment {

    public interface InitBundle {
        String TARGET_CARD_DATA = "target_card_data";
    }

    private CardDto mCardDto;

    @InjectView(R.id.dialog_card_image)
    ImageView mCardImage;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CardDialogFragment.
     */
    public static CardDialogFragment newInstance(CardDto cardDto) {
        CardDialogFragment fragment = new CardDialogFragment();
        Bundle args = new Bundle();

        args.putParcelable(InitBundle.TARGET_CARD_DATA, cardDto);

        fragment.setArguments(args);
        return fragment;
    }
    public CardDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mCardDto = getArguments().getParcelable(InitBundle.TARGET_CARD_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_dialog, container, false);

        ButterKnife.inject(this, view);

        mCardImage.setImageDrawable(getResources().getDrawable(mCardDto.getCardResId()));

        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.fragment_card_dialog);

        dialog.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        );

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        return dialog;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Dialog dialog = getDialog();

        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();

        // ダイアログの幅・高さ設定
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int dialogWidth = (int) (metrics.widthPixels * 0.8);
        int dialogHeight = (int) (metrics.heightPixels * 0.8);

        lp.width = dialogWidth;
        lp.height = dialogHeight;

        dialog.getWindow().setAttributes(lp);

    }
}
