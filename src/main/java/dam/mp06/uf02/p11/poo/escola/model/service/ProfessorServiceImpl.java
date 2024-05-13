package dam.mp06.uf02.p11.poo.escola.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.mp06.uf02.p11.poo.escola.model.domain.Professor;
import dam.mp06.uf02.p11.poo.escola.model.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements IProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	@Override
	public Professor add(Professor professor) {
		return professorRepository.save(professor);
	}

	@Override
	public Professor update(Professor professor) {
		return professorRepository.save(professor);
	}

	@Override
	public void delete(int id) {
		professorRepository.deleteById(id);

	}

	@Override
	public Professor findById(int id) {
		// return ProfessorRepository.getById(id);

		Professor professor = null;

		Optional<Professor> professorOptional = professorRepository.findById(id);
		if (professorOptional.isPresent()) {
			professor = professorOptional.get();
		}

		return professor;
	}

	@Override
	public List<Professor> getAll() {
		return professorRepository.findAll();
	}

}
