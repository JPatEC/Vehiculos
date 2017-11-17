package com.edalx.main;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.edalx.model.Colors;
import com.edalx.model.Vehiculo;
import com.edalx.stroge.InMemoryStorage;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import android.view.View;


public class ListActivity extends AppCompatActivity {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.d("INICIO", "Inicia la App");
        ArrayList<Vehiculo> lista = InMemoryStorage.getInstance().getLista();


        TableLayout listaVehiculos = (TableLayout) findViewById(R.id.list_v);
        String[] header = new String[]{"Placa", "Marca", "FechaFab", "Costo", "Matr.", "Color"};
        TableRow rowH = new TableRow(getBaseContext());
        rowH.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        TextView textViewH;
        for (int i = 0; i < header.length; i++) {
            textViewH = new TextView(getBaseContext());
            textViewH.setText(header[i]);
            textViewH.setPadding(4, 4, 4, 4);
            textViewH.setTypeface(null, Typeface.BOLD);
            textViewH.setTextColor(Color.BLACK);
            textViewH.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            rowH.addView(textViewH);
        }
        listaVehiculos.addView(rowH);


        for (Vehiculo registroV : lista) {
            String[] registro = {registroV.getPlaca(), registroV.getMarca(), registroV.getFecFab(), registroV.getCosto().toString(), registroV.getMatriculado() ? "SI" : "NO", registroV.getColor()};

            Log.d("Add", "Paso lista atributos");
            TableRow row = new TableRow(getBaseContext());
            row.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            TextView textView;
            for (int i = 0; i < registro.length; i++) {
                textView = new TextView(getBaseContext());
                textView.setText(registro[i]);
                textView.setPadding(4, 4, 4, 4);
                textView.setTextColor(Color.BLUE);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                row.addView(textView);
            }
            listaVehiculos.addView(row);
        }


    }

    public void linkCreate(View view) {
        Intent list = new Intent(ListActivity.this, CreateActivity.class);
        startActivity(list);
    }
}
