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

import dam.mp06.uf02.p11.poo.escola.model.domain.Estudiant;
import dam.mp06.uf02.p11.poo.escola.model.service.IEstudiantService;


@RestController
//http://localhost:8080/escola/estudiants
@RequestMapping("/escola/estudiants")
public class EstudiantController {

	@Autowired
	IEstudiantService estudiantService;

	// http://localhost:8080/escola/estudiants/add
	@PostMapping("/add")
	public ResponseEntity<?> addEstudiant(@RequestBody Estudiant estudiant) {

		ResponseEntity<?> result = null;

		try {
			Estudiant estudiantDb = estudiantService.add(estudiant);
			result = ResponseEntity.status(HttpStatus.OK).body(estudiantDb);

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;

	}

	// http://localhost:8080/escola/estudiants/update
	@PutMapping("/update")
	public ResponseEntity<?> updateEstudiant(@RequestBody Estudiant estudiant) {

		ResponseEntity<?> result = null;

		try {
			Estudiant estudiantDb = estudiantService.update(estudiant);

			result = ResponseEntity.status(HttpStatus.OK).body(estudiantDb);

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;

	}

	// http://localhost:8080/escola/estudiants/delete/id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEstudiant(@PathVariable int id) {

		ResponseEntity<String> result = null;

		try {
			estudiantService.delete(id);

			result = ResponseEntity.status(HttpStatus.OK).body("Operació realitzada");

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;
	}

	// http://localhost:8080/escola/estudiants/getOne/23
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getEstudiant(@PathVariable int id) {

		ResponseEntity<?> result = null;

		try {
			Estudiant estudiantDb = estudiantService.findById(id);

			if (estudiantDb != null) {
				result = ResponseEntity.status(HttpStatus.OK).body(estudiantDb);
			} else {
				result = ResponseEntity.status(HttpStatus.NOT_FOUND).body(estudiantDb);
			}

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;

	}

	// http://localhost:8080/escola/estudiants/getAll
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> result = null;

		try {
			List<Estudiant> estudiantDb = estudiantService.getAll();
			result = ResponseEntity.status(HttpStatus.OK).body(estudiantDb);

		} catch (Exception e) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return result;

	}

}
