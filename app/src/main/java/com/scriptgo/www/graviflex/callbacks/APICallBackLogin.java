package com.scriptgo.www.graviflex.callbacks;

/**
 * Created by BALAREZO on 03/10/2017.
 */

public interface APICallBackLogin {
    void success(String msg);
    void error(String msg);
    void fail(String msg);
    void timeout(String msg);
}
