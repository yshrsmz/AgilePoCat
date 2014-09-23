package net.yslibrary.android.agilepocat.fragment;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import net.yslibrary.android.agilepocat.R;
import net.yslibrary.android.agilepocat.adapter.CardStackAdapter;
import net.yslibrary.android.agilepocat.dto.CardDto;
import net.yslibrary.android.agilepocat.event.BusHolder;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class MainFragment extends BaseFragment {

    private final static String TAG = MainFragment.class.getSimpleName();

    private String TAG_DIALOG = "dialog";

    private List<CardDto> mCardList;

    @InjectView(R.id.card_grid)
    public GridView mCardGrid;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainFragment.
     */
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.inject(this, view);

        mCardList = getApp().getCard().generateFibonacciCardList();

        CardStackAdapter adapter =
                new CardStackAdapter(getApp(), 0, mCardList);

        mCardGrid.setAdapter(adapter);
        mCardGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (getFragmentManager().findFragmentByTag(TAG_DIALOG) == null) {
                    CardDialogFragment dialog = CardDialogFragment.newInstance(mCardList.get(position));
                    dialog.show(getFragmentManager(), TAG_DIALOG);
                }
            }
        });


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        BusHolder.get().register(this);
    }

    @Override
    public void onStop() {
        BusHolder.get().unregister(this);

        super.onStop();
    }
}
