package com.centroinformacion.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.centroinformacion.entity.Revista;

public interface RevistaRepository extends JpaRepository<Revista, Integer>{
	

	@Query("select e from Revista e where e.nombre like ?1 ")
	public abstract List<Revista> listaPorNombreLike(String nombre);
	
	@Query("select e from Revista e where e.nombre = ?1 ")
	public abstract List<Revista> listaPorNombreIgualRegistra(String nombre);
	
	@Query("select e from Revista e where e.nombre = ?1 and e.idRevista != ?2 ")
	public abstract List<Revista> listaPorNombreIgualActualiza(String nombre, int idRevista);
	
	//_______________________ SESIÓN 8 _______________________	
	@Query("select e from Revista e where "
			+ " e.nombre like ?1 and "
			+ " e.frecuencia like ?2 and "
			+ " e.fechaCreacion >=  ?3 and "
			+ " e.fechaCreacion <=  ?4 and "
			+ " e.estado = ?5 and "
			+ " (?6 = -1 or e.pais.idPais = ?6) and "
			+ " (?7 = -1 or e.tipoRevista.idDataCatalogo = ?7) ")
	public abstract List<Revista> listaCompleja(String nombre, String frecuencia, 
												Date fecIni, Date fecFin, 
												int estado,	int idPais, 
												int idTipo);
	
}
