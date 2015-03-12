package action;

import java.util.List;

import model.Persona;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import service.PersonaService;
import service.PersonaServiceFactory;

public class PersonaActionBean implements ActionBean {
	private static final String VIEW = "/WEB-INF/jsp/persona.jsp";
	private ActionBeanContext ctx;
	private PersonaService personaService;
	
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
	
	@Override
	public ActionBeanContext getContext() {
		return ctx;
	}

	@Override
	public void setContext(ActionBeanContext ctx) {
		this.ctx = ctx;
	}

}
