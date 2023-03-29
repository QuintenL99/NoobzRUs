package com.example.noobzrus.controllers;


import com.example.noobzrus.models.Tournaments;
import com.example.noobzrus.repositories.TournamentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
public class TournamentController {


    @Autowired
    private TournamentsRepository repository;

    @GetMapping("tournaments")
    public String tournaments(Model model) {
        Iterable<Tournaments> tournaments = repository.findAll();
        model.addAttribute("tournaments", tournaments);
        return "tournaments";
    }

    @GetMapping("admin/create")
    public String create(Model model) {
        model.addAttribute("tournament", new Tournaments());
        return "admin/create";
    }

    @PostMapping("/admin/create")
    public String createTournament(@ModelAttribute("tournament") Tournaments tournament) {
        repository.save(tournament);
        return "redirect:../tournaments";
    }

    @GetMapping({"/tournamentdetails/{id}", "/tournamentdetails"})
    public String tournamentdetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "tournamentdetails";
        Optional<Tournaments> tournDB = repository.findById(id);
        if (tournDB.isEmpty()) {
            return "tournamentdetails";
        }

        Tournaments tournament = tournDB.get();
        model.addAttribute("tournament", tournament);
        model.addAttribute("names", tournament.getDeelnemers());

        return "tournamentdetails";
    }

    @PostMapping("/tournamentdetails/addName")
    public String addName(@RequestParam Integer id, @RequestParam String name, Model model) {
        Optional<Tournaments> tournDB = repository.findById(id);
        if (!tournDB.isPresent()) {
            throw new RuntimeException("Tournament not found!");
        }
        Tournaments tournament = tournDB.get();
        if (tournament.getDeelnemers().size() >= tournament.getAantalSpelers()) {
            model.addAttribute("errorMessage", "Maximum number of players has been reached!");
            model.addAttribute("tournament", tournament);
            model.addAttribute("names", tournament.getDeelnemers());
            return "tournamentdetails";
        }
        tournament.getDeelnemers().add(name);
        repository.save(tournament);
        return "redirect:/tournamentdetails/" + id;
    }


}