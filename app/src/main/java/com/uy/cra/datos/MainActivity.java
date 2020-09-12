package com.uy.cra.datos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private Editable nombre;
    private Editable telefono;
    private Editable email;
    private Editable descripcion;
    private String fecha;
    private DatePicker picker;

    private TextInputLayout form_nombre;
    private TextInputLayout form_telefono;
    private TextInputLayout form_email;
    private TextInputLayout form_descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        form_nombre   = (TextInputLayout) findViewById(R.id.form_username);
        picker=(DatePicker)findViewById(R.id.form_datePicker);
        form_telefono = (TextInputLayout) findViewById(R.id.form_telefono);
        form_email = (TextInputLayout) findViewById(R.id.form_email);
        form_descripcion = (TextInputLayout) findViewById(R.id.form_descripcion);


        //form_nombre.setHelperText(parametros.getString(getResources().getString(R.string.fuser)));
        if( getIntent().getExtras() != null)
        {
            Bundle parametros = getIntent().getExtras();
            form_nombre.getEditText().setText(parametros.getString(getResources().getString(R.string.fuser)));
            picker.init(parametros.getInt("year"), parametros.getInt("month"), parametros.getInt("day"), null);
            form_telefono.getEditText().setText(parametros.getString(getResources().getString(R.string.ftelefono)));
            form_email.getEditText().setText(parametros.getString(getResources().getString(R.string.femail)));
            form_descripcion.getEditText().setText(parametros.getString(getResources().getString(R.string.fdescripcion)));
        }





        Button form_submit = (Button) findViewById(R.id.form_submit);

        form_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //nombre
                nombre = form_nombre.getEditText().getText();

                // date picker
                int day = picker.getDayOfMonth();
                int month = picker.getMonth();
                int year = picker.getYear();
                fecha = "Selected Date: "+ picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear();

                //telefono
                telefono = form_telefono.getEditText().getText();

                //email
                email = form_email.getEditText().getText();

                //descripcion
                descripcion = form_descripcion.getEditText().getText();

                Intent intent = new Intent(MainActivity.this, DetalleDatos.class);
                intent.putExtra(getResources().getString(R.string.fuser), nombre.toString());
                intent.putExtra("day", day);
                intent.putExtra("month", month);
                intent.putExtra("year", year);
                intent.putExtra(getResources().getString(R.string.ftelefono), telefono.toString());
                intent.putExtra(getResources().getString(R.string.femail), email.toString());
                intent.putExtra(getResources().getString(R.string.fdescripcion), descripcion.toString());

                startActivity(intent);


            }
        });

    }

}