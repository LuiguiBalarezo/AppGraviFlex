package com.scriptgo.www.graviflex.bases;

import com.scriptgo.www.graviflex.callbacks.APICallBackLogin;
import com.scriptgo.www.graviflex.models.Usuario;
import com.scriptgo.www.graviflex.responses.LoginResponse;

import retrofit2.Call;

/**
 * Created by BALAREZO on 03/10/2017.
 */

public class BaseServiceAPI {
    protected int iduser = 0;

    /* VARS */
    protected String TAG = this.getClass().getSimpleName();

    /* SERVICES */
    protected Call<LoginResponse> api_usuario = null;
    protected APICallBackLogin apiCallBackLogin = null;

    /* MODELS */
    protected Usuario m_usuario = null;

    /* RESPONSES */
    protected LoginResponse r_obras = null;

}
