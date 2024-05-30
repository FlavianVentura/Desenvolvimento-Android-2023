package devandroid.flavian.applisatcurso.view;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.flavian.applisatcurso.R;
import devandroid.flavian.applisatcurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa outraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

    EditText editFirstName;
    EditText editSurName;
    EditText editDesiredCourse;
    EditText editPhoneNumber;

    Button clearButton;
    Button saveButton;
    Button finallyButton;

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

        pessoa = new Pessoa();

        pessoa.setFirstName("Flavian");
        pessoa.setSurName("Ventura");
        pessoa.setDesiredCourse("Android");
        pessoa.setPhoneNumber("81988434830");

        outraPessoa = new Pessoa();

        outraPessoa.setFirstName("Papai Noel");
        outraPessoa.setSurName("Silva Sauro");
        outraPessoa.setDesiredCourse("UWP WINUI");
        outraPessoa.setPhoneNumber("81 9 86587478");

        editFirstName = findViewById(R.id.editFirstName);
        editSurName = findViewById(R.id.editSurName);
        editDesiredCourse = findViewById(R.id.editDesiredCourse);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);

        clearButton = findViewById(R.id.clearButton);
        saveButton = findViewById(R.id.saveButton);
        finallyButton = findViewById(R.id.finallyButton);

        editFirstName.setText(pessoa.getFirstName());
        editSurName.setText(pessoa.getSurName());
        editDesiredCourse.setText(pessoa.getDesiredCourse());
        editPhoneNumber.setText(pessoa.getPhoneNumber());


/*        dadosPessoa = "Primeiro Nome: ";
        dadosPessoa += pessoa.getFirstName();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSurName();
        dadosPessoa += " Curso Desejado: ";
        dadosPessoa += pessoa.getDesiredCourse();
        dadosPessoa += " Telefone Contato: ";
        dadosPessoa += pessoa.getPhoneNumber();

        dadosOutraPessoa = "Primeiro Nome: ";
        dadosOutraPessoa += outraPessoa.getFirstName();
        dadosOutraPessoa += " Sobrenome: ";
        dadosOutraPessoa += outraPessoa.getSurName();
        dadosOutraPessoa += " Curso Desejado: ";
        dadosOutraPessoa += outraPessoa.getDesiredCourse();
        dadosOutraPessoa += " Telefone Contato: ";
        dadosOutraPessoa += outraPessoa.getPhoneNumber();
*/

        Log.i("POOHerança", "Objeto Pessoa " + pessoa.toString());
    }
}