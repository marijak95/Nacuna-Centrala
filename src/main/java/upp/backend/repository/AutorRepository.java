package upp.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upp.backend.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
	Autor findByEmail (String Email);
	
	Optional<Autor> findByEmailAndPassword(String Email, String Password);
	
	Autor findByGrad (String Grad);
}
