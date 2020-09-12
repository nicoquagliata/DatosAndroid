package com.uy.cra.datos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class DetalleDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    private Integer day;
    private Integer month;
    private Integer year;

    private String nombre;
    private String telefono;
    private String email;
    private String descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_datos);

        Bundle parametros = getIntent().getExtras();
        nombre = parametros.getString(getResources().getString(R.string.fuser));

        day = parametros.getInt("day");
        month = parametros.getInt("month");
        year = parametros.getInt("year");
        String fecha = day + " / "+ (month+1) +" / "+ year;

        telefono = parametros.getString(getResources().getString(R.string.ftelefono));
        email = parametros.getString(getResources().getString(R.string.femail));
        descripcion = parametros.getString(getResources().getString(R.string.fdescripcion));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

    }

    public void editarDatos(View view){
        Intent intent = new Intent(DetalleDatos.this, MainActivity.class);
        intent.putExtra("prueba", "prueba Datos");
        intent.putExtra(getResources().getString(R.string.fuser), nombre);
        intent.putExtra("day", day);
        intent.putExtra("month", month);
        intent.putExtra("year", year);
        intent.putExtra(getResources().getString(R.string.ftelefono), telefono);
        intent.putExtra(getResources().getString(R.string.femail), email);
        intent.putExtra(getResources().getString(R.string.fdescripcion), descripcion);

        startActivity(intent);
    }

}