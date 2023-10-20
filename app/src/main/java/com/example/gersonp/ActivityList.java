package com.example.gersonp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gersonp.Models.Personas;
import com.example.gersonp.configuracion.SQLiteConexion;
import com.example.gersonp.configuracion.Transacciones;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listView;

    ArrayList<Personas> listperson;

    ArrayList<String> ArregloPersonas;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        try
        {
            conexion = new SQLiteConexion(this, Transacciones.namedb, null, 1);
            listView  = (ListView) findViewById(R.id.listpersonas);


            GetPersons();

            ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloPersonas);
            listView.setAdapter(adp);
            listView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {


                }
            }
            );
        }
        catch (Exception ex)
        {
            ex.toString();
        }


    }

    private void GetPersons()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas person = null;
        listperson = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery(Transacciones.SelectTablePersonas,null);
        while(cursor.moveToNext())
        {
            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));

            listperson.add(person);
        }

        cursor.close();
        FillList();
    }

    private void FillList()
    {
        ArregloPersonas = new ArrayList<String>();
        for(int i = 0; i < listperson.size(); i++)
        {
            ArregloPersonas.add(listperson.get(i).getId() + " - " +
                    listperson.get(i).getNombres() + " - " +
                    listperson.get(i).getApellidos() );
        }
    }
}