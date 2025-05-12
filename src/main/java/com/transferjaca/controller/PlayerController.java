package com.transferjaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.transferjaca.model.Player;
import com.transferjaca.service.PlayerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // Listar jugadores
    @GetMapping
    public String listPlayers(Model model) {
        model.addAttribute("players", playerService.findAll());
        return "player/listPlayer";
    }

    // Ver detalle de un jugador
    @GetMapping("/{id}")
    public String viewPlayer(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.findById(id));
        return "player/detailPlayer";
    }

    // Mostrar formulario para crear
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("player", new Player());
        return "player/formPlayer";
    }

    // Guardar nuevo jugador o actualizar existente
    @PostMapping
    public String saveOrUpdatePlayer(@Valid @ModelAttribute Player player, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "player/formPlayer";
        }
        playerService.save(player);
        return "redirect:/players";
    }

    // Mostrar formulario de edición
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.findById(id));
        return "player/formPlayer";
    }

    // Eliminar jugador
    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deleteById(id);
        return "redirect:/players";
    }
}
