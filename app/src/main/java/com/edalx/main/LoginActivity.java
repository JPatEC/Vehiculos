package com.edalx.main;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText pass=(EditText) findViewById(R.id.password);
        Button reset = (Button) findViewById(R.id.limpiar);

        final EditText user=(EditText) findViewById(R.id.email);
        //reset = (Button) findViewById(R.id.limpiar);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass.setText("");
                user.setText("");
            }
        });
    }


    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "Alexander:Cuji",
            "Darwin:Correa",
            "Patricio:Rodriguez",
            "Alex:Proaño"
    };

    public void validarLogin(View view) {
        EditText user = (EditText) findViewById(R.id.email);
        EditText pass = (EditText) findViewById(R.id.password);
        String[] aux=DUMMY_CREDENTIALS;
        boolean login=true;
        for (int i = 0; i < aux.length; i++) {
            String[] credential = aux[i].split(":");
            if (credential[0].equalsIgnoreCase(user.getText().toString()) && credential[1].equals(pass.getText().toString())) {
                Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_LONG).show();
                Intent list = new Intent(LoginActivity.this, ListActivity.class);
                startActivity(list);
                login=false;
            }
        }
        if(login) {
            Toast.makeText(LoginActivity.this, "Usuario y Contraseña no validos", Toast.LENGTH_LONG).show();
        }
    }



}


