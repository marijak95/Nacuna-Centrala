package upp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upp.backend.enumeracije.OBLAST;
import upp.backend.model.NaucnaOblast;

@Repository
public interface NaucnaOblastRepository extends JpaRepository<NaucnaOblast, Long> {
	NaucnaOblast findByNazivOblasti (OBLAST NazivOblasti);
}
