package com.example.alumno.hoteladaspalace;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumno.hoteladaspalace.utilities.utilities;

public class Registro_Usuario extends AppCompatActivity {
    EditText campoID,campoNombre,campoTelefono;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        campoID=(EditText)findViewById(R.id.campoID);
        campoNombre=(EditText)findViewById(R.id.campoNombre);
        campoTelefono=(EditText)findViewById(R.id.campoTelefono);

    }
    public void onClick(View view){
       // registarusuarios(); sirve para q se sume uno en uno
        registarusuariosSQL();
    }

    private void registarusuariosSQL() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        //insert into usuario(id,nombre,telefono) values
        String insert="INSERT INTO "+utilities.TABLA_USUARIO
                +" ( " +utilities.CAMPO_ID+","+utilities.CAMPO_NOMBRE+","+utilities.CAMPO_TELEFONO+")" +
                " VALUES ("+campoID.getText().toString()+", '"+campoNombre.getText().toString()+"','"
                +campoTelefono.getText().toString()+"')";

        db.execSQL(insert);
        db.close();
    }

    private void registarusuarios() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilities.CAMPO_ID,campoID.getText().toString());
        values.put(utilities.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(utilities.CAMPO_TELEFONO,campoTelefono.getText().toString());

        Long idResultante=db.insert(utilities.TABLA_USUARIO,utilities.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(),"Id Registro:"+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
}
