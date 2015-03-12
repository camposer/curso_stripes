package service;

import java.util.List;

import model.Persona;
import dao.PersonaDao;
import dao.PersonaDaoFactory;

class PersonaServiceImpl implements PersonaService {
	private PersonaDao personaDao;
	
	public PersonaServiceImpl() {
		personaDao = PersonaDaoFactory.createPersonaDao();
	}

	@Override
	public void agregarPersona(Persona p) {
		personaDao.agregar(p);
	}

	@Override
	public void modificarPersona(Persona p) {
		personaDao.modificar(p);
	}

	@Override
	public void eliminarPersona(Integer id) {
		personaDao.eliminar(id);
	}

	@Override
	public Persona obtenerPersona(Integer id) {
		return personaDao.obtener(id);
	}

	@Override
	public List<Persona> obtenerPersonas() {
		return personaDao.obtenerTodos();
	}
	
}
