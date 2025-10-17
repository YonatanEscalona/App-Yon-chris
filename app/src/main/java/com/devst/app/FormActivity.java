package com.devst.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    private EditText etNombreForm, etCorreoForm;
    private TextView tvResultado;

    private final ActivityResultLauncher<Intent> confirmLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                tvResultado = findViewById(R.id.tvResultado);
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    boolean ok = result.getData().getBooleanExtra("resultado_confirmacion", false);
                    tvResultado.setText(ok ? "Confirmado ✅" : "Cancelado ❌");
                } else {
                    tvResultado.setText("Cancelado ❌");
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etNombreForm = findViewById(R.id.etNombreForm);
        etCorreoForm = findViewById(R.id.etCorreoForm);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v -> {
            Intent i = new Intent(FormActivity.this, ConfirmActivity.class);
            i.putExtra("nombre", etNombreForm.getText().toString());
            i.putExtra("correo", etCorreoForm.getText().toString());
            confirmLauncher.launch(i);
        });
    }
}