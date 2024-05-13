package dam.mp06.uf02.p11.poo.escola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dam.mp06.uf02.p11.poo.escola.model.domain.Professor;
import dam.mp06.uf02.p11.poo.escola.model.service.IProfessorService;


@RestController
//http://localhost:8080/escola/professors
@RequestMapping("/escola/professors")
public class ProfessorController {

	@Autowired
	IProfessorService professorService;

	// http://localhost:8080/escola/professors/add
	@PostMapping("/add")
	public ResponseEntity<?> addProfessor(@RequestBody Professor professor) {

		ResponseEntity<?> result = null;

		try {
			Professor professorDb = professorService.add(professor);
			result = ResponseEntity.status(HttpStatus.OK).body(professorDb);

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;

	}

	// http://localhost:8080/escola/professors/update
	@PutMapping("/update")
	public ResponseEntity<?> updateProfessor(@RequestBody Professor professor) {

		ResponseEntity<?> result = null;

		try {
			Professor professorDb = professorService.update(professor);

			result = ResponseEntity.status(HttpStatus.OK).body(professorDb);

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;

	}

	// http://localhost:8080/escola/professors/delete/id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProfessor(@PathVariable int id) {

		ResponseEntity<String> result = null;

		try {
			professorService.delete(id);

			result = ResponseEntity.status(HttpStatus.OK).body("Operació realitzada");

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;
	}

	// http://localhost:8080/escola/professors/getOne/23
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getProfessor(@PathVariable int id) {

		ResponseEntity<?> result = null;

		try {
			Professor professorDb = professorService.findById(id);

			if (professorDb != null) {
				result = ResponseEntity.status(HttpStatus.OK).body(professorDb);
			} else {
				result = ResponseEntity.status(HttpStatus.NOT_FOUND).body(professorDb);
			}

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;

	}

	// http://localhost:8080/escola/professors/getAll
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> result = null;

		try {
			List<Professor> professorDb = professorService.getAll();
			result = ResponseEntity.status(HttpStatus.OK).body(professorDb);

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;

	}

}
