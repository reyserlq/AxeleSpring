package pe.axele.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.axele.spring.model.Position;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Integer>{
}