package com.example.registromascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Mascota> listaMascotas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btRegistrar = findViewById(R.id.btRegistrar);

        EditText edtNombre = findViewById(R.id.edtNombre);
        EditText edtRaza = findViewById(R.id.edtRaza);
        EditText edtColor = findViewById(R.id.edtColor);
        EditText edtEdad = findViewById(R.id.edtEdad);


        btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(edtEdad.getText().toString().isEmpty()){

                    Toast.makeText(MainActivity.this, "Introduce la edad", Toast.LENGTH_SHORT).show();

                }else{

                    Mascota mascota = new Mascota(edtNombre.getText().toString(),
                            edtColor.getText().toString(), edtRaza.getText().toString(),
                            Integer.parseInt(edtEdad.getText().toString()));

                    Toast.makeText(MainActivity.this, mascota.nombre, Toast.LENGTH_LONG).show();
                }

            }
        });











    }
}