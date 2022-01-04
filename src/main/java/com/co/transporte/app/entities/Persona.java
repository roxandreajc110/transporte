package com.co.transporte.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.co.transporte.app.util.Constant;
import com.co.transporte.app.util.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "PERSONA")
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona", nullable = false)
	@ApiModelProperty(value = "Identificador para cada persona", name = "idPersona", dataType = "Integer", example = "1")
    @JsonProperty("id")
	private Integer idPersona;
	
	@Column(name = "tipo_identificacion", nullable = false)
	@ApiModelProperty(value = "Tipo de identificador de la persona", name = "tipoIdentificacion", dataType = "String", example = "CC")
	@NotNull(message = "Tipo de identificación " + Constant.MENSAJE_VALIDAR_NULL)
	@JsonView(View.EmpresaTransportadora.class)
	private String tipoIdentificacion;
	
	@Column(name = "identificacion", nullable = false)
	@ApiModelProperty(value = "Número de dentificación de la persona", name = "identificacion", dataType = "String", example = "1018567896")
	@NotNull(message = "Identificacion" + Constant.MENSAJE_VALIDAR_NULL)
	@JsonView(View.EmpresaTransportadora.class)
	private String identificacion;
	
	@Column(name = "nombre", nullable = false)
	@ApiModelProperty(value = "Nombre completo de la persona", name = "nombre", dataType = "String", example = "Ana")
	@NotNull(message = "Nombre" + Constant.MENSAJE_VALIDAR_NULL)
	@JsonView(View.EmpresaTransportadora.class)
	private String nombre;
	
	@Column(name = "direccion")
	@ApiModelProperty(value = "Dirección de residencia la persona", name = "direccion", dataType = "String", example = "Kr 110")
	@JsonView(View.EmpresaTransportadora.class)
	private String direccion;
	
	@Column(name = "telefono")
	@ApiModelProperty(value = "Telefono de la persona", name = "telefono", dataType = "String", example = "4312345")
	@JsonView(View.EmpresaTransportadora.class)
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name = "representante_legal_id")
	@ApiModelProperty(value = "Id del representante legal", name = "representanteLegal")
	@JsonView(View.EmpresaTransportadora.class)
	private Persona representanteLegal;
	
	@ManyToOne
	@JoinColumn(name = "empresa_contratista_id")
	@ApiModelProperty(value = "Id de la empresa contratista de la persona", name = "empresaContratista")
	@JsonView(View.EmpresaTransportadora.class)
	private Persona empresaContratista;
	



	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
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



	public Persona getRepresentanteLegal() {
		return representanteLegal;
	}

	public void setRepresentanteLegal(Persona representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public Persona getEmpresaContratista() {
		return empresaContratista;
	}

	public void setEmpresaContratista(Persona empresaContratista) {
		this.empresaContratista = empresaContratista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
