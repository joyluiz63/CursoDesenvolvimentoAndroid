package devandroid.joy.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GasEtaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "gaseta.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getReadableDatabase();
    }

    // create database (Nome do banco de dados e versão)
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabelaCombustivel = "CREATE TABLE Combustivel(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeDoCombustivel TEXT, " +
                "precoDoCombustivel REAL, " +
                "recomendacao TEXT)";

        db.execSQL(sqlTabelaCombustivel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // TODO Implement method create
    public void create(String tabela, ContentValues dados){

        db.insert(tabela, null, dados);
        // String sqlCreate = "INSERT INTO Combustivel(nomeDoCombustivel, precoDoCombustivel, recomendacao) " +
             //   "VALUES ("Gasolina", 5.84, "Abastecer com Gasolina!")";
    }

    // TODO Implement method retrieve

    // TODO Implement method update

    // TODO Implement method delete
}
