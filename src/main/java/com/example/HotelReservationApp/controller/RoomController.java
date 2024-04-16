package com.example.HotelReservationApp.controller;

import com.example.HotelReservationApp.entity.Quarto;
import com.example.HotelReservationApp.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/quartos")
public class RoomController {

    @Autowired
    private QuartoService quartoService;


    @GetMapping
    public String getAllQuartos(Model model) {
        model.addAttribute("quartos", quartoService.getAllQuartos());
        return "lista-quartos";
    }
    @GetMapping("/{id}")
    public String getQuarto(@PathVariable Long id, Model model) {
        model.addAttribute("quarto", quartoService.getQuarto(id));
        return "quarto";
    }

}
