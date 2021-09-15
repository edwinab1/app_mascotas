package com.example.registromascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Mascota> listaMascotas = new ArrayList<>();
    ArrayAdapter<Mascota> adaptador;

    EditText edtNombre, edtRaza, edtEdad, edtColor;
    Button btRegistrar;
    ListView lvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();

         adaptador = new ArrayAdapter<Mascota>(this,
                android.R.layout.simple_list_item_1, listaMascotas);

         lvMascotas.setAdapter(adaptador);


        btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validarDatos()) {

                    Toast.makeText(MainActivity.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();

                } else {

                    Mascota mascota = new Mascota(edtNombre.getText().toString(),
                            edtColor.getText().toString(), edtRaza.getText().toString(),
                            Integer.parseInt(edtEdad.getText().toString()));

                    listaMascotas.add(mascota);

                    adaptador.notifyDataSetChanged();
                    
                    limpiarFormulario();


                }

            }
        });
    }

    private void limpiarFormulario() {

        edtNombre.setText("");
        edtRaza.setText("");
        edtColor.setText("");
        edtEdad.setText("");

    }

    private void setViews() {

        btRegistrar = findViewById(R.id.btRegistrar);
        edtNombre = findViewById(R.id.edtNombre);
        edtRaza = findViewById(R.id.edtRaza);
        edtColor = findViewById(R.id.edtColor);
        edtEdad = findViewById(R.id.edtEdad);

        lvMascotas = findViewById(R.id.lvMascotas);
    }

    //true si esta correcto
    private boolean validarDatos() {

        if (
                        edtEdad.getText().toString().isEmpty() ||
                        edtNombre.getText().toString().isEmpty() ||
                        edtColor.getText().toString().isEmpty() ||
                        edtRaza.getText().toString().isEmpty()
        ) {

            return false;

        }

        return true;
    }


}