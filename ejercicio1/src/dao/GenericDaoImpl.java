package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDaoImpl<E, K> implements GenericDao<E, K> {
	@PersistenceContext // Delega la gestión del entityManager en el contenedor
	private EntityManager entityManager;
	private Class<E> clase;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.clase = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void agregar(E entity) {
		entityManager.persist(entity);
	}

	@Override
	public void modificar(E entity) {
		entityManager.merge(entity);
	}

	@Override
	public void eliminar(K id) {
		E entity = obtener(id);
		entityManager.remove(entity);
	}

	@Override
	public E obtener(K id) {
		return entityManager.find(clase, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> obtenerTodos() {
		return entityManager.createQuery("from " + clase.getSimpleName() + " e").getResultList();
//		return entityManager.createNativeQuery("SELECT * FROM persona", Persona.class)
//				.getResultList();
	}


}
