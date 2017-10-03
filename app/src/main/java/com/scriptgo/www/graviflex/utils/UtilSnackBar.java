package com.scriptgo.www.graviflex.utils;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.scriptgo.www.graviflex.R;

/**
 * Created by lbalarezo on 22/09/2017.
 */

public class UtilSnackBar {

    Snackbar snackbar = null;
    View viewguide = null, snackBarView = null;
    Activity activity = null;

    public UtilSnackBar(Activity a, View view) {
        viewguide = view;
        activity = a;
    }

    public UtilSnackBar showSnackBar(String msg) {
        snackbar = Snackbar.make(viewguide, msg, Snackbar.LENGTH_INDEFINITE);
        snackBarView = snackbar.getView();
        return this;
    }

    public void log(){
        snackBarView.setBackgroundColor(ContextCompat.getColor(activity, R.color.grey_900));
        snackbar.setAction("Action", null).show();
    }

    public void error() {
        snackBarView.setBackgroundColor(ContextCompat.getColor(activity, R.color.red_500));
        snackbar.setAction("Action", null).show();
    }

    public void success(){
        snackBarView.setBackgroundColor(ContextCompat.getColor(activity, R.color.green_500));
        snackbar.setAction("Action", null).show();
    }

    public void info(){
        snackBarView.setBackgroundColor(ContextCompat.getColor(activity, R.color.orange_500));
    }

    public void dismissSnackBar() {
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }


}
