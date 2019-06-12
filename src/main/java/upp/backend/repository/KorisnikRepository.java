package upp.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upp.backend.model.Korisnik;


@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{
	Korisnik findByEmail (String Email);
	
	Optional<Korisnik> findByEmailAndPassword(String Email, String Password);
}
