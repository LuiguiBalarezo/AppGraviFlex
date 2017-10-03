package com.scriptgo.www.graviflex.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.scriptgo.www.graviflex.R;
import com.scriptgo.www.graviflex.apiprocess.LoginProcessAPI;
import com.scriptgo.www.graviflex.bases.BaseFragment;
import com.scriptgo.www.graviflex.callbacks.APICallBackLogin;
import com.scriptgo.www.graviflex.callbacks.FragmentToActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginFragment extends BaseFragment {

    /* UI */
    @BindView(R.id.edt_usuario)
    EditText edt_usuario;
    @BindView(R.id.edt_clave)
    EditText edt_clave;
    @BindView(R.id.btn_entrar)
    Button btn_entrar;

    /* CALLBACK */
    private FragmentToActivity loginToActivity;

    /* SERVICE */
    LoginProcessAPI loginProcessAPI = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initServices();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentToActivity) {
            loginToActivity = (FragmentToActivity) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        loginToActivity = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /* METHODS CUSTOM */
    @OnClick(R.id.btn_entrar)
    void submit() {
        String usuario = edt_usuario.getText().toString();
        String clave = edt_clave.getText().toString();
        setUsuarioClave(usuario, clave);
    }

    void setUsuarioClave(String... datos) {
        if (datos[0] != null && !datos[0].isEmpty() && datos[1] != null && !datos[1].isEmpty()) {
            loginProcessAPI.loginAPI(datos[0].toString(), datos[0].toString(), new APICallBackLogin() {
                @Override
                public void success(String msg) {
                    Log.d(TAG, "SUCCESS");
                }

                @Override
                public void error(String msg) {
                    Log.d(TAG, "error");
                }

                @Override
                public void fail(String msg) {
                    Log.d(TAG, "fail");
                }

                @Override
                public void timeout(String msg) {
                    Log.d(TAG, "timeout");
                }
            });
//            loginToActivity.showNewFragment(R.id.nav_obras);
//            loginToActivity.showSnackBarSuccess("Usuario valido.");
        } else {
            loginToActivity.showSnackBarError("Usuario y Clave Vacios.");
        }
    }

    /* SERVICES */
    void initServices(){
        loginProcessAPI = new LoginProcessAPI(0);
    }
}
