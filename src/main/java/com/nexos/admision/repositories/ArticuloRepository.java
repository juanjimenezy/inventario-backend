package com.nexos.admision.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nexos.admision.models.Articulo;
import com.nexos.admision.models.Usuario;

@Repository
public interface ArticuloRepository extends CrudRepository<Articulo, Long> {
	
	@Query("SELECT a FROM Articulo a WHERE a.nombre = :nombre")
	List<Articulo> findArticulosByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT a FROM Articulo a WHERE a.nombre = :nombre")
	Articulo findArticuloByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT a.nombre FROM Articulo a WHERE a.nombre = :nombre")
	String findNomArticuloByNombre(@Param("nombre") String nombre);
	
	@Query("SELECT a FROM Articulo a WHERE a.nombre like :nombre AND a.usernameIng.username like :username")
	List<Articulo> findArticuloByNombreAndUsername(@Param("nombre") String nombre,@Param("username") String username);
	
	@Query("SELECT DISTINCT(a.usernameIng) FROM Articulo a")
	List<Usuario> findUsuarios();

}
