package com.transferjaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.transferjaca.model.Match;
import com.transferjaca.service.MatchService;
import com.transferjaca.service.TeamService;
import com.transferjaca.service.TournamentService;

@Controller
@RequestMapping("/matches")
public class MatchController {
	
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private TournamentService tournamentService;
	
	//Listar partidos
	@GetMapping
	public String listMatchers(Model model) {
		model.addAttribute("matches", matchService.findAll());
		return "match/listMatch";
	}
	
	//Ver detalle de un partido
	@GetMapping("/{id}")
	public String viewMatch(@PathVariable Long id, Model model) {
		model.addAttribute("match", matchService.findById(id));
		return "match/detailMatch";
	}
	
	//Mostrar formulario para crear
	@GetMapping("/new")
	public String showCreateForm(Model model) {
		model.addAttribute("match", new Match());
		model.addAttribute("teams", teamService.findAll());
		model.addAttribute("tournaments", tournamentService.findAll());
		return "match/formMatch";
	}
	
	//Guardar nuevo partido o editar un partido existente
	@PostMapping
	public String saveOrUpdateMatch(@ModelAttribute Match match,Model model) {
		matchService.save(match);
		return "redirect:/matches";
	}
	
	//Mostrar formulario de edicion
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id,Model model) {
		model.addAttribute("match", matchService.findById(id));
		return "match/formMatch";
	}
	
	//Eliminar jugador
	@GetMapping("/delete/{id}")
	public String deleteMatch(@PathVariable Long id) {
		matchService.deleteById(id);
		return "redirect:/matches";
	}
	

}
