package com.centroinformacion.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.centroinformacion.util.FunctionUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "revista")
public class Revista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRevista;
	private String nombre;
	private String frecuencia;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Lima")
	private Date fechaCreacion;

	private String telefono;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaActualizacion;

	private int estado;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoRevista")
	private DataCatalogo tipoRevista;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPais")
	private Pais pais;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuarioRegistro")
	private Usuario usuarioRegistro;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuarioActualiza")
	private Usuario usuarioActualiza;
	
	
		// Para el reportes - convierte los datos a cadena de texto String
		public String getReporteEstado() {
			return estado == 1 ? "Activo" : "Inactivo";
		}
		public String getReportePais() {
			return pais.getIdPais()+"-"+pais.getNombre();
		}
		public String getReporteTipoRevista() {
			return tipoRevista.getIdDataCatalogo()+"-"+tipoRevista.getDescripcion();
		}
		public String getReporteFechaCreacion() {
			return FunctionUtil.getFechaString(fechaCreacion);
		}

}
