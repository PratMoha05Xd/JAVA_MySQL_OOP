package dam.mp06.uf02.p11.poo.escola.model.repository;

import dam.mp06.uf02.p11.poo.escola.model.domain.Administratiu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratiuRepository extends JpaRepository<Administratiu, Integer>  {

}
