package upp.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upp.backend.model.Recenzent;

@Repository
public interface RecenzentRepository extends JpaRepository<Recenzent, Long> {
	Recenzent findByEmail (String Email);
	
	Optional<Recenzent> findByEmailAndPassword (String Email, String Password);
	
	Recenzent findByGrad (String Grad);

}
