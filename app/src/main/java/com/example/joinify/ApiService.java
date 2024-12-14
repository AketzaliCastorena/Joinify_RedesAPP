package com.example.joinify;

import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("/usuario")
    Call<Void> registrarUsuario(@Body Usuario usuario);

    // Endpoint para iniciar sesión
    @POST("/login")
    Call<Loginresponse> login(@Body LoginRequest loginRequest);

    // Endpoint para crear un grupo
    @POST("/api/grupos/crear")
    Call<Void> crearGrupo(@Body GrupoRequest grupoRequest);

  

}

