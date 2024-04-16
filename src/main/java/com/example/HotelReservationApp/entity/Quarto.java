package com.example.HotelReservationApp.entity;

import jakarta.persistence.*;

@Entity
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quarto;
    private double precoPorNoite;
    private boolean estaDisponivel;
    private int capacidade;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    public Quarto(){

    }
    public Quarto(int quarto, double precoPorNoite, boolean estaDisponivel, int capacidade) {
        this.quarto = quarto;
        this.precoPorNoite = precoPorNoite;
        this.estaDisponivel = estaDisponivel;
        this.capacidade = capacidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public void setPrecoPorNoite(double precoPorNoite) {
        this.precoPorNoite = precoPorNoite;
    }

    public boolean isEstaDisponivel() {
        return estaDisponivel;
    }

    public void setEstaDisponivel(boolean estaDisponivel) {
        this.estaDisponivel = estaDisponivel;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
