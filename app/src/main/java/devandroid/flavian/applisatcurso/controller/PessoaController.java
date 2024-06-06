package devandroid.flavian.applisatcurso.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.flavian.applisatcurso.model.Pessoa;
import devandroid.flavian.applisatcurso.view.MainActivity;

public class PessoaController{

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "preference_listavip";

/*    public PessoaController(MainActivity mainActivity) {

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }*/

    public PessoaController(Context context) {

        preferences = context.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    public void clearPerson() {

        listaVip.clear();
        listaVip.apply();
    }

    public void SavePerson(Pessoa pessoa) {

/*        MainActivity mainActivity = new MainActivity();*/

/*        pessoa.setFirstName(mainActivity.editTextFirstName.getText().toString());
        pessoa.setSurName(mainActivity.editTextSurName.getText().toString());
        pessoa.setDesiredCourse(mainActivity.editTextDesiredCourse.getText().toString());
        pessoa.setPhoneNumber(mainActivity.editTextPhoneNumber.getText().toString());*/

        String firstName = pessoa.getFirstName();

        CreateSharedPreferencesFile(pessoa);
    }

    public void CreateSharedPreferencesFile(Pessoa pessoa) {

        listaVip.putString("PrimeiroNome", pessoa.getFirstName());
        listaVip.putString("Sobrenome", pessoa.getSurName());
        listaVip.putString("CursoDesejado", pessoa.getDesiredCourse());
        listaVip.putString("TelefoneContato", pessoa.getPhoneNumber());
        listaVip.apply();
    }

    public Pessoa GetPerson(Pessoa pessoa){

        pessoa.setFirstName(preferences.getString("PrimeiroNome", ""));
        pessoa.setSurName(preferences.getString("Sobrenome", ""));
        pessoa.setDesiredCourse(preferences.getString("CursoDesejado", ""));
        pessoa.setPhoneNumber(preferences.getString("TelefoneContato", ""));

        return pessoa;
    }

    @NonNull
    @Override
    public String toString() {

        return super.toString();
    }
}
