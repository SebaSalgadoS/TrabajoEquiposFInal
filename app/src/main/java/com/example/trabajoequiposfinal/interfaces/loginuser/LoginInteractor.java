package com.example.trabajoequiposfinal.interfaces.loginuser;

import android.content.Context;

public interface LoginInteractor {
    void validarUsuario(String user, String pass, LoginPresenter presentador, Context contexto);
}
