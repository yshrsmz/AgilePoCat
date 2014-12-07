package net.yslibrary.android.agilepocat.ui.activity;

import net.yslibrary.android.agilepocat.R;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by yshrsmz on 2014/12/07.
 */
public class BaseActivity extends ActionBarActivity {

    @Optional
    @InjectView(R.id.toolbar_actionbar)
    protected Toolbar mActionBarToolbar;

    protected Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            return null;
        }

        return mActionBarToolbar;
    }

}
