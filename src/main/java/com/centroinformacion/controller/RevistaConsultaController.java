package com.centroinformacion.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Revista;
import com.centroinformacion.service.RevistaService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/consultaRevista")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class RevistaConsultaController {

	@Autowired
	private RevistaService revistaService;
	
	
	@GetMapping("/consultaRevistaPorParametros")
	@ResponseBody
	public ResponseEntity<?> consultaRevistaPorParametros(
			//Parámetros REQUERIDOS
			@RequestParam(name = "nombre" , required = true , defaultValue = "") String nombre,
			@RequestParam(name = "frecuencia" , required = true , defaultValue = "") String frecuencia,
			@RequestParam(name = "fecDesde" , required = true , defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecDesde,
			@RequestParam(name = "fecHasta" , required = true , defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecHasta,
			@RequestParam(name = "estado" , required = true , defaultValue = "") int estado,
			//Parámetros NO REQUERIDOS
			@RequestParam(name = "idPais" , required = false , defaultValue = "-1") int idPais,
			@RequestParam(name = "idTipo" , required = false , defaultValue = "-1") int idTipo
			){
		List<Revista> lstSalida = revistaService.listaCompleja(
								"%"+nombre+"%", "%"+frecuencia+"%", fecDesde, fecHasta, estado, idPais, idTipo);
		
		return ResponseEntity.ok(lstSalida);
	}
	
}
