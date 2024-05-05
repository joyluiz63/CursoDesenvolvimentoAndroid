package devandroid.joy.applistacurso.view;

import android.os.Bundle;

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
        pessoa1.setPrimeiroNome("Joy");
        pessoa1.setSobreNome("Silva");
        pessoa1.setCursoDesejado("Android");
        pessoa1.setTelefoneContato("51-995833818");

        pessoa2 = new Pessoa();
        pessoa2.setPrimeiroNome("Francisco");
        pessoa2.setSobreNome("Assis");
        pessoa2.setCursoDesejado("Android");
        pessoa2.setTelefoneContato("51-998653211");


        dadosPessoa1 = "Primeiro nome: ";
        dadosPessoa1 += pessoa1.getPrimeiroNome();
        dadosPessoa1 += " Sobrenome: ";
        dadosPessoa1 += pessoa1.getSobreNome();

        int parada = 0;

    }
}