package gestion.evenement.controller;


import gestion.evenement.model.Evenement;
import gestion.evenement.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import gestion.evenement.model.User;
import gestion.evenement.repository.UserRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/client")
public class DemandeurController {
    @Autowired
    private UserRepository ur;



    @Autowired
    private EvenementRepository er;


    @PostMapping("/requestevent")
    public Evenement addDemande(@RequestBody Evenement ev){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User u = ur.findUserByUsername(auth.getName());
        u.getEvenements().add(ev);
        return er.save(ev);

    }

//Liste de tous les mes Demandes
    @GetMapping("/mesdemandes")
    public List<Evenement> gettdemandes(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User u = ur.findUserByUsername(auth.getName());

        List<Evenement> demandes = u.getEvenements();
        return demandes;
    }


    //supprimer une demande
    @GetMapping ("/deletedemande/{id}")
    public void delete(@PathVariable Long id) {
        er.deleteev(id);
        er.deleteById(id);
    }




}
