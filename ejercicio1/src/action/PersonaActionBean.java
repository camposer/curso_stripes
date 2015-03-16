package action;

import java.util.List;

import model.Persona;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import service.PersonaService;
import service.PersonaServiceFactory;

public class PersonaActionBean implements ActionBean {
	private static final String VIEW = "/WEB-INF/jsp/persona.jsp";
	private ActionBeanContext ctx;
	private PersonaService personaService;
	private Persona persona;
	private Integer personaId;
	
	public Integer getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public PersonaActionBean() {
		personaService = PersonaServiceFactory.createPersonaService();
	}
	
	public List<Persona> getPersonas() {
		return personaService.obtenerPersonas();
	}
	
	@DefaultHandler
	public Resolution inicio() {
		return new ForwardResolution(VIEW);
	}
	
	public Resolution agregar() {
		personaService.agregarPersona(getPersona());
		return new RedirectResolution("/Persona.action");
	}
	
	public Resolution eliminar() {
		String spersonaId = ctx.getRequest().getParameter("personaId");
		personaService.eliminarPersona(Integer.parseInt(spersonaId));
		return new RedirectResolution("/Persona.action");
	}
	
	public Resolution mostrar() {
		setPersona(personaService.obtenerPersona(getPersonaId())); // Ver atributos flash!
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
