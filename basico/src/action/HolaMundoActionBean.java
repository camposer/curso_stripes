package action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

/**
 * Todos los métodos que devuelven Resolution son manejadores.
 * El que tiene la anotación @DefaultHandler es el por defecto
 */
public class HolaMundoActionBean implements ActionBean {
	private static final String VIEW = "/WEB-INF/jsp/holaMundo.jsp";
	private ActionBeanContext ctx;

	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Resolution cambiarNombre() {
		nombre = "Otro";
		return new ForwardResolution(VIEW); 
	}

	@DefaultHandler
	public Resolution inicio() {
		return new ForwardResolution(VIEW); 
	}
	
	@Override
	public ActionBeanContext getContext() {
		return ctx;
	}

	@Override
	public void setContext(ActionBeanContext ctx) {
		this.ctx = ctx;
	}
}
