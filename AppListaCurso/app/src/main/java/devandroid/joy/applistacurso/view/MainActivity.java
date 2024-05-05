package devandroid.joy.applistacurso.view;

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

import devandroid.joy.applistacurso.R;
import devandroid.joy.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa1;
    Pessoa pessoa2;

    String dadosPessoa1;
    String dadosPessoa2;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editTelefoneContato;
    Button buttonLimpar;
    Button buttonSalvar;
    Button buttonFinalizar;

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

        pessoa1 = new Pessoa();
        //pessoa1.setPrimeiroNome("Joy");
        //pessoa1.setSobreNome("Silva");
        //pessoa1.setCursoDesejado("Android");
        //pessoa1.setTelefoneContato("51-995833818");


        pessoa2 = new Pessoa();
        pessoa2.setPrimeiroNome("Francisco");
        pessoa2.setSobreNome("Assis");
        pessoa2.setCursoDesejado("Android");
        pessoa2.setTelefoneContato("51-998653211");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);

        editPrimeiroNome.setText(pessoa1.getPrimeiroNome());
        editSobrenome.setText(pessoa1.getSobreNome());
        editNomeCurso.setText(pessoa1.getCursoDesejado());
        editTelefoneContato.setText(pessoa1.getTelefoneContato());

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");
            }
        });

        buttonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte sempre!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa1.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa1.setSobreNome(editSobrenome.getText().toString());
                pessoa1.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa1.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo "+pessoa2.toString(), Toast.LENGTH_LONG).show();
            }
        });

       /* dadosPessoa1 = "Primeiro nome: ";
        dadosPessoa1 += pessoa1.getPrimeiroNome();
        dadosPessoa1 += " Sobrenome: ";
        dadosPessoa1 += pessoa1.getSobreNome();

        Log.i("POOAndroid", pessoa1.toString());
        Log.i("POOAndroid", pessoa2.toString());

        */

    }
}