package upp.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upp.backend.model.Rad;

@Repository
public interface RadRepository extends JpaRepository<Rad, Long>{
	Rad findByNaslov(String Naslov); 
	
	List<Rad> findByAutorEmail (String Email);
	 
	 
}
