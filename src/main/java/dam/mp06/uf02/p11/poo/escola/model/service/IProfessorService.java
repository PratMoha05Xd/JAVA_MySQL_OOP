package dam.mp06.uf02.p11.poo.escola.model.service;

import java.util.List;

import dam.mp06.uf02.p11.poo.escola.model.domain.Professor;


public interface IProfessorService {
	
	Professor add(Professor professor);
	Professor update(Professor professor);
	void delete(int id);
	Professor findById(int id);
	List<Professor> getAll();

}
