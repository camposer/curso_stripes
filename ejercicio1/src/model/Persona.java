package model;

import java.util.Date;

public class Persona {
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	
	public Persona() {
	}
	
	public Persona(String nombre, String apellido) {
		this(nombre, apellido, null);
	}
	
	public Persona(String nombre, String apellido, Date fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
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
}
