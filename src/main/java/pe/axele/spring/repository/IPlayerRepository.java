package pe.axele.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.axele.spring.model.Player;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Integer>{
	@Query("select count(p.namePlayer) from Player p where p.namePlayer =:namePlayer")
	public int buscarNombrePlayer(@Param("namePlayer") String namePlayer);
	
	
	@Query("from Player p where p.namePlayer like %:namePlayer%")
	List<Player> buscarNombre(@Param("namePlayer") String namePlayer);
}