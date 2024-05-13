package dam.mp06.uf02.p11.poo.escola.model.service;

import java.util.List;

import dam.mp06.uf02.p11.poo.escola.model.domain.Administratiu;


public interface IAdministratiuService {

    Administratiu add(Administratiu administratiu);
    Administratiu update(Administratiu administratiu);
    void delete(int id);
    Administratiu findById(int id);
    List<Administratiu> getAll();

}
