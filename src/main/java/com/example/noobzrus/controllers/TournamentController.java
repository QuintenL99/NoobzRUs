package com.example.noobzrus.controllers;


import com.example.noobzrus.models.Tournaments;
import com.example.noobzrus.repositories.TournamentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class TournamentController {

    @Autowired
    private TournamentsRepository repository;

    @GetMapping("/tournaments")
    public String tournaments(Model model) {
        Iterable<Tournaments> tournaments = repository.findAll();
        model.addAttribute("tournaments", tournaments);
        return "tournaments";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("tournament", new Tournaments());
        return "create";
    }
    @PostMapping("/create")
    public String createTournament(@ModelAttribute("tournament") Tournaments tournament) {
        repository.save(tournament);
        return "redirect:/tournaments";
    }

    @GetMapping({"/tournamentdetails/{id}", "/tournamentdetails"})
    public String tournamentdetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "tournamentdetails";

        Optional<Tournaments> tournDB = repository.findById(id);

        model.addAttribute("tournament", tournDB.get());

        return "tournamentdetails";
    }
}