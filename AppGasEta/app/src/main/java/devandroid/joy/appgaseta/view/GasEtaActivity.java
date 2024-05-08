package devandroid.joy.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.joy.appgaseta.R;
import devandroid.joy.appgaseta.controller.CombustivelController;
import devandroid.joy.appgaseta.model.Combustivel;
import devandroid.joy.appgaseta.util.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {
    CombustivelController controller;

    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    EditText editGasolina;
    EditText editEtanol;
    TextView textResult;

    Button buttonCalcular;
    Button buttonLimpar;
    Button buttonSalvar;
    Button buttonFinalizar;

    double precoGasolina;
    double precoEtanol;
    String recomendacao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        controller = new CombustivelController(GasEtaActivity.this);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        textResult = findViewById(R.id.textResult);

        buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOk = true;

                if (TextUtils.isEmpty(editGasolina.getText())) {
                    editGasolina.setError("* Obrigatório");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                }
                if (TextUtils.isEmpty(editEtanol.getText())) {
                    editEtanol.setError("* Obrigatório");
                    editEtanol.requestFocus();
                    isDadosOk = false;
                }

                if (isDadosOk) {
                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());
                    recomendacao = UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);
                    textResult.setText(recomendacao);

                    buttonSalvar.setEnabled(true);
                } else {
                    Toast.makeText(GasEtaActivity.this, "Preencha corretamente os dados", Toast.LENGTH_LONG).show();
                    buttonSalvar.setEnabled(false);
                }
            }
        });

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editGasolina.setText("");
                editEtanol.setText("");
                buttonSalvar.setEnabled(false);
                controller.limpar();
            }
        });

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));

                controller.salvar(combustivelGasolina);
                controller.salvar(combustivelEtanol);
            }
        });

        buttonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, "Volte sempre!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        // Teste metodo estatico
        // Toast.makeText(GasEtaActivity.this, UtilGasEta.Estatico(), Toast.LENGTH_LONG).show();

        Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorOpcao(
                5.12, 3.25), Toast.LENGTH_LONG).show();
    }
}
