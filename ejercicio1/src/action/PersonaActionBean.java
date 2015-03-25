package action;

import java.util.List;

import model.Persona;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.ajax.JavaScriptResolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.EmailTypeConverter;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;
import net.sourceforge.stripes.validation.ValidationState;
import service.PersonaService;

public class PersonaActionBean implements ActionBean, ValidationErrorHandler {
	private static final String VIEW = "/WEB-INF/jsp/persona.jsp";
	private ActionBeanContext ctx;
	@SpringBean
	private PersonaService personaService;

	@ValidateNestedProperties({
		@Validate(field = "nombre", required = true, 
				on = { "agregar", "modificar" } /*, expression = "!this.matches('.*[0-9]+.*')" */),
		@Validate(field = "apellido", required = true, minlength = 3, 
				on = { "agregar", "modificar" }),
		@Validate(field = "correoElectronico", required = true, 
				on = { "agregar", "modificar" }, converter = EmailTypeConverter.class)
	})
	private Persona persona;
	
	@Validate(field = "personaId", required = true, on = { "mostrar", "eliminar" })
	private Integer personaId;

	@ValidationMethod(on = { "agregar", "modificar"}, when = ValidationState.ALWAYS)
	public void validarNombre(ValidationErrors errors) {
		if (getPersona() != null) {
			String nombre = getPersona().getNombre();
			if (nombre.matches(".*[0-9]+.*")) {
				errors.add("nombre", new SimpleError("{0} no puede contener números"));
			}
		}
	}
	
	@DefaultHandler
	public Resolution inicio() {
		return new ForwardResolution(VIEW);
	}

	public Resolution listar() {
		return new JavaScriptResolution(getPersonas());
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

	public List<Persona> getPersonas() {
		return personaService.obtenerPersonas();
	}
	
	@Override
	public ActionBeanContext getContext() {
		return ctx;
	}

	@Override
	public void setContext(ActionBeanContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public Resolution handleValidationErrors(ValidationErrors errors)
			throws Exception {
		// TODO Se puede cambiar este comportamiento
		return new ForwardResolution(VIEW);
	}

}
