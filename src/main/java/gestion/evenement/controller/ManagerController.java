package gestion.evenement.controller;


import gestion.evenement.model.Evenement;
import gestion.evenement.repository.EvenementRepository;
import gestion.evenement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import gestion.evenement.model.User;

import java.util.List;

@RestController
@RequestMapping("/admin")

public class ManagerController {
    @Autowired
    private UserRepository ur;

    @Autowired
    private EvenementRepository er;

    //Liste de tous les demandes
    @GetMapping("/users")
    public List<User> get(){
        return ur.findAll();
    }

    //Liste de tous les demandes
    @GetMapping("/demandes")
    public List<Evenement> getProfiles(){
        return er.findAll();
    }
    //accepter un accepter
    @GetMapping("/acceptDemande/{id}")
    public void accepter(@PathVariable Long id) {
        Evenement p = er.findById(id).get();
        p.setEtat("Accepter");
        er.save(p);
    }


    //refuser un demande
    @GetMapping("/rejectDemande/{id}")
    public void refuser(@PathVariable Long id) {
        Evenement p = er.findById(id).get();
        p.setEtat("Refuser");
        er.save(p);
    }

    @PostMapping("/addMotif/{id}")
    public void addmotif(@PathVariable Long id, @RequestBody Evenement ev) {
        Evenement p = er.findById(id).get();
        p.setMotif(ev.getMotif());
        er.save(p);
    }

    //supprimer un user
    @GetMapping ("/deleteUser/{id}")
    public void deleteU(@PathVariable Long id) {
        ur.deleteById(id);
    }






}
