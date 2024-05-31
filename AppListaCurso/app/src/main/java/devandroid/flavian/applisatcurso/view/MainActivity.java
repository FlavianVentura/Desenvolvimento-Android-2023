package devandroid.flavian.applisatcurso.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.flavian.applisatcurso.R;
import devandroid.flavian.applisatcurso.controller.PessoaController;
import devandroid.flavian.applisatcurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NAME_PREFERENCES = "preference_listavip";

    PessoaController controller;
    Pessoa pessoa;
    Pessoa outraPessoa;

    EditText editFirstName;
    EditText editSurName;
    EditText editDesiredCourse;
    EditText editPhoneNumber;

    Button clearButton;
    Button saveButton;
    Button finalizeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        preferences = getSharedPreferences(NAME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = preferences.edit();

        controller = new PessoaController();

        pessoa = new Pessoa();

        editFirstName = findViewById(R.id.editFirstName);
        editSurName = findViewById(R.id.editSurName);
        editDesiredCourse = findViewById(R.id.editDesiredCourse);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);

        clearButton = findViewById(R.id.clearButton);
        saveButton = findViewById(R.id.saveButton);
        finalizeButton = findViewById(R.id.finalizeButton);

/*      editFirstName.setText(pessoa.getFirstName());
        editSurName.setText(pessoa.getSurName());
        editDesiredCourse.setText(pessoa.getDesiredCourse());
        editPhoneNumber.setText(pessoa.getPhoneNumber());
*/

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFirstName.setText("");
                editSurName.setText("");
                editDesiredCourse.setText("");
                editPhoneNumber.setText("");
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pessoa.setFirstName(editFirstName.getText().toString());
                pessoa.setSurName(editSurName.getText().toString());
                pessoa.setDesiredCourse(editDesiredCourse.getText().toString());
                pessoa.setPhoneNumber(editPhoneNumber.getText().toString());

                Toast.makeText(MainActivity.this,
                        "Dados Salvos Com Sucesso!" + pessoa.toString(),
                        Toast.LENGTH_LONG).show();

                listaVip.putString("PrimeiroNome", pessoa.getFirstName());
                listaVip.putString("Sobrenome", pessoa.getSurName());
                listaVip.putString("CursoDesejado", pessoa.getDesiredCourse());
                listaVip.putString("TelefoneCOntato", pessoa.getPhoneNumber());
                listaVip.apply();

                controller.savePessoa(pessoa);
            }
        });

        finalizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "App Finalizado!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}