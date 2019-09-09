
package com.app.Backend;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/app")
public class PersonaControlador {
    
    @Autowired
    PersonaService service;

    @GetMapping("/persona")
    public List<Persona> getPersonas() {
        return service.getPersonas();
    }
    
    @GetMapping("/persona/{personaId}")
    public Persona getPersona(@PathVariable int personaId) {
        Persona p = service.getPersona(personaId);
        return p;
    }
    
    @PostMapping("/persona")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona save(@RequestBody Persona p) {
        p.setId(0);
        service.save(p);
        return p;
    }
    
    @PutMapping("/persona")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona update(@RequestBody Persona p){
        service.save(p);
        return p;
    }  
    
    @DeleteMapping("/persona/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
    
}
