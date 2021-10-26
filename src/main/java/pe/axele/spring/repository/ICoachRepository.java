package pe.axele.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.axele.spring.model.Coach;

@Repository
public interface ICoachRepository extends JpaRepository<Coach, Integer>{
	@Query("from Coach c where p.nameCoach like %:nameCoach%")
	List<Coach> buscarNombre(@Param("nameCoach") String nameCoach);
}