
package com.app.Backend;

import java.util.List;

public interface PersonaService {
    
    public List<Persona> getPersonas();
    public void save(Persona p);
    public Persona getPersona(Integer id);
    public void delete(Integer id);
    
}
