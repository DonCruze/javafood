package uz.chayxana.javafood.type;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private final TypeRepo typeRepo;

    public TypeService(
            TypeRepo typeRepo
    ) {
        this.typeRepo = typeRepo;
    }

    public List<Type> findAll() {
        return typeRepo.findAll();
    }



    public  ResponseEntity<?> add(Type type) {
        try {
            return new     ResponseEntity(typeRepo.save(type), HttpStatus.OK);
        } catch (DataIntegrityViolationException divEx) {
            System.out.println(divEx.getMessage());
            return new ResponseEntity("Nazvanie odinakovie", HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity("Chto to pashlo ne tak", HttpStatus.BAD_REQUEST);
        }
    }

}
