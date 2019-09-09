
package com.app.Backend;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImp implements PersonaService{

    @Autowired
    PersonaRepositorio repo;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> getPersonas() {
        return (List<Persona>) repo.findAll();
    }

    @Override
    @Transactional
    public void save(Persona p) {
        repo.save(p);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona getPersona(Integer id) {
       return repo.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
}
