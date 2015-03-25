package dao;

import java.util.List;

public interface GenericDao<E, K> {
	public void agregar(E entity);
	public void modificar(E entity);
	public void eliminar(K id);
	public E obtener(K id);
	public List<E> obtenerTodos();
}
