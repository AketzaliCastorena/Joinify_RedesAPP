package com.example.joinify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MisGruposActivity extends AppCompatActivity {

    private LinearLayout gruposContainer;
    private int userId;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grupo_card_template); // Note: Changed from grupo_card_template

        // Inicializar ApiService
        apiService = ApiClient.getClient().create(ApiService.class);

        //gruposContainer = findViewById(R.id.gruposContainer); // Uncomment and ensure correct ID

        // Obtener el UserID desde SessionManager
        userId = SessionManager.getInstance(this).getUserId();
        if (userId == -1) {
            Toast.makeText(this, "Error: No hay sesión de usuario activa", Toast.LENGTH_SHORT).show();
            // Redirigir al login si no hay sesión
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
            return;
        }

        cargarGruposDelUsuario();
    }

    private void cargarGruposDelUsuario() {
        Call<List<Grupo>> call = apiService.getMisGrupos(userId);
        call.enqueue(new Callback<List<Grupo>>() {
            @Override
            public void onResponse(Call<List<Grupo>> call, Response<List<Grupo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Limpiar contenedor antes de agregar nuevos grupos
                    gruposContainer.removeAllViews();

                    if (response.body().isEmpty()) {
                        // Mostrar mensaje si no hay grupos

                    } else {
                        for (Grupo grupo : response.body()) {
                            agregarTarjetaGrupo(grupo);
                        }
                    }
                } else {
                    Toast.makeText(MisGruposActivity.this,
                            "Error al cargar grupos",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Grupo>> call, Throwable t) {
                Toast.makeText(MisGruposActivity.this,
                        "Error de conexión: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void agregarTarjetaGrupo(Grupo grupo) {
        // La implementación anterior se mantiene igual
        View cardView = getLayoutInflater().inflate(
                R.layout.grupo_card_template,
                gruposContainer,
                false
        );

        // Configurar los TextView con los datos del grupo
        ((TextView) cardView.findViewById(R.id.grupoNombreTextView))
                .setText(grupo.getName());

        ((TextView) cardView.findViewById(R.id.servicioTextView))
                .setText(grupo.getServiceType());

        ((TextView) cardView.findViewById(R.id.usuariosTextView))
                .setText(String.format("Usuarios: %d / %d",
                        grupo.getCurrentUsers(),
                        grupo.getMaxUsers()));

        ((TextView) cardView.findViewById(R.id.costoTextView))
                .setText(String.format("Costo por usuario: $%d", grupo.getCostPerUser()));

        ((TextView) cardView.findViewById(R.id.politicaPagoTextView))
                .setText("Política de pago: " + grupo.getPaymentPolicy());

        ((TextView) cardView.findViewById(R.id.limitePagoTextView))
                .setText("Límite de pago: " + grupo.getFechaLimite());





        // Agregar la tarjeta al contenedor
        gruposContainer.addView(cardView);
    }
}