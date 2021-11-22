package pe.axele.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.axele.spring.model.Team;
@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer>{	
	@Query("from Team t where t.nameTeam like %:nameTeam%")
	List<Team> buscarNombre(@Param("nameTeam") String nameTeam);
}