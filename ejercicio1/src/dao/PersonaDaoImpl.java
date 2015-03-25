package dao;

import model.Persona;

import org.springframework.stereotype.Component;

@Component
public class PersonaDaoImpl
		extends GenericDaoImpl<Persona, Integer>
		implements PersonaDao {

}
