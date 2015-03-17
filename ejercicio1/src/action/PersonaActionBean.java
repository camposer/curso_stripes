package action;

import java.util.List;

import model.Persona;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.EmailTypeConverter;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;
import service.PersonaService;
import service.PersonaServiceFactory;

public class PersonaActionBean implements ActionBean {
	private static final String VIEW = "/WEB-INF/jsp/persona.jsp";
	private ActionBeanContext ctx;
	private PersonaService personaService;

	@ValidateNestedProperties({
		@Validate(field = "nombre", required = true, 
				on = { "agregar", "modificar" } /*, mask = "[a-zA-Z ]*"*/),
		@Validate(field = "apellido", required = true, minlength = 3, 
				on = { "agregar", "modificar" }),
		@Validate(field = "correoElectronico", required = true, 
				on = { "agregar", "modificar" }, converter = EmailTypeConverter.class)
	})
	private Persona persona;
	
	private Integer personaId;
	
	@ValidationMethod(on = { "agregar", "modificar" })
	public void validarNombre(ValidationErrors errors) {
		String nombre = getPersona().getNombre();
		
		if (nombre.matches("[0-9]*")) {
			errors.add("nombre", new SimpleError("Nombre inválido"));
		}
	}
	
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
	
	public Resolution guardar() {
		if (getPersona().getId() != null)
			personaService.modificarPersona(getPersona());
		else
			personaService.agregarPersona(getPersona());
		
		return new RedirectResolution("/Persona.action");
	}

	public Resolution agregar() {
		personaService.agregarPersona(getPersona());
		return new RedirectResolution("/Persona.action");
	}
	
	public Resolution modificar() {
		personaService.modificarPersona(getPersona());
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
