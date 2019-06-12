package upp.backend.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upp.backend.model.Recenzija;

@Repository
public interface RecenzijaRepository extends JpaRepository<Recenzija, Long>{
	List<Recenzija> findByRadId(Long RadId);
}
