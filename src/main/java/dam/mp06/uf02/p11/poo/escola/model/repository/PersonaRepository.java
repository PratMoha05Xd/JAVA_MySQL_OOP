package dam.mp06.uf02.p11.poo.escola.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import dam.mp06.uf02.p11.poo.escola.model.domain.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	
}
