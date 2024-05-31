package devandroid.flavian.applisatcurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.flavian.applisatcurso.model.Pessoa;

public class PessoaController {

    public void savePessoa(Pessoa pessoa){

        Log.i("MVC_CONTROLLER", "Pessoa salva" + pessoa.toString());
    }

    @NonNull
    @Override
    public String toString() {

        return super.toString();
    }
}
