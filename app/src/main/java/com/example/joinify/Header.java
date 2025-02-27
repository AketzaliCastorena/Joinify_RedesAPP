package com.example.joinify;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Header extends LinearLayout {

    Button btnRegister;
    TextView tvUsername;
    ImageView iconLogout, iconCreateGroup, iconMisGrupos;

    public Header(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(Context context) {
        // Inflar el layout del header
        LayoutInflater.from(context).inflate(R.layout.header, this, true);

        // Asociar vistas
        btnRegister = findViewById(R.id.btn_register);
        tvUsername = findViewById(R.id.tvUsername);
        iconLogout = findViewById(R.id.iconLogout);
        iconCreateGroup = findViewById(R.id.iconCreateGroup);
        iconMisGrupos = findViewById(R.id.iconMisGrupos);

        // Actualizar el Header
        updateHeader(context);

        // Configurar la acción para ir a la página de Registro
        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(context, Registro.class);
            context.startActivity(intent);
        });

        // Configurar el icono de logout
        iconLogout.setOnClickListener(v -> {
            SessionManager.getInstance(context).logout();
            Intent intent = new Intent(context, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
        });

        // Configurar el icono de Crear Grupo
        iconCreateGroup.setOnClickListener(v -> {
            Intent intent = new Intent(context, CrearGrupoActivity.class);
            context.startActivity(intent);
        });

        // Configurar el icono de Mis Grupos
        iconMisGrupos.setOnClickListener(v -> {
            Intent intent = new Intent(context, MisGruposActivity.class);
            context.startActivity(intent);
        });
    }

    public void updateHeader(Context context) {
        String username = SessionManager.getInstance(context).getUsername();
        Log.d("Header", "Nombre recuperado de sesión: " + username);

        if (username != null && !username.isEmpty()) {
            tvUsername.setText(username);
            tvUsername.setVisibility(VISIBLE);
            iconLogout.setVisibility(VISIBLE);
            iconCreateGroup.setVisibility(VISIBLE);
            iconMisGrupos.setVisibility(VISIBLE);
            btnRegister.setVisibility(GONE); // Ocultar botón de registro
        } else {
            tvUsername.setVisibility(GONE);
            iconLogout.setVisibility(GONE);
            iconCreateGroup.setVisibility(GONE);
            iconMisGrupos.setVisibility(GONE);
            btnRegister.setVisibility(VISIBLE); // Mostrar botón de registro
        }
    }
}
