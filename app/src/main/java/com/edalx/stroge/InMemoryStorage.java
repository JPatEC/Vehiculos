package com.edalx.stroge;

import android.util.Log;

import com.edalx.model.Colors;
import com.edalx.model.Vehiculo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Patrick on 15/11/2017.
 */

public class InMemoryStorage {
    private static InMemoryStorage instance = null;
    private ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
    protected InMemoryStorage() {
        // Exists only to defeat instantiation.
    }
    public static InMemoryStorage getInstance() {
        if(instance == null) {
            instance = new InMemoryStorage();

            Calendar calendar = new GregorianCalendar(2016, 11, 28);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

            Vehiculo item = new Vehiculo();
            item.setPlaca("PBP-403");
            item.setMarca("Mazda");
            item.setFecFab(formatter.format(calendar.getTime()));
            item.setMatriculado(true);
            item.setCosto(12000d);
            item.setColor(Colors.Negro.name());
            Log.d("Crear", "Crear un vehículo");
            System.out.println(item);
            Calendar calendar2 = new GregorianCalendar(2017, 12, 02);
            Vehiculo item2 = new Vehiculo();
            item2.setPlaca("PKW-843");
            item2.setMarca("Chevrolet");
            item2.setFecFab(formatter.format(calendar2.getTime()));
            item2.setMatriculado(false);
            item2.setCosto(22500d);
            item2.setColor(Colors.Blanco.name());
            Log.d("Crear", "Crear un vehículo");
            System.out.println(item2);


            instance.getLista().add(item);
            instance.getLista().add(item2);
            Log.d("Add", "Añade a la lista");
        }
        return instance;
    }

    public ArrayList<Vehiculo> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Vehiculo> lista) {
        this.lista = lista;
    }
}
