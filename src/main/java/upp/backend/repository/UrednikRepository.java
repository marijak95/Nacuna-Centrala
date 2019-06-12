package upp.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upp.backend.model.Urednik;

@Repository
public interface UrednikRepository extends JpaRepository<Urednik, Long>
{
	Urednik findByEmail (String Email);
	
	Optional<Urednik> findByEmailAndPassword (String Email, String Password);
	
	Urednik findByGrad (String Grad);
}
