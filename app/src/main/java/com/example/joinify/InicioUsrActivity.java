package com.example.joinify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InicioUsrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_usr); // Layout con el header incluido

        // Obtener el header y actualizarlo
        Header header = findViewById(R.id.header);
        if (header != null) {
            header.updateHeader(this); // Actualizar el header con el nombre del usuario
        }

        // Configurar botón "Login" dentro del header (para registro)
        View headerView = findViewById(R.id.header);
        if (headerView != null) {
            Button btnLoginHeader = headerView.findViewById(R.id.btn_register);
            if (btnLoginHeader != null) {
                btnLoginHeader.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Redirigir a la actividad Registro
                        Intent intent = new Intent(InicioUsrActivity.this, Registro.class);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
