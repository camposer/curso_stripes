package model;

import java.util.Date;

public class Persona {
	private Integer id;
	private String nombre;
	private String apellido;
	private CorreoElectronico correoElectronico; 
	private Date fechaNacimiento;
	
	public Persona() {
	}
	
	public Persona(String nombre, String apellido, CorreoElectronico correoElectronico) {
		this(nombre, apellido, correoElectronico, null);
	}
	
	public Persona(String nombre, String apellido, CorreoElectronico correoElectronico, Date fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoElectronico = correoElectronico;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public CorreoElectronico getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(CorreoElectronico correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
}
