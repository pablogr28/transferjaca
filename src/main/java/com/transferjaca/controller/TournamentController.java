package com.transferjaca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.transferjaca.model.Match;
import com.transferjaca.model.PlayerTournament;
import com.transferjaca.model.Tournament;
import com.transferjaca.service.PlayerTournamentService;
import com.transferjaca.service.TournamentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;
    
    @Autowired
    private PlayerTournamentService playerTournamentService;

    // Listar torneos
    @GetMapping
    public String listTournaments(Model model) {
        model.addAttribute("tournaments", tournamentService.findAll());
        return "tournament/listTournament";
    }

    // Ver detalle de un torneo
    @GetMapping("/{id}")
    public String viewTournament(@PathVariable Long id, Model model) {
        Tournament tournament = tournamentService.findById(id);
        model.addAttribute("tournament", tournament);

        // Obtener los jugadores participantes de este torneo
        List<PlayerTournament> playerTournaments = tournament.getPlayerTournament();
        model.addAttribute("playerTournaments", playerTournaments);
        
        //Obtener los partidos que se han jugado en el torneo 
        List<Match> matches=tournament.getMatches();
        model.addAttribute("matches", matches);
        

        return "tournament/detailTournament";
    }

    // Mostrar formulario para crear
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("tournament", new Tournament());
        return "tournament/formTournament";
    }

    // Guardar nuevo jugador o actualizar existente
    @PostMapping
    public String saveOrUpdateTournament(@Valid @ModelAttribute Tournament tournament, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "tournament/formTournament";
        }
        tournamentService.save(tournament);
        return "redirect:/tournaments";
    }

    // Mostrar formulario de edición
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("tournament", tournamentService.findById(id));
        return "tournament/formTournament";
    }

    // Eliminar torneo
    @GetMapping("/delete/{id}")
    public String deleteTournament(@PathVariable Long id) {
    	tournamentService.deleteById(id);
        return "redirect:/tournaments";
    }
}
