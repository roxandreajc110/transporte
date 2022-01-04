package com.co.transporte.app.domains;

import io.swagger.annotations.ApiModelProperty;

public class PersonaDTO  {

	@ApiModelProperty(value = "Identificador para cada persona", name = "id", dataType = "Integer", example = "1")
	private Integer id;
	
	@ApiModelProperty(value = "Tipo de identificador de la persona", name = "tipoIdentificacion", dataType = "String", example = "CC")
	private String tipoIdentificacion;
	
	@ApiModelProperty(value = "Número de dentificación de la persona", name = "identificacion", dataType = "String", example = "1018567896")
	private String identificacion;
	
	@ApiModelProperty(value = "Nombre completo de la persona", name = "nombre", dataType = "String", example = "Ana")
	private String nombre;
	
	@ApiModelProperty(value = "Dirección de residencia la persona", name = "direccion", dataType = "String", example = "Kr 110")
	private String direccion;
	
	@ApiModelProperty(value = "Telefono de la persona", name = "telefono", dataType = "String", example = "4312345")
	private String telefono;
	
	@ApiModelProperty(value = "Id del representante legal", name = "representanteLegal", dataType = "Integer", example = "2")
	private PersonaDTO representanteLegal;
	
	@ApiModelProperty(value = "Id de la empresa contratista de la persona", name = "empresaContratista", dataType = "Integer", example = "3")
	private PersonaDTO empresaContratista;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public PersonaDTO getRepresentanteLegal() {
		return representanteLegal;
	}

	public void setRepresentanteLegal(PersonaDTO representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public PersonaDTO getEmpresaContratista() {
		return empresaContratista;
	}

	public void setEmpresaContratista(PersonaDTO empresaContratista) {
		this.empresaContratista = empresaContratista;
	}

}
