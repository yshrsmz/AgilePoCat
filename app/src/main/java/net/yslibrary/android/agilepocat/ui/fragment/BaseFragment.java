package net.yslibrary.android.agilepocat.ui.fragment;

import android.app.Fragment;

import net.yslibrary.android.agilepocat.MainApplication;

/**
 * Created by yshrsmz on 2014/09/22.
 */
public class BaseFragment extends Fragment {

    protected final MainApplication getApp() {
        return (MainApplication) getActivity().getApplication();
    }
}
