package dao;

public abstract class PersonaDaoFactory {
	private static PersonaDao INSTANCE = new PersonaDaoImpl();
	
	public static PersonaDao createPersonaDao() {
		return INSTANCE;
	}
}
