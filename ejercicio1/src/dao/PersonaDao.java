package dao;

import java.util.List;

import model.Persona;

public interface PersonaDao {
	public void agregar(Persona p);
	public void modificar(Persona p);
	public void eliminar(Integer id);
	public Persona obtener(Integer id);
	public List<Persona> obtenerTodos();
}
