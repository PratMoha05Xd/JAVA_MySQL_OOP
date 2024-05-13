package dam.mp06.uf02.p11.poo.escola.model.service;

import java.util.List;

import dam.mp06.uf02.p11.poo.escola.model.domain.Estudiant;


public interface IEstudiantService {
	
	Estudiant add(Estudiant estudiant);
	Estudiant update(Estudiant estudiant);
	void delete(int id);
	Estudiant findById(int id);
	List<Estudiant> getAll();

}
