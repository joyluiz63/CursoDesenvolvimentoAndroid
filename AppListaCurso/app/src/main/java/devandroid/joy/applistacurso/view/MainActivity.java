package devandroid.joy.applistacurso.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import devandroid.joy.applistacurso.R;
import devandroid.joy.applistacurso.controller.CursoController;
import devandroid.joy.applistacurso.controller.PessoaController;
import devandroid.joy.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController pessoaController;
    CursoController cursoController;

    Pessoa pessoa;
    List<String> nomesDosCursos;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editTelefoneContato;
    Button buttonLimpar;
    Button buttonSalvar;
    Button buttonFinalizar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        pessoaController = new PessoaController(MainActivity.this);
        pessoaController.toString();

        pessoa = new Pessoa();
        pessoaController.buscar(pessoa);

        editPrimeiroNome = findViewById(R.id.editFirstName);
        editSobrenome = findViewById(R.id.editSecondaryName);
        editNomeCurso = findViewById(R.id.editCourseName);
        editTelefoneContato = findViewById(R.id.editContactPhone);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);


        // Adapter - Layout - Injetar o adapter ao spinner. A lista será gerada
        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosParaSpinner();

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                cursoController.dadosParaSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);


        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");

                pessoaController.limpar();
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
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();

                pessoaController.salvar(pessoa);
            }
        });

        Log.i("POOAndroid", pessoa.toString());
    }
}