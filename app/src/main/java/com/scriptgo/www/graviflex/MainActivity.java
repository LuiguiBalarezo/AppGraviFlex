package com.scriptgo.www.graviflex;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.scriptgo.www.graviflex.callbacks.FragmentToActivity;
import com.scriptgo.www.graviflex.fragments.EgresosFragment;
import com.scriptgo.www.graviflex.fragments.IngresosFragment;
import com.scriptgo.www.graviflex.fragments.LoginFragment;
import com.scriptgo.www.graviflex.fragments.MovilidadFragment;
import com.scriptgo.www.graviflex.fragments.ObrasFragment;
import com.scriptgo.www.graviflex.fragments.TrabajadoresFragment;
import com.scriptgo.www.graviflex.utils.UtilSnackBar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        FragmentToActivity {

    /* UI */
    DrawerLayout drawer = null;
    FloatingActionButton fab = null;
    Toolbar toolbar = null;
    ActionBarDrawerToggle toggle = null;
    NavigationView navigationView = null;
    UtilSnackBar utilSnackBar = null;

    /* FRAGMENTS */
    Fragment fragment = null;
    Class fragmentClass = null;
    FrameLayout frameLayout = null;
    FragmentManager fragmentManager = null;
    FragmentTransaction fragmentTransaction = null;

    /* CONSTANT */
    String SHOWFRAGMENT = "SHOWFRAGMENT";

    /* VARS */
    int itemmenuselected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {
            itemmenuselected = savedInstanceState.getInt(SHOWFRAGMENT, 0);
        }
        initUI();
        selectItemMenuDrawer(itemmenuselected);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        itemmenuselected = id;
        selectItemMenuDrawer(itemmenuselected);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SHOWFRAGMENT, itemmenuselected);
        super.onSaveInstanceState(outState);
    }

    /* METHODS CUSTOM */
    void initUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        utilSnackBar = new UtilSnackBar(this, fab);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        afterInitUI();
    }

    void afterInitUI() {
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        // DESABILITA EL TITULO POR DEFECTO
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        navigationView.setNavigationItemSelectedListener(this);
    }

    void setDisableMenuDrawable(Boolean isdisable, Integer iditemselectmenu) {
        if (isdisable != null) {
            if (isdisable) {
                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                toggle.setDrawerIndicatorEnabled(false);
                setShowFloaButton(false);
            } else {
                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                toggle.setDrawerIndicatorEnabled(true);
                setShowFloaButton(true);
            }
        }
        if (iditemselectmenu != null) {
            navigationView.setCheckedItem(iditemselectmenu);
        }
    }

    void setTitleToolBar(String titleToolBar, String subtitle) {
        toolbar.setTitle(titleToolBar);
        toolbar.setSubtitle(subtitle);
    }

    void setShowFloaButton(boolean isshow) {
        if (isshow) {
            fab.show();
        } else {
            fab.hide();
        }
    }

    void setAdministratorFragment(Class fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String tag = fragment.getClass().getSimpleName();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.framelayout_container, fragment, tag).commit();
    }

    /* INITFRAGMENTS */
    void initFragment(Class aClass) {
        fragmentClass = aClass;
        setAdministratorFragment(fragmentClass);
    }

    void selectItemMenuDrawer(int id) {

        final int obras = R.id.nav_obras;
        final int egresos = R.id.nav_egresos;
        final int ingresos = R.id.nav_ingresos;
        final int trabajadores = R.id.nav_trabajadores;
        final int movilidad = R.id.nav_movilidad;
        final int rpt_obras = R.id.nav_r_obras;
        final int rpt_egresos = R.id.nav_r_egresos;
        final int rpt_ingresos = R.id.nav_r_ingresos;
        final int rpt_trabajadores = R.id.nav_r_trabajadores;
        final int preferencias = R.id.nav_preferencias;
        final int salir = R.id.nav_salir;

        switch (id) {
            case obras:
                setTitleToolBar("Obras", "Mantenimiento");
                initFragment(ObrasFragment.class);
                setDisableMenuDrawable(false, obras);//NAVIGATION
                break;
            case egresos:
                setTitleToolBar("Egresos", "Mantenimiento");
                initFragment(EgresosFragment.class);
                setDisableMenuDrawable(false, egresos);//NAVIGATION
                break;
            case ingresos:
                setTitleToolBar("Ingresos", "Mantenimiento");
                initFragment(IngresosFragment.class);
                setDisableMenuDrawable(false, ingresos);//NAVIGATION
                break;
            case trabajadores:
                setTitleToolBar("Egresos", "Mantenimiento");
                initFragment(TrabajadoresFragment.class);
                setDisableMenuDrawable(false, trabajadores);//NAVIGATION
                break;
            case movilidad:
                setTitleToolBar("Movilidad", "Mantenimiento");
                initFragment(MovilidadFragment.class);
                setDisableMenuDrawable(false, movilidad);
                break;
            case rpt_obras:
                setTitleToolBar("Obras", "Resporte");
                setDisableMenuDrawable(null, rpt_obras);
                setShowFloaButton(false);
                break;
            case rpt_egresos:
                setTitleToolBar("Egresos", "Resporte");
                setDisableMenuDrawable(null, rpt_egresos);
                setShowFloaButton(false);
                break;
            case rpt_ingresos:
                setTitleToolBar("Ingresos", "Resporte");
                setDisableMenuDrawable(null, rpt_ingresos);
                setShowFloaButton(false);
                break;
            case rpt_trabajadores:
                setTitleToolBar("Trabajadores", "Resporte");
                setDisableMenuDrawable(null, rpt_trabajadores);
                setShowFloaButton(false);
                break;
            case preferencias:
                setTitleToolBar("Preferencias", null);
                setDisableMenuDrawable(null, preferencias);
                setShowFloaButton(false);
                break;
            case salir:
                setTitleToolBar("Login", null);
                initFragment(LoginFragment.class);
                setDisableMenuDrawable(true, null);
                break;
            default:
                setTitleToolBar("Login", null);
                initFragment(LoginFragment.class);
                setDisableMenuDrawable(true, null);
                break;
        }
    }

    /* METHODS CALLBACKS */
    @Override
    public void showNewFragment(int iditemnenu) {
        itemmenuselected = iditemnenu;
        selectItemMenuDrawer(iditemnenu);
    }

    @Override
    public void showSnackBarError(String text) {
        utilSnackBar.showSnackBar(text).error();
    }

    @Override
    public void showSnackBarSuccess(String text) {
        utilSnackBar.showSnackBar(text).success();
    }

    @Override
    public void showSnackBarInfo(String text) {
        utilSnackBar.showSnackBar(text).info();
    }

    @Override
    public void showSnackBarLog(String text) {
        utilSnackBar.showSnackBar(text).log();
    }
}
