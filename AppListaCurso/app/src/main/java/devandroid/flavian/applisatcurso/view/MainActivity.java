package devandroid.flavian.applisatcurso.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import devandroid.flavian.applisatcurso.R;
import devandroid.flavian.applisatcurso.controller.CursoController;
import devandroid.flavian.applisatcurso.controller.PessoaController;
import devandroid.flavian.applisatcurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    PessoaController controller;
    CursoController cursoController;

    List<String> NameOfCourse;

    public EditText editTextFirstName;
    public EditText editTextSurName;
    public EditText editTextDesiredCourse;
    public EditText editTextPhoneNumber;

    Button clearButton;
    Button saveButton;
    Button finalizeButton;

    Spinner spinner;


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

        cursoController = new CursoController();
        NameOfCourse = cursoController.SpinnerDatas();
        pessoa = new Pessoa();

        controller = new PessoaController(MainActivity.this);
        controller.GetPerson(pessoa);

        // Mapping the text fields on the main screen
        editTextFirstName = findViewById(R.id.editFirstName);
        editTextSurName = findViewById(R.id.editSurName);
        editTextDesiredCourse = findViewById(R.id.editDesiredCourse);
        editTextPhoneNumber = findViewById(R.id.editPhoneNumber);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, cursoController.SpinnerDatas());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);

        //Mapping the button on the main screen
        clearButton = findViewById(R.id.clearButton);
        saveButton = findViewById(R.id.saveButton);
        finalizeButton = findViewById(R.id.finalizeButton);

        editTextFirstName.setText(pessoa.getFirstName());
        editTextSurName.setText(pessoa.getSurName());
        editTextDesiredCourse.setText(pessoa.getDesiredCourse());
        editTextPhoneNumber.setText(pessoa.getPhoneNumber());

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editTextFirstName.setText("");
                editTextSurName.setText("");
                editTextDesiredCourse.setText("");
                editTextPhoneNumber.setText("");

                controller.clearPerson();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pessoa.setFirstName(editTextFirstName.getText().toString());
                pessoa.setSurName(editTextSurName.getText().toString());
                pessoa.setDesiredCourse(editTextDesiredCourse.getText().toString());
                pessoa.setPhoneNumber(editTextPhoneNumber.getText().toString());

                Toast.makeText(MainActivity.this,
                        "Dados Salvos Com Sucesso!" + pessoa.toString(),
                        Toast.LENGTH_LONG).show();

                //controller.SavePerson(pessoa);
                controller.CreateSharedPreferencesFile(pessoa);
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