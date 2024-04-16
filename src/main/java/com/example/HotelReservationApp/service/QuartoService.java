package com.example.HotelReservationApp.service;

import com.example.HotelReservationApp.dao.QuartoRepository;
import com.example.HotelReservationApp.entity.Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;


    public List<Quarto> getAllQuartos(){
        return quartoRepository.findAll();
    }

    public Optional<Quarto> getQuartoByNumeroDoQuarto(String numeroDoQuarto){
        return quartoRepository.getQuartoByNumeroDoQuarto(numeroDoQuarto);
    }
    public Optional<Quarto> getQuartoById(Long id){
        return quartoRepository.findById(id);
    }
    public void saveOrUpdateQuarto(Quarto quarto){
         quartoRepository.save(quarto);
    }


    public void delete(Long id){
        quartoRepository.deleteById(id);
    }
}
