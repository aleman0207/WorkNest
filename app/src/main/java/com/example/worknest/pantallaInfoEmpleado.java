package com.example.worknest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class pantallaInfoEmpleado extends AppCompatActivity {

    Button toFicharEntrada, toFicharSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_info_empleado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pantallaInfo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toFicharEntrada = findViewById(R.id.buttonFicharEntrada);
        toFicharSalida = findViewById(R.id.buttonFicharSalida);


        toFicharEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pantallaInfoEmpleado.this, MainNfc.class)); // Cambiado a MainNfc
            }
        });


        toFicharSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pantallaInfoEmpleado.this, MainNfc.class)); // Cambiado a MainNfc
            }
        });
    }
}
