package com.devst.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        String nombre = getIntent().getStringExtra("nombre");
        String correo = getIntent().getStringExtra("correo");

        TextView tvResumen = findViewById(R.id.tvResumen);
        tvResumen.setText("¿Confirmas el envío?\n\nNombre: " + nombre + "\nCorreo: " + correo);

        Button btnOk = findViewById(R.id.btnOk);
        Button btnCancelar = findViewById(R.id.btnCancelar);

        btnOk.setOnClickListener(v -> {
            Intent data = new Intent();
            data.putExtra("resultado_confirmacion", true);
            setResult(RESULT_OK, data);
            finish();
        });

        btnCancelar.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}