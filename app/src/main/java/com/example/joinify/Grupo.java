package com.example.joinify;

public class Grupo {
    private int id;
    private String name;
    private String serviceType;
    private int maxUsers;
    private int currentUsers;
    private double costPerUser;
    private String paymentPolicy;
    private String fechaCreacion;
    private String fechaLimite;

    public String getName() { return name; }
    public String getServiceType() { return serviceType; }
    public int getMaxUsers() { return maxUsers; }
    public int getCurrentUsers() { return currentUsers; }
    public double getCostPerUser() { return costPerUser; }
    public String getPaymentPolicy() { return paymentPolicy; }
    public String getFechaLimite() { return fechaLimite; }
}
