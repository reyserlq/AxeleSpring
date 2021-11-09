package pe.axele.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.axele.spring.model.Sell;

@Repository
public interface ISellRepository extends JpaRepository<Sell, Integer>{
	@Query("from Sell s where s.stateSell like %:stateSell%")
	List<Sell> buscarNombre(@Param("stateSell") String stateSell);
}