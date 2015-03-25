package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import model.CorreoElectronico;
import model.Persona;

import org.springframework.stereotype.Repository;

@Repository
public class PersonaDaoImpl implements PersonaDao {
	private static final String PATRON = "yyyy-MM-dd";
	private List<Persona> personas;
	private int contador = 1;

	@PostConstruct // Ocurre después de la inyección de la dependencia!
	public void init() {
		personas = new ArrayList<Persona>();
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(PATRON);
			agregar(new Persona("Juan", "Pérez", new CorreoElectronico("j", "perez.com"), sdf.parse("1990-02-01")));
			agregar(new Persona("María", "García", new CorreoElectronico("m", "garcia.com"), sdf.parse("1980-01-01")));
			agregar(new Persona("Pedro", "González", new CorreoElectronico("p", "gonzalez.com")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void agregar(Persona p) {
		p.setId(contador++);
		personas.add(p);
	}

	private int buscarPos(Integer id) {
		for (int i = 0; i < personas.size(); i++) 
			if (personas.get(i).getId().equals(id))
				return i;
		return -1;
	}
	
	@Override
	public void modificar(Persona p) {
		int pos = buscarPos(p.getId());
		if (pos >= 0)
			personas.set(pos, p);
	}

	@Override
	public void eliminar(Integer id) {
		int pos = buscarPos(id);
		if (pos >= 0)
			personas.remove(pos);
	}

	@Override
	public Persona obtener(Integer id) {
		int pos = buscarPos(id);
		if (pos >= 0)
			return personas.get(pos);
		else 
			return null;
	}

	@Override
	public List<Persona> obtenerTodos() {
		return personas;
	}

}
