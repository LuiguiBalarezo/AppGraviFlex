package com.scriptgo.www.graviflex.apiprocess;


import com.scriptgo.www.graviflex.api.ApiAdapter;
import com.scriptgo.www.graviflex.bases.BaseServiceAPI;
import com.scriptgo.www.graviflex.callbacks.APICallBackLogin;
import com.scriptgo.www.graviflex.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by BALAREZO on 03/10/2017.
 */

public class LoginProcessAPI extends BaseServiceAPI {

    private int iduser = 0;

    public LoginProcessAPI(int _iduser) {
        iduser = _iduser;
    }

    public void loginAPI(String usuario, String clave, final APICallBackLogin callBackLogin){
        apiCallBackLogin = callBackLogin;
        api_usuario = ApiAdapter.getApiLinksService().processLogin(usuario, clave);
        api_usuario.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                apiCallBackLogin.success(response.body().toString());
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                apiCallBackLogin.success(t.toString());
            }
        });
    }
}
