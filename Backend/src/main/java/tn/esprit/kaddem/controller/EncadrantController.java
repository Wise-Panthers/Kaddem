package tn.esprit.kaddem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import tn.esprit.kaddem.entities.Encadrant;
import tn.esprit.kaddem.services.IEncadrantServices;

@RestController
@RequestMapping("/Encadrant")
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
public class EncadrantController {
    
    IEncadrantServices encadrantServices;

    @GetMapping("/getById/{idEncadrant}")
    public Encadrant getEncadrants(@PathVariable("idEncadrant") Integer idEncadrant) {
        return encadrantServices.getEncadrantById(idEncadrant);
    }

    @GetMapping("/getAll")
    public List<Encadrant> getEncadrantList() {
        return encadrantServices.getAllEncadrants();
    }

    @PostMapping("/add")
    public Encadrant addEncadrant(@RequestBody Encadrant en) {
        return encadrantServices.addEncadrant(en);
    }

    @PutMapping("/update")
    public Encadrant updateEncadrant(@RequestBody Encadrant en) {
        return encadrantServices.updateEncadrant(en);
    }

    @DeleteMapping("/delete/{idEncadrant}")
    public void deleteEncadrant(@PathVariable ("idEncadrant") Integer idEncadrant) {
        encadrantServices.deleteEncadrant(idEncadrant);
    }

    @GetMapping("/getByNiveau/{niveau}")
    public List<Encadrant> getEncadrantsByNiveauEquipe(@PathVariable String niveau){
        return encadrantServices.getEncadrantsByNiveauEquipe(niveau);
    }

    @PostMapping("/add/equipe/{idEquipe}")
    public void addAndAssignEncadrantToEquipe(
        @PathVariable Integer idEquipe, 
        @RequestBody Encadrant en){
            encadrantServices.addAndAssignEncadrantToEquipe(idEquipe, en);
    }

    @GetMapping("/getPrimeAnnuel")
    public Map<String, Double> calculPrimeAnnuelEncadrant(){
        return encadrantServices.calculPrimeAnnuelEncadrant();
    }
   
}
