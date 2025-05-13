package com.transferjaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.transferjaca.model.Team;
import com.transferjaca.service.TeamService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
    private TeamService teamService;

    // Listar equipos
    @GetMapping
    public String listTeams(Model model) {
        model.addAttribute("team", teamService.findAll());
        return "team/listTeam";
    }

    // Ver detalle de un equipo
    @GetMapping("/{id}")
    public String viewTeam(@PathVariable Long id, Model model) {
        model.addAttribute("team", teamService.findById(id));
        return "team/detailTeam";
    }

    // Mostrar formulario para crear
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("team", new Team());
        return "team/formTeam";
    }

    // Guardar nuevo jugador o actualizar existente
    @PostMapping
    public String saveOrUpdateTeam(@Valid @ModelAttribute Team team, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "team/formTeam";
        }
        teamService.save(team);
        return "redirect:/teams";
    }

    // Mostrar formulario de edición
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("team", teamService.findById(id));
        return "team/formTeam";
    }

    // Eliminar jugador
    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable Long id) {
    	teamService.deleteById(id);
        return "redirect:/teams";
    }

}
