package com.scriptgo.www.graviflex.callbacks;

/**
 * Created by BALAREZO on 01/10/2017.
 */

public interface FragmentToActivity {
    void showNewFragment(int iditemnenu);
    void showSnackBarError(String text);
    void showSnackBarSuccess(String text);
    void showSnackBarInfo(String text);
    void showSnackBarLog(String text);
}
