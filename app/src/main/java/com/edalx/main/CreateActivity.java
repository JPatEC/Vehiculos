package com.edalx.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.Button;

import com.edalx.main.ListActivity;
import com.edalx.model.Colors;
import com.edalx.model.Vehiculo;
import com.edalx.stroge.InMemoryStorage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CreateActivity extends AppCompatActivity {
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        //Cargar el enumerado en el Spinner
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        mySpinner.setAdapter(new ArrayAdapter<Colors>(this, android.R.layout.simple_spinner_item, Colors.values()));

    }

    public void IngresarV(View view) {
        ArrayList<Vehiculo> lista = InMemoryStorage.getInstance().getLista();
        //Leer los campos del formulario
        final EditText placafield = (EditText) findViewById(R.id.placa);
        final String placa = placafield.getText().toString();
        final EditText marcafield = (EditText) findViewById(R.id.marca);
        String marca = marcafield.getText().toString();
        final EditText fecFabfield = (EditText) findViewById(R.id.fecFab);
        String fecFab = fecFabfield.getText().toString();
        final EditText costofield = (EditText) findViewById(R.id.Costo);
        String costo = costofield.getText().toString();
        final Spinner colorfield = (Spinner) findViewById(R.id.spinner);
        String color = colorfield.getSelectedItem().toString();
        final CheckBox matricul = (CheckBox) findViewById(R.id.Matriculado);
        boolean matriculado = matricul.isChecked();
        //Reset
        Button clean = (Button) findViewById(R.id.limpiar);
        //
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placafield.setText("");
                marcafield.setText("");
                fecFabfield.setText("");
                costofield.setText("");
            }
        });
        /*Creacion del Vehiculo*/
        Vehiculo item = new Vehiculo();
        item.setPlaca(placa);
        item.setMarca(marca);
        item.setFecFab(fecFab);
        item.setCosto(Double.parseDouble(costo));
        item.setColor(color);
        item.setMatriculado(matriculado);
        lista.add(item);
        TableLayout listaVehiculos = (TableLayout) findViewById(R.id.list_v);
        Toast.makeText(getApplicationContext(), "Vehiculo Ingresado", Toast.LENGTH_LONG).show();
        Intent list = new Intent(CreateActivity.this, ListActivity.class);
        startActivity(list);

    }
}
