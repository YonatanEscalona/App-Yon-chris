package com.devst.app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;


public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        String nombre = getIntent().getStringExtra("nombre");
        String precio = getIntent().getStringExtra("precio");

        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvPrecio = findViewById(R.id.tvPrecio);

        tvNombre.setText("Nombre: " + (nombre == null ? "" : nombre));
        tvPrecio.setText("Precio: " + (precio == null ? "" : precio));
    }
}