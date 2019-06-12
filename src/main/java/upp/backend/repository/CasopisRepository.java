package upp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upp.backend.model.Casopis;

@Repository
public interface CasopisRepository extends JpaRepository<Casopis, Long>{
	Casopis findByNaziv(String Naziv);
	
	Casopis findByISSN(String ISSN);
}
