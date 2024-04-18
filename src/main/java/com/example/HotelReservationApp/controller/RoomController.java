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
        return "quarto-lista";
    }

    @GetMapping("/{id}")
    public String getQuartoById(@PathVariable Long id, Model model) {
        Quarto quarto = quartoService.getQuartoById(id)
                .orElseThrow(() -> new IllegalStateException("Invalido id do Quarto: " + id));
        model.addAttribute("quarto", quarto);
        return "quarto-details";
    }

    @GetMapping("/numeroDoQuarto/{numeroDoQuarto}")
    public String getQuartoByNumeroDoQuarto(@PathVariable String numeroDoQuarto, Model model) {
        Quarto quarto = quartoService.getQuartoByNumeroDoQuarto(numeroDoQuarto)
                .orElseThrow(() -> new IllegalStateException("Invalido Numero do Quarto: " + numeroDoQuarto));
        model.addAttribute("quarto", quarto);
        return "quarto-details";
    }

    @PostMapping
    public String adicionarQuarto(Quarto quarto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "quarto-form";
        }
        quartoService.saveOrUpdateQuarto(quarto);
        redirectAttributes.addFlashAttribute("message", "Quarto adicionado com sucesso!");
        return "redirect:/quartos";
    }

    @GetMapping("/edit/{id}")
    public String editQuarto(@PathVariable Long id, Model model) {
        Quarto quarto = quartoService.getQuartoById(id)
                .orElseThrow(() -> new IllegalStateException("Invalido id do Quarto: " + id));
        model.addAttribute("quarto", quarto);
        return "quarto-form";
    }

    @PostMapping("/edit/{id}")
    public String updateQuarto(@PathVariable Long id, @RequestBody Quarto quarto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "quarto-form";
        }
        quarto.setId(id);
        quartoService.saveOrUpdateQuarto(quarto);
        redirectAttributes.addFlashAttribute("message", "Quarto atualizado com sucesso!");
        return "redirect:/quartos";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuarto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        quartoService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Quarto deletado com sucesso!");
        return "redirect:/quartos";
    }
}