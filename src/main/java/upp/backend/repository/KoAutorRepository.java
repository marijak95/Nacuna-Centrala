package upp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upp.backend.model.KoAutor;

@Repository
public interface KoAutorRepository extends JpaRepository<KoAutor, Long>{
	KoAutor findByEmail (String Email);

}
