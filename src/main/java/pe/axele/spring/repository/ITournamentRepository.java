package pe.axele.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.axele.spring.model.Tournament;

@Repository
public interface ITournamentRepository extends JpaRepository<Tournament, Integer>{
	@Query("from Tournament t where t.nameTournament like %:nameTournament%")
	List<Tournament> buscarNombre(@Param("nameTournament") String nameTournament);
}