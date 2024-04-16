package com.example.HotelReservationApp.dao;

import com.example.HotelReservationApp.entity.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    Optional<Quarto> getQuartoByNumeroDoQuarto(String numeroDoQuarto);
}
