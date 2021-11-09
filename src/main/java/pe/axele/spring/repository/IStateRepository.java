package pe.axele.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.axele.spring.model.State;

@Repository
public interface IStateRepository extends JpaRepository<State, Integer>{
}