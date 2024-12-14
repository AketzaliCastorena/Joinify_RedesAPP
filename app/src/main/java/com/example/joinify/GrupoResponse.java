package com.example.joinify;

public class GrupoResponse {
    private int id;
    private String name;
    private String serviceType;
    private int maxUsers;
    private int currentUsers;
    private double costPerUser;
    private String paymentPolicy;
    private String fechaCreacion;
    private String fechaLimite;
    private String createdAt;
    private String joinedAt;

    // Getters y setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getServiceType() { return serviceType; }
    public int getMaxUsers() { return maxUsers; }
    public int getCurrentUsers() { return currentUsers; }
    public double getCostPerUser() { return costPerUser; }
    public String getPaymentPolicy() { return paymentPolicy; }
    public String getFechaCreacion() { return fechaCreacion; }
    public String getFechaLimite() { return fechaLimite; }
    public String getCreatedAt() { return createdAt; }
    public String getJoinedAt() { return joinedAt; }
}
