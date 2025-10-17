package com.devst.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.RadioGroup;
import android.widget.Toast;

public class SwitchActivity extends AppCompatActivity {

    private RadioButton rbCamara, rbPerfil;

    private RadioGroup rgOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        RadioGroup rgOpciones = findViewById(R.id.rgOpciones);
        Button btnAbrir = findViewById(R.id.btnAbrir);

        btnAbrir.setOnClickListener(v -> {
            int checkedId = rgOpciones.getCheckedRadioButtonId();

            if (checkedId == R.id.rbCamara) {
                startActivity(new Intent(SwitchActivity.this, CamaraActivity.class));
            } else if (checkedId == R.id.rbPerfil) {
                startActivity(new Intent(SwitchActivity.this, PerfilActivity.class));
            } else {
                Toast.makeText(this, "Selecciona una opción", Toast.LENGTH_SHORT).show();
            }
        });
    }
}