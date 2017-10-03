package com.scriptgo.www.graviflex.bases;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import butterknife.Unbinder;

/**
 * Created by BALAREZO on 30/09/2017.
 */

public class BaseFragment extends Fragment {

    /* VARS */
    protected String TAG = this.getClass().getSimpleName();

    /* UI */
    protected View view = null;
    protected Unbinder unbinder = null;

    /* METHOD CUSTOMS */
    protected void showToast(String msg){
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

}
