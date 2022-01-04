package com.co.transporte.app.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.co.transporte.app.util.Constant;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "VEHICULO")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehiculo", nullable = false)
	@ApiModelProperty(value = "Identificador para cada vehiculo", name = "id_vehiculo", dataType = "Integer", example = "1")
	private Integer id_vehiculo;
	
	@ManyToOne
	@JoinColumn(name = "persona_juridica_id")
	@ApiModelProperty(value = "Id de la persona juridica o empresa dueña del vehiculo", name = "empresa")
	private Persona empresa;
	
	@Column(name = "placa", nullable = false)
	@ApiModelProperty(value = "Placa del vehiculo", name = "placa", dataType = "String", example = "AAA222")
	@NotNull(message = "Placa " + Constant.MENSAJE_VALIDAR_NULL)
	private String placa;
	
	@Column(name = "motor", nullable = false)
	@ApiModelProperty(value = "Motor del vehiculo", name = "motor", dataType = "String", example = "DERF-56")
	@NotNull(message = "Motor " + Constant.MENSAJE_VALIDAR_NULL)
	private String motor;
	
	@Column(name = "chasis", nullable = true)
	@ApiModelProperty(value = "Chasis del vehiculo", name = "chasis", dataType = "String", example = "SDESR-SD")
	@NotNull(message = "Chasis " + Constant.MENSAJE_VALIDAR_NULL)
	private String chasis;
	
	@Column(name = "modelo", nullable = false)
	@ApiModelProperty(value = "Modelo del vehiculo", name = "modelo", dataType = "String", example = "2020")
	@NotNull(message = "Modelo " + Constant.MENSAJE_VALIDAR_NULL)
	private String modelo;
	
	@Column(name = "fecha_matricula", nullable = false)
	@ApiModelProperty(value = "Fecha de matricula del vehiculo", name = "fechaMatricula", dataType = "Date", example = "2020-07-12")
	@NotNull(message = "Fecha matricula " + Constant.MENSAJE_VALIDAR_NULL)
	private Date fechaMatricula;
	
	@Column(name = "pasajeros_sentados", nullable = false)
	@ApiModelProperty(value = "Pasajeros sentados permitidos en el vehiculo", name = "pasajerosSentados", dataType = "Integer", example = "20")
	@NotNull(message = "Pasajeros sentados " + Constant.MENSAJE_VALIDAR_NULL)
	private Integer pasajerosSentados;
	
	@Column(name = "pasajeros_de_pie", nullable = false)
	@ApiModelProperty(value = "Pasajeros de pie permitidos en el vehiculo", name = "pasajerosDePie", dataType = "Integer", example = "20")
	@NotNull(message = "Pasajeros de pie " + Constant.MENSAJE_VALIDAR_NULL)
	private Integer pasajerosDePie;
	
	@Column(name = "peso_seco", nullable = true)
	@ApiModelProperty(value = "Peso seco del vehiculo", name = "pesoSeco", dataType = "Decimal", example = "205.25")
	@NotNull(message = "Peso seco " + Constant.MENSAJE_VALIDAR_NULL)
	private BigDecimal pesoSeco;
	
	@Column(name = "peso_bruto", nullable = true)
	@ApiModelProperty(value = "Peso bruto del vehiculo", name = "pesoBruto", dataType = "Decimal", example = "205.25")
	@NotNull(message = "Peso bruto " + Constant.MENSAJE_VALIDAR_NULL)
	private BigDecimal pesoBruto;
	
	@Column(name = "cantidad_puertas", nullable = false)
	@ApiModelProperty(value = "Cantidad de puertas del vehiculo", name = "cantidadPuertas", dataType = "Integer", example = "2")
	@NotNull(message = "Cantidad de puertas " + Constant.MENSAJE_VALIDAR_NULL)
	private Integer cantidadPuertas;

	@Column(name = "marca", nullable = false)
	@ApiModelProperty(value = "Marca del vehiculo", name = "marca", dataType = "String", example = "Volvo")
	@NotNull(message = "Marca " + Constant.MENSAJE_VALIDAR_NULL)
	private String marca;
	
	@Column(name = "linea", nullable = true)
	@ApiModelProperty(value = "Línea del vehiculo", name = "linea", dataType = "String", example = "Volvo")
	@NotNull(message = "Línea " + Constant.MENSAJE_VALIDAR_NULL)
	private String linea;
	
	@ManyToMany
	@JoinTable(name = "vehiculos_conductores", joinColumns = @JoinColumn(name = "id_vehiculo"), inverseJoinColumns = @JoinColumn(name = "id_persona"))
	private List<Persona> listConductoresAsignados;

	public Integer getId_vehiculo() {
		return id_vehiculo;
	}

	public void setId_vehiculo(Integer id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}

	public List<Persona> getListConductoresAsignados() {
		return listConductoresAsignados;
	}

	public void setListConductoresAsignados(List<Persona> listConductoresAsignados) {
		this.listConductoresAsignados = listConductoresAsignados;
	}

	public Persona getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Persona empresa) {
		this.empresa = empresa;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(Date fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public Integer getPasajerosSentados() {
		return pasajerosSentados;
	}

	public void setPasajerosSentados(Integer pasajerosSentados) {
		this.pasajerosSentados = pasajerosSentados;
	}

	public Integer getPasajerosDePie() {
		return pasajerosDePie;
	}

	public void setPasajerosDePie(Integer pasajerosDePie) {
		this.pasajerosDePie = pasajerosDePie;
	}

	public BigDecimal getPesoSeco() {
		return pesoSeco;
	}

	public void setPesoSeco(BigDecimal pesoSeco) {
		this.pesoSeco = pesoSeco;
	}

	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public Integer getCantidadPuertas() {
		return cantidadPuertas;
	}

	public void setCantidadPuertas(Integer cantidadPuertas) {
		this.cantidadPuertas = cantidadPuertas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
