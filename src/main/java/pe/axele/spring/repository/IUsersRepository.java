package pe.axele.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.axele.spring.model.Users;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {
	public Users findByUsername(String username);
}
