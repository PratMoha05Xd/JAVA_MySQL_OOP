package dam.mp06.uf02.p11.poo.escola.controllers;

import java.util.List;

import dam.mp06.uf02.p11.poo.escola.model.domain.Administratiu;
import dam.mp06.uf02.p11.poo.escola.model.service.IAdministratiuService;
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


@RestController
//http://localhost:8080/escola/administratius
@RequestMapping("/escola/administratius")
public class AdministratiuController {

    @Autowired
    IAdministratiuService administratiuService;

    // http://localhost:8080/escola/administratius/add
    @PostMapping("/add")
    public ResponseEntity<?> addAdministratiu(@RequestBody Administratiu administratiu) {

        ResponseEntity<?> result = null;

        try {
            Administratiu administratiuDb = administratiuService.add(administratiu);
            result = ResponseEntity.status(HttpStatus.OK).body(administratiuDb);

        } catch (Exception e) {
            result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return result;

    }

    // http://localhost:8080/escola/administratius/update
    @PutMapping("/update")
    public ResponseEntity<?> updateAdministratiu(@RequestBody Administratiu administratiu) {

        ResponseEntity<?> result = null;

        try {
            Administratiu administratiuDb = administratiuService.update(administratiu);

            result = ResponseEntity.status(HttpStatus.OK).body(administratiuDb);

        } catch (Exception e) {
            result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return result;

    }

    // http://localhost:8080/escola/administratius/delete/id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdministratiu(@PathVariable int id) {

        ResponseEntity<String> result = null;

        try {
            administratiuService.delete(id);

            result = ResponseEntity.status(HttpStatus.OK).body("Operació realitzada");

        } catch (Exception e) {
            result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return result;
    }

    // http://localhost:8080/escola/administratius/getOne/23
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getAdministratiu(@PathVariable int id) {

        ResponseEntity<?> result = null;

        try {
            Administratiu administratiuDb = administratiuService.findById(id);

            if (administratiuDb != null) {
                result = ResponseEntity.status(HttpStatus.OK).body(administratiuDb);
            } else {
                result = ResponseEntity.status(HttpStatus.NOT_FOUND).body(administratiuDb);
            }

        } catch (Exception e) {
            result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return result;

    }

    // http://localhost:8080/escola/administratius/getAll
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        ResponseEntity<?> result = null;

        try {
            List<Administratiu> administratiuDb = administratiuService.getAll();
            result = ResponseEntity.status(HttpStatus.OK).body(administratiuDb);

        } catch (Exception e) {
            result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return result;
    }

}
