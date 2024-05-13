package dam.mp06.uf02.p11.poo.escola.model.service;

import java.util.List;
import java.util.Optional;

import dam.mp06.uf02.p11.poo.escola.model.domain.Administratiu;
import dam.mp06.uf02.p11.poo.escola.model.repository.AdministratiuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratiuServiceImpl implements IAdministratiuService {

    @Autowired
    AdministratiuRepository administratiuRepository;

    @Override
    public Administratiu add(Administratiu administratiu) {
        return administratiuRepository.save(administratiu);
    }

    @Override
    public Administratiu update(Administratiu administratiu) {
        return administratiuRepository.save(administratiu);
    }

    @Override
    public void delete(int id) {
        administratiuRepository.deleteById(id);

    }

    @Override
    public Administratiu findById(int id) {
        // return administratiuRepository.getById(id);

        Administratiu administratiu = null;

        Optional<Administratiu> administratiuOptional = administratiuRepository.findById(id);
        if (administratiuOptional.isPresent()) {
            administratiu = administratiuOptional.get();
        }

        return administratiu;
    }

    @Override
    public List<Administratiu> getAll() {
        return administratiuRepository.findAll();
    }

}
