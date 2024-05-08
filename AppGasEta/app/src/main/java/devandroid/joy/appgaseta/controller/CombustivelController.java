package devandroid.joy.appgaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import devandroid.joy.appgaseta.database.GasEtaDB;
import devandroid.joy.appgaseta.model.Combustivel;
import devandroid.joy.appgaseta.view.GasEtaActivity;

public class CombustivelController extends GasEtaDB {

    SharedPreferences preferences;
    SharedPreferences.Editor dadosPreferences;
    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity activity) {
        super(activity);
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences = preferences.edit();
    }

    public void salvar(Combustivel combustivel) {
        /*
        * SHAREDPREFERENCES
        * dadosPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        * dadosPreferences.putFloat("precoDoCombustivel", (float) combustivel.getPrecoDoCombustivel());
        * dadosPreferences.putString("recomendacao", combustivel.getRecomendacao());
        * dadosPreferences.apply();
        * */

        ContentValues dados = new ContentValues();

        dados.put("nomeDoCombustivel", combustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        create("Combustivel", dados);
    }

    public void limpar() {
        dadosPreferences.clear();
        dadosPreferences.apply();
    }
}
