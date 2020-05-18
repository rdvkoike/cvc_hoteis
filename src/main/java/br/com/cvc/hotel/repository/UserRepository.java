package br.com.cvc.hotel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cvc.hotel.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	 @Query(value = "SELECT i FROM User i WHERE flagAtivo = 1")
	 List<User> findAllButActive();

	 Optional<User> findByUsername(String username);
	 
	 
}
