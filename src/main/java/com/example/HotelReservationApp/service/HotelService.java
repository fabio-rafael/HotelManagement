package com.example.HotelReservationApp.service;

import com.example.HotelReservationApp.dao.HotelRepository;
import com.example.HotelReservationApp.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {


    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHoteis(){
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(Long id){
        return hotelRepository.findById(id);
    }

    public Optional<Hotel> getHotelByCidade(String cidade){
        return hotelRepository.getHotelByCidade(cidade);
    }
    public void saveOrUpdateHotel(Hotel hotel){
        hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id){
        hotelRepository.deleteById(id);
    }
}
