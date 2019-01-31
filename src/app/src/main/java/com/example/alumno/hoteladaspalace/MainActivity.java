package com.example.alumno.hoteladaspalace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.alumno.hoteladaspalace.Fragments.Registro;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
    }
    public void onClick(View  view){
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.registrarUusarios:
                miIntent=new Intent(MainActivity.this,Registro.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }
}
