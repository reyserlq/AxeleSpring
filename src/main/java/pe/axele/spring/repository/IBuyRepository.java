package pe.axele.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.axele.spring.model.Buy;

@Repository
public interface IBuyRepository extends JpaRepository<Buy, Integer>{
	@Query("from Buy b where b.player.namePlayer like %:namePlayer%")
	List<Buy> buscarJugador(@Param("namePlayer") String namePlayer);
}