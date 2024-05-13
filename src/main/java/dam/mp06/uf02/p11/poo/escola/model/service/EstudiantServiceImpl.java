package dam.mp06.uf02.p11.poo.escola.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.mp06.uf02.p11.poo.escola.model.domain.Estudiant;
import dam.mp06.uf02.p11.poo.escola.model.repository.EstudiantRepository;

@Service
public class EstudiantServiceImpl implements IEstudiantService {

	@Autowired
	EstudiantRepository estudiantRepository;

	@Override
	public Estudiant add(Estudiant estudiant) {
		return estudiantRepository.save(estudiant);
	}

	@Override
	public Estudiant update(Estudiant estudiant) {
		return estudiantRepository.save(estudiant);
	}

	@Override
	public void delete(int id) {
		estudiantRepository.deleteById(id);

	}

	@Override
	public Estudiant findById(int id) {
		// return estudiantRepository.getById(id);

		Estudiant estudiant = null;

		Optional<Estudiant> estudiantOptional = estudiantRepository.findById(id);
		if (estudiantOptional.isPresent()) {
			estudiant = estudiantOptional.get();
		}

		return estudiant;
	}

	@Override
	public List<Estudiant> getAll() {
		return estudiantRepository.findAll();
	}

}
