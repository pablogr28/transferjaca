package com.transferjaca.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.transferjaca.model.Player;
import com.transferjaca.model.Transfer;
import com.transferjaca.service.PlayerService;
import com.transferjaca.service.TeamService;
import com.transferjaca.service.TransferService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/transfers")
public class TransferController {
	
	@Autowired
	private TransferService transferService;
	
	@Autowired
	private TeamService teamService;

	@Autowired
	private PlayerService playerService;
	
	//Listar traspasos
	@GetMapping
	public String listTransfers(Model model) {
		model.addAttribute("transfers", transferService.findAll());
		return "transfer/listTransfer";
	}
	
	// Ver detalle de un traspaso
    @GetMapping("/{id}")
    public String viewTransfer(@PathVariable Long id, Model model) {
        model.addAttribute("transfer", transferService.findById(id));
        return "transfer/detailTransfer";
    }
	
    @GetMapping("/new/{playerId}")
    public String showCreateForm(@PathVariable Long playerId, Model model) {
        Player player = playerService.findById(playerId);

        Transfer transfer = new Transfer();
        transfer.setPlayer(player);
        transfer.setFromTeam(player.getTeam()); 
        transfer.setDateTransfer(LocalDate.now());

        model.addAttribute("transfer", transfer);
        model.addAttribute("teams", teamService.findAll());

        return "transfer/formTransfer";
    }

    @PostMapping
    public String saveOrUpdateTransfer(@Valid @ModelAttribute Transfer transfer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("teams", teamService.findAll());
            return "transfer/formTransfer";
        }

        // Cargar Player completo por ID
        Player jugadorCompleto = playerService.findById(transfer.getPlayer().getId());

        // Actualizar equipo del jugador
        jugadorCompleto.setTeam(transfer.getToTeam());
        playerService.save(jugadorCompleto);

        // Asignar player cargado al transfer
        transfer.setPlayer(jugadorCompleto);
        
        //Asignar la fecha de creacion del traspaso
        transfer.setDateTransfer(LocalDate.now());

        // Guardar traspaso
        transferService.save(transfer);

        return "redirect:/transfers";
    }

}
